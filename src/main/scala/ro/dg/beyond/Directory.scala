package ro.dg.beyond

class Directory {
  private val numbers = scala.collection.mutable.Map(
    "Athos" -> "7781 123",
    "Aramis" -> "7782 123",
    "Porthos" -> "7783 123",
    "D'artagnan" -> "7784 123"
  )

  def apply(name: String)= {
    numbers.get(name)
  }

  def update(name: String, number: String): Unit ={
    numbers.update(name, number)
  }

  def update(areaCode: Int, newAreaCode: String) = {
    numbers.foreach(entry => {
      if(entry._2.startsWith(areaCode.toString))
        numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode)
    })
  }

  override def toString: String = numbers.toString()

}

object Directory {
  def main(args: Array[String]): Unit = {
    val yellowPages = new Directory()
    println("Athos' phone  number : "+ yellowPages("Athos"))
    yellowPages("Athos")="6681 123"
    println("Athos' phone  number : "+ yellowPages("Athos"))
    println(yellowPages)
    yellowPages(6681) = "7555"
    println(yellowPages)

  }
}
