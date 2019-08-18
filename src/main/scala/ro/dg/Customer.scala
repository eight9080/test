package ro.dg

import java.util.logging.Level

class Customer(forename: String, initial: String = "", surname: String) {
  val fullname = if (initial != null && !initial.isEmpty)
    forename + " " + initial + ". " + surname
  else
    forename + " " + surname

//  def this(forename: String, surname: String) {
//    this(forename, "", surname)
//  }

}

object Customer{
  def main(args: Array[String]): Unit = {
    new Customer("Bob", "J", "Smith")
    new Customer("Bob", surname="Smith")
  }
}


class Counter {
  private var count = 0

  def increment(): Unit = {
    count += 1
  }

  def getCount = count

}


object Logger {
  def log (level: Level, string: String): Unit ={
    printf("%s %s%n", level, string)
  }

  def main(args: Array[String]): Unit = {
    Logger.log(Level.INFO, "Scala Version")
  }

}


class Customer1 private (val name: String, val address: String){
  private val id = Customer1.nextId()
}

object Customer1{
  def apply(name: String, address: String) = new Customer1(name, address)

  private var sequenceOfIds = 0

  private def nextId() = {
    sequenceOfIds +=1
    sequenceOfIds
  }

  def main(args: Array[String]): Unit = {
    Customer1.apply("Bob Fossil", "1 London Road")
    Customer1("Jane Fossil", "2 London Road")

  }
}
