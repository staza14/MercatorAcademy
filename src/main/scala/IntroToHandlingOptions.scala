object IntroToHandlingOptions extends App{

  val weather:String = "sunny"
  val season:String = "summer"

  /* CONDITIONAL IF/ ELSE
    - when a decision is made based on something else
   */

  // key word if (what your conditional is) { code to execute in this case}
  // else if for more conditions , can have as many as you want
  // else will catch anything not already captured
  // When testing, we want to check that every path can be reached at minimum
  println("if/else with one variable: ")
 if (weather =="rainy") {
   println("Grab an umbrella!")
 } else if (weather == "sunny") {
   println("Don't forget to wear sunscreen :)")
 } else if (weather == "snowy") {
   println(" Stay warm. Wear a hat and gloves!")
 } else {
   println(" Sorry, I don't know that type of weather...")
 }

  // Let's add in the season
  println("\nif/else with two variables: ")
  if (weather =="snowy" || season == "winter") {
    println("Stay warm. Wear a hat and gloves!")
  } else {
    println("You should be fine with a light jacket.")
  }

  /* PATTERN MATCHING
  - works in a similar way to if/else
  - depending on the value matched, you execute a certain bit of code
 */

//  the variable you're comparing first, keyword match { case "condition" => what you want to do in this case}
  println("\npattern matching with one variable: ")
  weather match {
    case "rainy" => println("Grab an umbrella!")
    case "snowy" => println(" Stay warm. Wear a hat and gloves!")
    case "sunny" => println("Don't forget to wear sunscreen :)")
    case _  => println(" Sorry, I don't know that type of weather...")
  }

  // and again lets add in season
  println("\npattern matching with two variables: ")
  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter" => println("Grab an umbrella!")
    case _  => println(" You should be fine with a light jacket.")
  }

  // With int

  val age: Int = 0

  println("\nAge if else: ")
  if (age < 0){
    println(s"$age is not valid! Please enter you REAL age!")
  } else if(age >= 18){
    println(s"You are an adult because you are $age")
  } else {
    println(s"You are a child because you are $age")
  }

  // As a match case
  println("\nAge pattern matching: ")

  age match {
    case age if age < 0 => println(s"$age is not valid! Please enter you REAL age!")
    case age if age < 18 => println(s"You are a child because you are $age")
    case age if age >= 18 => println(s"You are an adult because you are $age")
  }

  /* Task
   work out for a given age what film ratings they can see, use pattern matching
   */

  val userAge = 4
  println("\nTask: ")
  userAge match {
    case userAge if userAge < 0 => println(s"$userAge isn't valid! Enter your real age.")
    case userAge if userAge < 4 => println(s"$userAge is too young for films, try cartoons!")
    case userAge if userAge < 8 => println(s"At $userAge you can watch films rated 'U'")
    case userAge if userAge < 12 => println(s"At $userAge you can watch films rated 'PG'")
    case userAge if userAge < 15 => println(s"At $userAge you can watch films rated '12A'")
    case userAge if userAge < 18 => println(s"At $userAge you can watch films rated '16'")
    case _ => println(s"At $userAge you can watch films rated 18")
  }

  /* OPTIONS
       - when we might have something information but we might not
       - this is a type
       - with these, we need to test that both returns are ok
   */

  val name: Option[String] = Some("Anastasia")
  val emptyName: Option[String] = None
  println(s"\n name: $name")
  println(s" empty name: $emptyName")

  // get or else is used if we want to return a default if None is returned
  // It will also take the Some away, leaving us with just the internals
  def getName(name: Option[String]): String = name.getOrElse("This user has left the field empty")

  println(s"\nget name with getOrElse: ${getName(name)}")
  println(s"get empty name with getOrElse: ${getName(emptyName)}")

  /* TRY/CATCH
     - lets us handle errors in our code without crashing
     ex: dividing by zero, converting strings to numbers, accessing files, bad input from a user

     try {
      // code that might fail
     } catch {
      case e: SomeException => println("Something went wrong!) <------ stops the code form crashing
     }
   */

  //We want someone to enter a number but they inputted a string...
  println("\n")
  try {
    // All logic goes here - could be if/else, pattern match etc
    // here we want to change the input from a string to an Int
    val number = "123".toInt
    println(s"The number is $number")
  } catch {
    // there are so many exeptions, look up the docs if you want to be specific
    // e is a placeholder reffering to the error
    case e: NumberFormatException => println(s"$e is not a valid number")
  }
}
