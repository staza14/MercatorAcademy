object ScalaTypeValuesOperatorsTask extends App {
/* MVP

Before coding, decide if the answer will be true or false. Then store the values in a function that
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
}
