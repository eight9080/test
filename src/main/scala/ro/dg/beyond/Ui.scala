package ro.dg.beyond

class Ui {

  def updateUiElements(): Unit = {

    runInThreadGroup("basket") {
      discount()
      updateCustomerBasket()
    }
    runInThreadGroup("customer") {
      updateOffers()
    }

    ////////////

    runInThread {
      discount()
      updateCustomerBasket()
    }
    runInThread{
      updateOffers()
    }

  }

  def runInThreadGroup(group: String) (function: => Unit): Unit ={
    new Thread(new ThreadGroup(group), new Runnable {
      override def run(): Unit = function
    }).start()
  }


  def runInThread(function: => Unit): Unit ={
    new Thread(){
      override def run(): Unit = function
    }.start()
  }

  private def discount(): Unit = {
    println("discount")
  }

  private def updateCustomerBasket(): Unit = {
    println("update customer basket")
  }

  private def updateOffers(): Unit = {
    println("update offers")
  }

}

object Ui {
  def main(args: Array[String]): Unit = {
    new Ui().updateUiElements()
  }


}
