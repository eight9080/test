package ro.dg.lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else {
      println("Computing "+n+"needed "+(n-1))
      val result = n * factorial(n - 1)
      println("Fact "+n)
      result
    }

  println(factorial(5))


  def anotherFactorial(n:Int):BigInt = {

    def factHelper(x:Int, accumulator: BigInt):BigInt =
      if(x==1) accumulator
      else factHelper(x-1, x*accumulator)//tail recursive - last expression

    factHelper(n,1)
  }

  println("Fact 10: "+anotherFactorial(10))

  //when you need loops use tail recursion

  //1. concatenate a string n times
  def repeatString(s: String, n: Int): String ={
    @tailrec
    def conHelper(s:String, n:Int, accumulator:String): String = {
      println("Calling "+s+" "+n)
      if(n<=0) accumulator
      else conHelper(s, n-1, s+accumulator)
    }
    conHelper(s, n, "")
  }

  println("Repeat text: "+repeatString("text", 3))
  println("Repeat text: "+repeatString("text", 2))

  //2. isPrime
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime:Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t-1, n%t !=0 && isStillPrime)

    isPrimeUntil(n/2, true)
  }
  println("Is prime 2 " + isPrime(2))
  println("Is prime 5 " + isPrime(5))
  println("Is prime 6 " + isPrime(6))

  //3. fibonacci
  def fibonacci(n: Int): Int ={
    @tailrec
    def fibHelper(i:Int,last:Int, nextLast:Int):Int = {
      if (i>=n) last
      else fibHelper(i+1, last+nextLast, last )
    }
  if(n<=2) 1
    else fibHelper(2,1,1)
  }

  println("Fibonacci 2 " + fibonacci(2))
  println("Fibonacci 4 " + fibonacci(4))


}
