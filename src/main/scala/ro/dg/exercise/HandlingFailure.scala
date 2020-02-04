package ro.dg.exercise

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  def unsafeMethod(): String = throw  new RuntimeException("No string")

  val potentialFailure = Try(unsafeMethod())

  println(potentialFailure.isSuccess)

  def backupMethod(): String = "A valid string"

  var fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallBackTry)

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterFallbackMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterFallbackMethod()
  println(betterFallback)


  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class  Connection {
    def get(url: String): String = {
    val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>"
      else throw new RuntimeException("connection interrupted")
    }
    def getSafe(url: String): Try[String] = Try(get(url))
  }
 object HttpService{
   val random = new Random(System.nanoTime())
   def getConnection(host: String, port: String): Connection = {
     if(random.nextBoolean()) new Connection
     else throw new RuntimeException("someone else took the port")
   }
   def getSafeConnection(host: String, port: String) : Try[Connection] = Try(getConnection(host, port))
 }
  println("Try http service")
  Try(HttpService.getConnection(hostname, port))
    .flatMap(conn => Try(conn.get("page")))
    .map(page => renderHTML(page))

  println("Try http service - safe")

  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHtml = possibleConnection.flatMap(conn => conn.getSafe("/home"))
  possibleHtml.foreach(renderHTML)

  println("Try http service - page")
  val tryPage = Try {
    val connection = HttpService.getConnection(hostname, port)
    connection.get("page")
  }
  tryPage.map(page => renderHTML(page))

  println("Try http service - page - safe")

  for {
    conn <- HttpService.getSafeConnection(hostname, port)
    html <- conn.getSafe("/home")
  } renderHTML(html)

}
