object ScalaTypeValuesOperatorsTask extends App {
/* MVP

1. Before coding, decide if the answer will be true or false. Then store the values in a function that
can be printed and use operators evaluate the following:
 */

//  a) Three plus four, times fifty-seven is less than three-hundred
// should be false
  val lessThan: Boolean = (3 + 4) * 57 < 300
  println(s"a: $lessThan")

//  b) One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
// should be true
  val greaterThanOrEqualTo: Boolean = (144 / 12) >= 12
  println(s"b: $greaterThanOrEqualTo")

//  c) Cat is less than Dog (strings)
//  println("Cat" < "Dog")  // true
//  println("Cat" > "Dog")  // false
//  println("cat" < "Dog")  // false
//  println("cat" > "Dog")  // true

// Scala compares strings lexicographically based on Unicode/ASCII values
// This is case sensitive
  val catDog: Boolean = "Cat" < "Dog"
  println(s"c: $catDog")

//  d) Rabbit is less than Hamster (strings)
// should be true
  val rabbitHamster: Boolean = "Rabbit" > "Hamster"
  println(s"d: $rabbitHamster")

//  e) Seventeen is odd (modulus)
// should be true
  val isOdd: Boolean = (77 % 2)  != 0
  println(s"e: $isOdd")

//  f) Seventy-five divided by nine is less than thirty and eighty-nine divided by six is less than twenty
// should be true
  val andOperator: Boolean = (75 / 9) < 38  && (89 / 6) < 20
  println(s"f: $andOperator")

/*
  2. What is the difference between the `String` “I love scala already” and the print line “println (“I
  love scala already”)”?

  The difference is that the string is a piece of data that we have stored in a value. It does nothing on its own
  but we can use it in an operation.

  The print line is a function call, we are using the println function and passing "I love scala already" as an argument
 */

/*
  3. Write a method to calculate the square of an `Int`. It should have an `Int` input parameter and
  `Int` return type.
 */

  def square(number: Int): Int = {
    number * number
  }

  println(square(2))

  /*
    4. Write a method to check if a number is odd. It should have an `Int` input parameter and®
  `Boolean` return type.
  */

  def isOdd(number: Int): Boolean = {
    number % 2 != 0
  }

  println(isOdd(5))

  /*
  Consider a Library, there are many books. Write a Class called ‘Book’. What class parameters
  will your book need? Can you include any class methods in the body? Can you consider type
  sensitivity in your class parameter(s) type(s) (and what needs to be made here if you do…)?
   */

  class Book(val title: String, val author: String, val pages: Int) {
    def checkout: String = s"Enjoy $title"
  }
  val book: Book = new Book("Earthlings", "Sayaka Murata", 200)
  println(book.checkout)
}
