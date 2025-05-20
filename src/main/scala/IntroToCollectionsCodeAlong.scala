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
}
