object TueCollectionCodeAlong extends App{

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

  // this is easy for a sequence, we can use the index
  // Head gives us the first value
  val getSeqHead: Int = myFirstSequence.head
  println(s"sequence head: $getSeqHead")

  // Tail gives us everything after the tail
  val getSeqTail: Seq[Int] = myFirstSequence.tail
  println(s"sequence tail: $getSeqTail")

  val seqGetThirdVal: Int = myFirstSequence(2)
  println(s"sequence at index 2: $seqGetThirdVal")
}
