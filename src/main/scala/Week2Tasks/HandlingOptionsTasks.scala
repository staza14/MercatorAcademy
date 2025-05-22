package Week2Tasks

object HandlingOptionsTasks extends App{

  /* MVP
1. John from primary school maths is trying to buy as many watermelons as possible and we need to
give him a reality check. John can reasonably carry 3 watermelons without a bag, and 5 with one
bag.
*/



//  a) Create a value to store a number of watermelons.
  val numWatermelons: Int = 5
//    b) Use your Scala knowledge to print appropriate messages based on the criteria above to tell
//  John whether he
//    i. Doesn't need a bag
//    ii. Needs a bag
//  iii. Can't carry them
//  Be sure to consider how you will handle invalid numbers.
//  c) Use string interpolation to add to each message the number of watermelons John is trying to
//    buy.
println("1b/c:")
  numWatermelons match {
    case numWatermelons if numWatermelons < 0 => println(s"$numWatermelons! There seem to be less the zero watermelons, none for you to buy. ")
    case numWatermelons if numWatermelons < 4 => println(s"There are $numWatermelons watermelons. You won't need a bag.")
    case numWatermelons if numWatermelons <= 5 => println(s"You'll need a bag to cary $numWatermelons watermelons.")
    case _ => println(s"Sorry John, $numWatermelons is too much for you to cary.")
  }
//      d) Create a value to store a `Boolean` that indicates whether John has a bag with him or not.
  val hasBag: Boolean = false

//    e) Use an if/else statement and this `Boolean` value to tell John whether he can or cannot by the
//  desired number of watermelons in Task 1.
// I think I would actually do a nested if statement here instead of using &&

  println("\n1.e:")
  if (numWatermelons < 0) {
    println(s"$numWatermelons! There seem to be less the zero watermelons, none for you to buy. ")
  } else if (numWatermelons < 4){
    println(s"There are $numWatermelons watermelons. You won't need a bag.")
  } else if (numWatermelons <= 5 && hasBag){
    println(s"You'll need a bag to cary $numWatermelons watermelons. Looks like you have one, nice!")
  } else if (numWatermelons <= 5 && !hasBag) {
    println(s"You'll need a bad to cary $numWatermelons watermelons. Come back when you have one.")
  } else {
    println(s"Sorry John, $numWatermelons is too much for you to cary.")
  }

  /*
  2. A person is paid £0.45 per mile travelled. When they input their miles travelled it goes in as a
  `String` (e.g. “twenty”). Given the distance inputted, calculate the amount to be paid back being
  sure to use try/catch to account for errors.
   */

  println("\n2:")
  try {
    val miles = "twenty".toInt
    val total: Double = miles * 0.45
    println(s"You will be paid back: £$total")
  } catch {
    case e: NumberFormatException => println(s"$e is not a valid input for miles")
  }

  // EXTENSION

  /*
  Logical operators used in IF statements (e.g., && or <) have an order of precedence.
  1. What is this order, where can we find it?

  From the scala docs:
  ** Characters are listed below in increasing order of precedence, with characters on the same line having the same precedence.
  |
^
&
= !
< >
:
+ -
* / %


   */
  println("\n----------extension-----------")
//    2. What would (true || false && false) result in?
// I think this will result in true, but the && is done first
  println(s"2. ${true || false && false}")
//    3. What about ((true || false) && false)? (Note the parentheses used here.)
// I think this will be false, the () mean we do that first
  println(s"2. ${((true || false) && false)}")
//    4. And finally, how about (1 < 4 && 7 != 10 || 9 + 10 == 21)?
// < is first and then != then & so true on the left side then + then == so false on the right and then lastly the OR
// So we end up with true || false ---> true
  println(s"3. ${(1 < 4 && 7 != 10 || 9 + 10 == 21)}")
  println("------------------------------")

  /* RESEARCH
  If statements always return values. This means we can assign values based on if statements.
  How would we go about doing this, or where could we search to find out?
   */

//  1. Create two values that hold integers. Assign any integer you'd like to these values.

val num1: Int = 100
val num2: Int = 11

//  2. Create a new value of type `String` and assign it "yes" if the first value is greater than the second,
//  and "no" if the second value is greater. (Don’t overthink this!)

val oneGreaterThenTwo: String = if (num1 > num2) "yes" else "no"
  println("\n----------research-----------")
  println(s"num1 = $num1")
  println(s"num2 = $num2")
  println(s"Is num1 greater then num2 ---> $oneGreaterThenTwo ")
}
