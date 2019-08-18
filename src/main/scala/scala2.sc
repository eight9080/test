import java.util.logging.Level

class Customer(val name: String, val address: String = "abc"){
  private var _id = ""

  def id = _id

  def id_=(value: String){
    if(_id.isEmpty)
      _id = value
  }

  def this(name: String){
    this(name, "")
  }
}

object Customer {
  def main(args: Array[String]): Unit = {
    val cust1 = new Customer("John", "20 Andal Road")
    //cust1.id_=("123")
    cust1.id = "123"


  }
}

object Logger{
  def log(level: Level, string: String): Unit ={
    print("%s %s%n", level, string)
  }
}