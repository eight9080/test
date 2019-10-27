
import scala.collection.JavaConversions._

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

  //Collections
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

  for (value <- list1) println(value)


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


  //String interpolation
  s"If i insert something $a here will print"

  s"$a is bigger than $b with: ${a - b}"

  val firstLetter = "Hello".charAt(0)

  //Iterate through string
  val text1 = raw"This is the new world\n beautiful word"
  text1.foreach(a => print(a))

  ///Numbers

  scala.math.max(2, 3)

  //functions
  def add(first: Int, second: Int): Int = {
    first + second
  }

  add(5,5)

  def add(first: Int, second:Int, third: Int): Int = {
    println("Adding")
    first + second + third
  }

  add(1,2,3)

  //varargs
  def addMany(numbers: Int*):Int = {
    numbers.reduce(_ + _)
  }

  addMany(1,2,3)
  addMany(3,4,5,2)

  def describeNumberofBits(number: Int) : String={
    number match{
      case bit if bit <4 => "bit"
      case nibble if nibble <8 => "nibble"
      case byte if byte <1023 => "byte"
      case manybyte => "manybyte"
    }
  }

  describeNumberofBits(3)
  describeNumberofBits(8)
  describeNumberofBits(7)
  describeNumberofBits(1024)

  //NUll  / Option - Some None
  Some("text")

  var myText: Option[String] = None
  myText = Some("text2")

  myText match {
    case Some(text) => println("I have text " + text)
    case None => print("I have no text")
  }

  var myNoneText = None

  val altText: String = myNoneText orElse myText getOrElse "default"




}
