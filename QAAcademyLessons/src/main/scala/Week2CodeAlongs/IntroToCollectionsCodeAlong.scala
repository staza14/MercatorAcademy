package Week2CodeAlongs

object IntroToCollectionsCodeAlong extends App{

/* Types of collections
--> More than one item of data can be stored in one of a number of different location. Sequences, Sets and Maps
    are amoungst the most common. They are immutable by default. They are transversible and Iterable. see the tree
    of types of collections in the scala docs.
 */

  /* Set
  - Not ordered!
  - unique values
  */
  val myFirstSet: Set[Int] = Set(1,2,3,4,5,5)
  println(s"set: $myFirstSet")

  /* Sequence
  - think sequential
  - Ordered/ Indexed!
  - can have repeated values
   */
  val myFirstSequence: Seq[Int] = Seq(1,2,3,4,5,5)
  println(s"sequence: $myFirstSequence")

  /* Map
  - key value pairs
  - map will take in 2 parameters, we state the type of the key first and then the value
  - the key must be unique
   */
  val myFirstMap: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "three" -> 3, // will remove when complied
    "four" -> 3
  )
  println(s"map: $myFirstMap")

  // ACCESSING DATA

  /* Sequences
   this is easy for a sequence, we can use the index
   */

  // Head gives us the first value
  val getSeqHead: Int = myFirstSequence.head
  println(s"sequence head: $getSeqHead")

  // Tail gives us everything after the tail
  val getSeqTail: Seq[Int] = myFirstSequence.tail
  println(s"sequence tail: $getSeqTail")

  val seqGetThirdVal: Int = myFirstSequence(2)
  println(s"sequence at index 2: $seqGetThirdVal")


  /* Set
   We cannot use index to find values
   */

  //  We can check if a values is in a set we can do it like this
  //  can also look like : MyFirstSet.contains(30)
  val checkSetContains: Boolean = myFirstSet(30)
  println(s"Is 30 in my set: $checkSetContains")

  //  Generally for sets, we want to filter
  val filterSet: Set[Int] = myFirstSet.filter(_ <3)
  println(s"Filtered set: $filterSet")

  val filterNotSet: Set[Int] = myFirstSet.filterNot(_ <3)
  println(s"FilterNot set: $filterNotSet")

  val evenSet: Set[Int] = myFirstSet.filterNot(_ % 2 != 0)
  println(s"Even set: $evenSet")


  /* Map
    We can use the keys to get the values. This is great if we know the keys!
   */

  val getMapValue: Int = myFirstMap("one")
  println(s"Get Map Value of key 'one': $getMapValue")

  // This finds the value that is equal to 1 and gets the key that matches it
  // If there are multiple of the value, it will return the first one it finds
  val getMapKey: String = myFirstMap.find(_._2 == 2).get._1
  println(s"Get Map Key of value 2: $getMapKey")

  /* Task 1
  - create a Seq of names
  - create a Map of colours and filter this map for the colour blue
  - filter a Set og Ints to only contain Ints higher then 2
   */

  val nameSequence: Seq[String] = Seq("Anastasia", "Aglaia", "Athena", "Thalea", "Emmanuel")
  println(s"Name Sequence: $nameSequence")

  val colourMap: Map[Int, String] = Map(
    1 -> "red",
    2 -> "yellow",
    3 -> "blue",
    4 -> "green"
  )
  println(s"Colour map: $colourMap")
  val blueSet: Map[Int, String] = colourMap.filter(_._1 == 3 )
  println(s"Filtered set: $blueSet")

  val intSet: Set[Int] = Set(1,2,3,4,5,6,7,8,9,10)
  println(s"Int set: $intSet")
  val aboveTwoSet: Set[Int] = intSet.filter(_ > 2)
  println(s"Above 2 set: $aboveTwoSet")

  /* map ( method -> lowercase 'm')
  We use this to iterate over a collection and do something to each thing
   */

  def tripledSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
    // _ * 3
    // this is the same as
    // num is a placeholder --> you can name it anything but this should be meaningful
    num => num * 3
  }
  println("Tripled Set: " + tripledSet(myFirstSet))

  def tripledSeq(inputSeq: Seq[Int]): Seq[Int] = inputSeq.map {
    num => num * 3
  }
  println("Tripled Seq: " + tripledSeq(myFirstSequence))

  def tripledMap(inputMap: Map[String, Int]): Map[String, Int] = inputMap.map {
    case (key,value) => (key + "s", value * 3)
  }
 println("Tripled Map:" + tripledMap(myFirstMap))

  /*
  More iterable methods:
  .exists --> all that could be ( gets collection back)
  .contains --> returns a boolean
  and many more!
   */

  /* Task 2
  - Add 1 to all numbers in a collection of ints
  - return true if a seq has a string that contains the letter 'r'
  - remove all the even numbers from a Set of Ints

  - What is flat map? When would you use it?
   */

  def addOne(inputSet: Set[Int]): Set[Int] = inputSet.map {
    _ + 1
  }
  println("Add One: " + addOne(myFirstSet))

  def containsR(inputSeq: Seq[String]): Boolean = inputSeq.exists(word => word.contains("r"))
  println("Contains r: " + containsR(nameSequence))

  def removeEvenNumbers(inputSet: Set[Int]): Set[Int] = inputSet.filter {
      _ % 2 != 0
    }
  println("All odds: " + removeEvenNumbers(myFirstSet))

  // Flat map flattens things - good for nested data types

  // APPENDING AND PREPENDING

  val newSeq: Seq[Int] = Seq(6,7,8,9)

  // I want to append new Sequence to the end of my first sequence
  val appendedListOne = myFirstSequence +: newSeq
  println(s"Appended with +: --> $appendedListOne")
  // OR
  val appendedListTwo = myFirstSequence ++ newSeq
  println(s"Appended with ++ --> $appendedListTwo")

  // Now I want to prepend new Sequence to the beginning of my first sequence
  // all that we need to do is change the order
  val prependedListOne = newSeq +:  myFirstSequence
  println(s"****Prepended with +: --> $prependedListOne")
  // OR
  val prependedListTwo = newSeq ++ myFirstSequence
  println(s"Prepended with ++ --> $prependedListTwo")

  val appendedWithInt = 1 +: newSeq
  println(s"Append an Int +: --> $appendedWithInt")
}
