package ro.dg

import scala.collection.mutable

import scala.collection.mutable.ArrayBuffer

class Inheritance {

}

class CustomerInhe(val name: String, val address: String) extends Ordered[CustomerInhe]{
  private final val basket: ShoppingBasket = new ShoppingBasket

  def add(item: Item): Unit ={
    basket.add(item)
  }

  def total: Double = {
    basket.value
  }

  override def compare(that: CustomerInhe): Int = name.compare(that.name)

  override def toString: String = name + " $ " + total
}

class DiscountedCustomer(name: String, address: String) extends CustomerInhe(name, address){

  override  def total: Double = {
    super.total * 0.90
  }

}


class ShoppingBasket{
  import scala.collection.mutable.Seq
  private var _value: Double = 0d
  var items: Seq[Item] = ArrayBuffer.empty[Item]

  def add(item: Item ){
    items.+:(item)
    _value += item.value
  }

  def value: Double = _value

}

class Item (val value: Double){

}

object Main {
  def main(args: Array[String]): Unit = {
    val cust = new CustomerInhe("Smith", "3 London")
    cust.add(new Item(20))
    cust.add(new Item(30))
    println("Total standard customer " + cust.total)

    val dcust = new DiscountedCustomer("Smith", "4 London")
    dcust.add(new Item(20))
    dcust.add(new Item(30))
    println("Total discount customer " + dcust.total)
  }
}


trait Sortable[A <: Ordered[A]] extends Iterable[A]{
  def sort: Seq[A] = {
    this.toList.sorted
  }
}


class Customers extends Sortable[CustomerInhe]{
  private val customers = mutable.Set[CustomerInhe]()

  def add(customer: CustomerInhe) = customers.add(customer)
  def iterator: Iterator[CustomerInhe] = customers.iterator

}

class CustomersSortableBySpend extends Customers{
  override def sort: scala.collection.immutable.List[CustomerInhe] = {
    this.toList.sorted((x: CustomerInhe, y: CustomerInhe) => x.total.compare(y.total))
  }

  implicit def OrderingToFunction[A](function: (A,A) => Int): Ordering[A] = {
    new Ordering[A]{
      override def compare(x: A, y: A): Int = function.apply(x,y)
    }
  }
}


object CustomersMain {
  def main(args: Array[String]): Unit = {
    val customers = new Customers()
    customers.add(new CustomerInhe("Fred", "3 London"))
    customers.add(new CustomerInhe("Velma", "3 London"))
    customers.add(new CustomerInhe("Daphne", "3 London"))
    customers.add(new DiscountedCustomer("Norville", "4 London"))
    println(customers.sort)
    /////
    val customersBySpend = new CustomersSortableBySpend()
    val fred = new CustomerInhe("Fred", "3 London")
    fred.add(new Item(10))
    customersBySpend.add(fred)

    val velma = new CustomerInhe("Velma", "3 London")
    velma.add(new Item(5))
    customersBySpend.add(velma)

    customersBySpend.add(new CustomerInhe("Daphne", "3 London"))

    val norville = new DiscountedCustomer("Norville", "4 London")
    norville.add(new Item(30))
    customersBySpend.add(norville)

    println(customersBySpend.sort)
  }
}


