package ro.dg.math
class MathUtilsTest extends org.scalatest.FunSuite {

  test("subtractProductAndSum") {

    val result = MathUtils.subtractProductAndSum(234)
    assert(result == 15)
  }

}
