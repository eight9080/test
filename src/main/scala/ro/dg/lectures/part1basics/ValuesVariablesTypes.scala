package ro.dg.lectures.part1basics

object ValuesVariablesTypes extends App {


  val x = 42
  println(x)

  //vals are immutable
  //x=2 not allowed
  //compiler can infer type

  val aString: String = "hello"
  val anotherString: String ="goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt:Int = x

  val aShort: Short = 4613
  val aLong: Long = 1231231214134234L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables
  var aVariable: Int = 4
  aVariable = 5 //side effects






}
