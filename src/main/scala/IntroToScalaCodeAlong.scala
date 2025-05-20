object IntroToScalaCodeAlong  extends App {

  // declaring a value or "val".. an immutable place to store data
  // var - or variables are mutable.. less safe
  // option command l to reformat code

  val melons = 5 * 50
  val apples = 2 * 10
  val fizzyDrinks = 6 * (100*1.20)
//  val total = melons + apples + fizzyDrinks

  // VAR way to do it - not best practice because vars are mutable


  var total: Double = 0
  total = total + apples
  // s string to interpolate
  // to print
  println(s"The current total is: $total")
  total = total + melons
  println(s"The current total is: $total")
  total = total + fizzyDrinks
  println(s"The current total is: $total")

  println(s"The final total is: $total")

  // TYPES
  // Like a label to define what type of data we are storing
  val wholeNumber: Int = 1863
  val littleNumber: Short = 66 // This us rare, generally just use INT
  val bigNumber: Long = 354748462538498L  // Must put the L on the end

  val littleDecimal: Float = 2.64f // Must put the f on the end otherwise it is a double -- this is rarely used
  val decimal: Double = 4653.33 // Most common thing to use

  val test: String = "This is a string!"

  val trueFalse: Boolean = true // or false - lowercase!

  // OPERATORS

  val a: Int = 10
  val b: Int = 4
  val c: Int = 3

  // Arithmetic
  val add: Int = a + b
  val subtract: Int = a - b
  val divide: Double = a / b
  val multiply: Int = a * b
  val modulus: Int = a % b

  // Comparison / Relational
  val equality: Boolean = a == a
  val inequality: Boolean = a != b
  val lessThan: Boolean = b < c
  val lessThanEqualTo: Boolean = a <= c
  val greaterThan: Boolean = b > c
  val greaterThanEqualTo: Boolean = a >= b

  // Logical
  val and: Boolean = true && true
  val or: Boolean = true || false
  val not: Boolean = !false

  //FUNCTIONS + METHODS
  // both are names pieces of code that we can reuse them by calling them by name
  // function - it can be declared or assigned to a val or even passed into another function or returned by a function
  // method - must use the keyword def, can be overwritten with a different implementation, cannot have an anonymous method, it must have a name!

  /*
    def nameOfMethod(parameters, but this can be empty): ReturnType = {
      <expression 1>
      <expression x..>
      <last expression results in a value that is of the same type as the ReturnType>
    }

    ** the last line is what is returned by the method and the type but match the methods return type
   */

  def makeACupOfTea(sugar:Int, milk:Boolean): String = {
    s"You have made a cup of tea with $sugar spoons of sugar. Your milk selection is: $milk."
  }
  // to call 
  println(makeACupOfTea(5,true))

  val vat: Double = 1.2

  // Write me a method that calculates the final price of a product with VAT.
  def vatCalculator(productPrice: Double): Double = {
    (productPrice * vat) + productPrice
  }

  println(vatCalculator(1.0))

  // CLASSES
  // like instructions or blueprints - can also be used as types!
  // They have properties and behaviors

  /*
  class ClassDefinition(classParameters: String) {
    // optional class Body
    // fields and methods go here - collectively called members
    // Must give default values
  }

  ex:
  class Hamster(val age: Int, val weightInGrams: Int, val colour: String)
  // That class definition has no body

  val BooTheHamster: Hamster = new Hamster(1, 133, "orange"
   */

   // class definition aka instructions or blueprint
  class Dog(val name: String, val age: Int, val likesBananas:Boolean) {
     // Can have default parameters like..
     val hasEars: Boolean = true
    def speak:String = "woof"
  }

  // Use the class to make objects!
  val loki: Dog = new Dog("loki", 3, true)
  println(loki.name)
  println(loki.speak)
}