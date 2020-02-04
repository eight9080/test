package ro.dg.exercise

import scala.util.Random

object OptionExercise  extends App{

  val config: Map[String, String] = Map(
    "host" -> "177.23.12.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String) : Option[Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(hostValue => port.flatMap(portValue => Connection(hostValue, portValue)))
  val connectionConnectStatus = connection.map(conn => conn.connect)
  connectionConnectStatus.foreach(println)
  println(connection)

  println("Chain Solution")
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(conn => conn.connect))
    .foreach(println)

  println("For comprehensions")
  val connStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connStatus.foreach(println)
}

