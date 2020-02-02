package ro.dg.exercise

abstract class MyList[+A] {

  def head : A
  def tail : MyList[A]

  def isEmpty: Boolean
  def add[B>:A](element: B): MyList[B]
  def printElements : String

  override def toString: String = "["+ printElements+"]"

}

object Empty extends MyList[Nothing]{
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons[+A](h:A, t: MyList[A]) extends MyList[A]{

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B>:A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if(t.isEmpty) ""+h
    else h +" "+t.printElements
}

object ListTest extends App{

//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(5).head)
//  println(list.isEmpty)
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfString: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfString.toString)

}