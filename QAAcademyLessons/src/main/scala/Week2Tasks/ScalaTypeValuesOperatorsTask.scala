package Week2Tasks

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
  5. Consider a Library, there are many books. Write a Class called ‘Book’. What class parameters
  will your book need? Can you include any class methods in the body? Can you consider type
  sensitivity in your class parameter(s) type(s) (and what needs to be made here if you do…)?

  Type safety ---> If our class has multiple parameters that have the same type, ie multiple strings in my book class
  then we can make them their own classes. This is type safety. These classes can be used elsewhere which may be
  useful.
  ex:
  class Book (title: Title, genre: Genre, pageCount:Int){
  }
  class Title (title: String)
  class Genre (genre: String)
   */

  class Book(val title: String, val author: String, val pages: Int) {
    def checkout: String = s"Enjoy $title"
  }
  val book: Book = new Book("Earthlings", "Sayaka Murata", 200)
  println(book.checkout)


  // EXTENSION

  // 1. Convert a lowercase `String` to uppercase.
  val word: String = "anastasia"
  println(word.toUpperCase)

  // 2. Convert the first letter of a `String` to uppercase.
  println(word.capitalize)

  // 3. “STRING” == “string” Is this true or false? Why?
  // I'm pretty sure this operator is case sensitive so we should get false

  val isEqual = "STRING" == "string"
  println(isEqual)

  // 4. Can you simply convert the `String` “one” to the `Int` 1?
  // Not simply, we could use .toInt if it was "1" in quotes like a string

  // 5. Can you simply convert the `Int` 1 to `String` “one”?
  // Same as above, we could use .toString but this would give us "1" not "one"

  // 6. Can you simply convert `Int` 1 to type `String`? Is the result as you would expect?
  // yes you can! if you use .toString on an int, it will change the type, but can we do this on a val??
  // We would probably need to save it to a new value

  // RESEARCH

  // 1. Make a val called new which is type string. Why doesn’t this compile?
  // I get the error - illegal start of simple pattern
  // new is a reserved keyword, like def and class. It is used to make new instances of classes

  //  val new: String = "Hello"

  // 2. What do we need to do within our code to make it compile? Are there any other words that you cannot use?
  // the best thing to do would be to use a different name, one that is not reserved.
  // Other examples are class, var, val, object, def, null, true, false and more

  /*
   3. Investigate how a `case class` is different to a `class`. When might you use each one?

   A class - the "instructions"for defining objects in Scala. Use it when you want full control over the class behavior.
   ** when we try printing an object, its not very readable
   - use when you want to control all class internals yourself and you want complex behavior

   From my research, a class case kind of seems like a shortcut for making a class, its very generic but has some built
   in functions that you dont need to define. Sone characteristics:
   - case classes have an apply function auto-generated by the compiler so we don't need the keyword new
   when creating a new instance
   - Pattern matching
   - Auto-Generated Methods
   - Case classes have a copy method generated by default
   - These should look nicer when printed
   - .equals and .hashCode for comparing
   - use when you want quick, readable data containers
   */
}
