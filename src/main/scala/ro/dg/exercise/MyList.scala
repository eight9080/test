package ro.dg.exercise

abstract class MyList[+A] {

  def head : A
  def tail : MyList[A]

  def isEmpty: Boolean
  def add[B>:A](element: B): MyList[B]

  def printElements : String
  override def toString: String = "["+ printElements+"]"

  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def filter(predicate: MyPredicate[A]) : MyList[A]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def ++[B>:A](list: MyList[B]) : MyList[B]

}

object Empty extends MyList[Nothing]{
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h:A, t: MyList[A]) extends MyList[A]{

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B>:A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if(t.isEmpty) ""+h
    else h +" "+t.printElements

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons[B](h, t++list)
  }

}

trait MyPredicate[-T]{
  def test(value: T): Boolean
}
class EvenPredicate extends MyPredicate[Int]{
  override def test(value: Int): Boolean = if(value==0) true else value%2==0
}


trait MyTransformer[-A, B]{
  def transform(value: A): B
}

class StringToInt extends MyTransformer[String, Int]{
  override def transform(value: String): Int = value.toInt
}

object ListTest extends App{

//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(5).head)
//  println(list.isEmpty)
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfString: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfString.toString)
  val newListOfAnimals = listOfIntegers.add(4.0)
  println(newListOfAnimals.toString)
  println(newListOfAnimals.getClass)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(value: Int): Int = value * 2
  }).toString)

  println(listOfIntegers++anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(value: Int): MyList[Int] = new Cons[Int](value, new Cons[Int](value+1, Empty))
  }).toString)

}