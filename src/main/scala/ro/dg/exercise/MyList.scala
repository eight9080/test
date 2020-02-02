package ro.dg.exercise

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit

  def sort(comparator: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B,A)=> B): B

}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(comparator: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = {start}

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons[B](h, t ++ list)
  }

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(comparator: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (comparator(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(comparator)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = {
     t.fold(operator(start, h))(operator)
  }
}

//trait MyPredicate[-T]{
//  def test(value: T): Boolean
//}
//class EvenPredicate extends MyPredicate[Int]{
//  override def test(value: Int): Boolean = if(value==0) true else value%2==0
//}


//trait MyTransformer[-A, B]{
//  def transform(value: A): B
//}

//class StringToInt extends MyTransformer[String, Int]{
//  override def transform(value: String): Int = value.toInt
//}




object ListTest extends App {

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

  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(_ % 2 == 0))

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(value => new Cons[Int](value, new Cons[Int](value + 1, Empty))).toString)

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((a, b) => b - a).toString)

  println(anotherListOfIntegers.zipWith[String, String](listOfString, _+"-"+_))
  println(listOfIntegers.fold(1)((a,b) => a+b))

  //for comprehensions
  val combinations = for {
    n <-listOfIntegers
    string <-listOfString
  } yield n +"---"+ string
  println(combinations)

  //  def concatenator: (String, String) => String = new Function2[String, String, String] {
  //    override def apply(v1: String, v2: String): String = v1+v2
  //  }
  //  println(concatenator("1","20"))

}