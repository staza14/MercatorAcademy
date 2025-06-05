import Week2CodeAlongs.Calculator
import org.scalatest.flatspec.AnyFlatSpec

class CalculatorSpec extends AnyFlatSpec{

  // initializing a new instance of our calculator class
  val calc = new Calculator

  // test for add method

  "add" should "add numbers" in {
      val input = calc.add(2,5)
      val expectedResult: Int = 7
      assert(input == expectedResult) // returns a boolean
    // could be assert(calc.add(2,5) ==7)
  }

  "multiply" should "multiply numbers" in {
      val input = calc.multiply(2,4)
      val expectedResult: Int = 8
      assert(input == expectedResult)
  }

  "subtract" should "subtract second input from first" in {
    val input = calc.subtract(10,9)
    val expectedResult: Int = 1
    assert(input == expectedResult)
  }

  "divide" should "divide first number by second" in {
    val input = calc.divide(9,3)
    val expectedResult: Int = 3
    assert(input == expectedResult)
  }
}
