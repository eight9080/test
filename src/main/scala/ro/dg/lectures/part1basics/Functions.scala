package ro.dg.lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("Value", 2))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  printf(aRepeatedFunction("hello", 3))
  //when you need loos use recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  // 1. greet function (name, age) => "Hi myname is $name and I am $age years old
  def greet(name: String, age: Int): Unit =
    println("Hi, my name is " + name + "and I am " + age + " years old")

  greet("a", 1)

  //2. a factorial function
  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println("Fact 2 " + factorial(2))
  println("Fact 4 " + factorial(4))

  //3. a fibonacci function
  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println("Fibonacci 2 " + fibonacci(2))
  println("Fibonacci 4 " + fibonacci(4))

  //4. test if number is prime
  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n%t !=0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println("Is prime 2 " + isPrime(2))
  println("Is prime 5 " + isPrime(5))
  println("Is prime 6 " + isPrime(6))
}
