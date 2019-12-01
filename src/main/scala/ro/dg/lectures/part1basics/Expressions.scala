package ro.dg.lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3

  //instructions(do) vs expressions (value)

  //if condition
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //bad example

  //everything in scala is an expression

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  //code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  val someValue = {
    2 < 3
    smallFun()
    42
  }

  println("Some value "+ someValue)

 def smallFun(): String = {
   println("inside small fun")
   "String"
 }
}
