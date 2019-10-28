

object sheet1 {


  class Family(val name:String, val peopleNames: Seq[String]){
    private var descriptionCalls:Int = 0
    def description: String = {
      descriptionCalls += 1
      s"$name +[${peopleNames.mkString(",")}]: $descriptionCalls"

    }
  }

  val fam = new Family("Sal", Seq("anton", "cleo"))

  fam.name
  fam.description

  trait Nameable{
    def name: String
  }


  class  ModernFamily(name: String, peopleNames: Seq[String]) extends Family(name, peopleNames) with Nameable {
    def modernDescription = description.replaceAll("e", "3")

  }

  val modernFamily = new ModernFamily("Mod", Seq("cam", "ben"))
  modernFamily.modernDescription

  trait Placeable {
    def place: String
  }

  trait Moveable extends Placeable{
    def moveTo(place: String): Unit
  }


  class  Person(val name: String, var place: String) extends Nameable with Moveable{
    def moveTo(newPlace: String): Unit = {
      this.place = newPlace
    }

  }

  val aPerson = new Person("Antonio", "Canada")
  aPerson.place
  aPerson.name
  aPerson.moveTo("Australia")
  aPerson.place




}
