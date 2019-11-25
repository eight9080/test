val myList: List[Int] = List(1,2)
myList match {
  case List(a,b) => a+b
}

val myList2: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
myList2 match {
  case a :: b :: rest =>
    println(rest)
    a + b
}

val mySeq: Seq[Int] = Seq(1,2,3,4)
//matches only a,b the rest is ignored
mySeq match {
  case Seq(a,b, rest @ _*) =>
    println(rest)
    a+b
}


//case classes

class Animal(val name: String,val age: Int,val species: String)

val an= new Animal("Santiago", 12, "Cat")

case class AnimalCase (name: String, age: Int, species: String)

val animalCase = AnimalCase("Santiago", 12, "Cat")
def describeAnimalCase(animalCase: AnimalCase): String = {
  animalCase match {
    case AnimalCase(name, age, "Cat") if age>10=>
      s"$name is an old meowie friend who is ${age} years old."
    case AnimalCase(name, age, "Cat")=>
      s"$name is an old meowie friend who is ${age} years old."
    case AnimalCase(name, age, "Dog") =>
      s"$name is a wofie friend who is ${age} years old."
    case  AnimalCase(name, age, species)  =>
      s"$name is a $species, they will be ${age+1} years old."
  }
}

describeAnimalCase(animalCase)
describeAnimalCase(AnimalCase("Cleo", 18, "Dog"))

describeAnimalCase(animalCase.copy(age=8))

case class Classification(genus:String, species: String)

val cat = Classification("felix", "felicis")
case class AnimalClassification(name: String, age: Int, classification: Classification)



