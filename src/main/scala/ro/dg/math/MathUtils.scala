package ro.dg.math

object MathUtils {

  def subtractProductAndSum(n: Int): Int = {

    val digits = n.toString.map(_.asDigit).toList
    digits.product-digits.sum
  }

}
