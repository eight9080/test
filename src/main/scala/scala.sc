

object sheet1 {

  println("Welcome")

  val language: String = "Scala"

  def min(x: Int, y: Int): Int = {
    if (x < y)
      x
    else
      y
  }

  min(34, 3)

  val list = List("a", "b", "c")
  val map = Map(1 -> "a", 2 -> "b")

  println("List values")
  list.foreach(value => println(value))

  for (value <- list) println(value)

  for (value <- list.reverse) println(value)

  val answer = 8 * 5 + 2

  var response = 42
  response = 23

  val list1 = new java.util.ArrayList[String]
  list1.add("1")
  list1 add "2"

  for(value <- list1) println(value)


  



  var greeting: String = null
  greeting = "Test"

  1.to(10)

  "Hello".intersect("World")

  1 to 10

  val a = 6 * 7
  a

  val b: BigInt = 21;
  b.pow(2)

  import scala.math._

  sqrt(10) * sqrt(10)

  1.to(10).map(sqrt(_))

}
