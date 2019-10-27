
import scala.collection.JavaConversions._

object sheet1 {

  val fileSizes: Seq[Int] = Seq(1024, 2048, 50, 692, 6400)

  fileSizes.foreach {
    filesize => println(filesize)
  }

  var fileSizeSum: Int = 0
  fileSizes.foreach {
    fileSize => fileSizeSum += fileSize
  }
  println(fileSizeSum)

  var doubleFileSizes = Seq[Int]()

  fileSizes.foreach {
    fileSize => doubleFileSizes :+ (fileSize * 2)
  }

  println(doubleFileSizes)

  fileSizes.foreach {
    filesize => doubleFileSizes :+= (filesize * 2)
  }
  println("Double filessize " + doubleFileSizes)

  val newDoubleSize = fileSizes.map {
    fileSize => fileSize * 2
  }
  println("Double filessize with map " + newDoubleSize)


  fileSizes.filter {
    fileSize => fileSize>=1024
  }

  //simplified version single parameter => _
  fileSizes.map(_ + 2)
  fileSizes.filter(_>1024)

  //returns an Option
  fileSizes.find(_ >= 1024)

  fileSizes.find(_ >=10024) orElse fileSizes.find(_>=2048)

  fileSizes.map {
    case kilobytes if kilobytes>=1024 => s"This file is ${kilobytes/1024.0} KB."
    case bytes if bytes<1024 => s"This file is $bytes"
  }


  //basic comprehensions

  case class Person(name: String, age: Int)
  case class Family(people: Seq[Person])

  val antonio = Person("Antionio", 40)
  val mary = Person("Mary", 40)
  val cleo = Person("Cleo", 16)
  val santiago = Person("Santiago", 12)

  val family1 = Family(Seq(antonio, mary, cleo, santiago))
  val john = Person("John", 43)
  val stacy = Person("Stacy", 42)
  val bryan = Person("Brian", 12)
  val betty = Person("Betty", 21)
  val loise = Person("Loise", 24)

  val family2 = Family(Seq(john, stacy, bryan, betty, loise))

  val families = Seq(family1, family2)

  family1.people.map(_.name)
  family2.people.map(_.name)

  families.map(_.people.map(_.name)).flatten

  families.flatMap(_.people.map(_.name))

  families.flatMap(_.people.filter(_.age>=18).map(_.name))

  //returns person's name that are at least 18
  for{
    family <- families
    person <-family.people
    if person.age >=18
  } yield {
    person.name
  }

  //find the first person from each family
  for{
    family <- families
    person <- family.people.find(_.age>=25)
  } yield {
    person.name
  }

  //returns an option
  for{
    oldFamily <- families.find(_.people.exists(_.age > 40))
    elder <- oldFamily.people.find(_.age>40)
  } yield {
    elder.name
  }

  for{
    family <- families
    person <-family.people
    canRentCar =  person.age >=18
    if canRentCar
  } yield {
    person.name
  }

  //reduce
  val numbers = Seq(1,2,3,4,5)
  numbers.reduce{ (a,b) => println(a+" , "+b); a+b }

  //"" -> default value for accumulator
  numbers.foldLeft("") { (accumulator, number) => accumulator+ " , "+number}
  //=> res24: String =  , 1 , 2 , 3 , 4 , 5

  numbers.foldLeft("")(_ + " , " + _)

  numbers.foldLeft(0)(_ + _)

  numbers.foldLeft(Seq[Int]())(_ :+ _)

  //get all intermediary sum
  numbers.foldLeft(Seq[Int]()){
    (sums: Seq[Int], number: Int) =>
      val latestSum = sums.lastOption getOrElse 0
      sums :+ (latestSum+number)
  }


  val family = Family(Seq(antonio, mary, cleo, santiago))
  var familyVersions = family.people.foldLeft(Seq[Family]()){
    (versions, person) =>
      val lastVersion = versions.lastOption
      val latestPeople = lastVersion.map(_.people) getOrElse Seq[Person]()
      versions :+ Family(latestPeople :+person)
  }

  numbers.foldRight(0)(_+_)

  numbers.foldRight(Seq[Int]())((number:Int, accumulator:Seq[Int]) => accumulator:+number)

  numbers.foldRight(Seq[Int]())(_ +: _)






}
