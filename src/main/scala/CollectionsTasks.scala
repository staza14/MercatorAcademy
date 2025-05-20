object CollectionsTasks  extends App{
  /* MVP
  Scenario: You are working as part of the development team for HMRC that are building a
  service that handle self-assessment tax returns.
 */

  // 1. Create a `Seq` of taxpayer forenames representing multiple submissions, including
  // some duplicates. Store this `Seq` in a val.

  val taxpayerNamesSeq: Seq[String] = Seq("Anastasia", "Athena", "Anastasia", "Aglaia", "Helen", "Aglaia", "Tal")

  // 2. Using string interpolation, print the full list of submissions.

  println(s"Full list of submissions: ${taxpayerNamesSeq.mkString(", ")}")

  // 3. Write a method that uses the built-in method `.count` to identify how many times a
  //specific taxpayer submitted their tax returns in the `Seq` from question 1. This method
  //should work for any inputted taxpayer.

  def countSubmissions(taxpayer: String): Int = {
    taxpayerNamesSeq.count(_ == taxpayer)
  }

  // 4. Print a sentence that states how many times a specific person submitted their tax
  //returns using your method for question 3.

  println(s"Anastasia has submitted: ${countSubmissions("Anastasia")} times.")
  println(s"Tal has submitted: ${countSubmissions("Tal")} times.")

  // 5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to
  //remove duplicates.

  val taxpayerNamesSet = taxpayerNamesSeq.toSet

  // 6. Using string interpolation, print the list of unique taxpayers who submitted.
  println(s"Unique taxpayer names: ${taxpayerNamesSet.mkString(", ")}")

  // 7. Refactor your method from question 3 to work for any inputted collection (HINT: look
  //back at the collection family tree in the PowerPoint).

  // I've said it's an iterable of string but I could change both strings to A to make it even more
  // flexible
  def countNameInCollection(name: String, searchCollection: Iterable[String]): Int = {
    searchCollection.count(_ == name)
  }

  // 8. Using your method from question 7, print the count of the same taxpayer in both the
  //`Seq` from question 1 and the `Set` from question 5.

  println(s"In the seq, Anastasia has submitted: ${countNameInCollection("Anastasia", taxpayerNamesSeq)} times.")
  println(s"In the set, Anastasia has submitted: ${countNameInCollection("Anastasia", taxpayerNamesSet)} times.")

  // 9. Imagine that the user of this service needs to login however there are 6 users that have
  //failed login attempts.

  //a. Write a Map[String, Int] to represent the number of failed attempts for each
  //user.
  val failedAttempts: Map[String, Int] = Map(
    "user1" -> 3,
    "user2" -> 1,
    "user3" -> 9,
    "user4" -> 2,
    "user5" -> 1,
    "user6" -> 5
  )

  //b. Print the number of failed attempts for the user at index position 0.
  //  println(failedAttempts.values)
  //  println(failedAttempts.values.toSeq)
  println(s"User at index 0 has ${failedAttempts.values.toSeq.head} failed attempts.")

  //c. Add a new user to your Map who has 3 failed attempts.
  // Note that map is not ordered!

  // From my research, for Maps, we can simply use - or + to add of remove entries
  // The returns a new map, not change the original
  val updatedFailedAttempts: Map[String, Int] = failedAttempts + ("user7" -> 3)
  println(s"Updates failed attempts log: $updatedFailedAttempts")

  //d. Update the user at index position 1 to have a further failed attempt.
  // Because Maps aren't ordered does this make sense?
  // Because the map is a val, can we update this?
  // .updated builds a new iterable collection by applying a partial function to all elements
  // of this iterable collection on which the function is defined.

  val updatedUserTwo: Map[String, Int] = failedAttempts.updated("user2", failedAttempts("user2") + 1)
  println(s"Updated failed attempts log for User2 change: $updatedUserTwo")

  //e. Remove the user at index position 5.

  val userAtIndex5 = failedAttempts.keys.toSeq(5)
  println(s"User to be deleted: $userAtIndex5")
  println(s"Updated failed login attempts without user at index 5: ${failedAttempts - userAtIndex5}")

  // We should also be able to do this
  val updatedRemoveUser = failedAttempts - "user4"
  println(s"Updated failed login attempts without user4: $updatedRemoveUser")

  // EXTENSION

  // 1. Write two `Sets` that detail submissions on day 1 and day 2. (You can use your `Set` from
  // question 5 if you want!)

  val dayOneSubmissions: Set[String] = Set("Felicity", "Doug", "Bridget", "Jeremy", "Rupert", "Anastasia")
  val dayTwoSubmissions: Set[String] = Set("Anastasia", "Aglaia", "Emmanuel", "Athena", "Tal", "Doug", "Jeremy")

  println(s"Day One Submissions: ${dayOneSubmissions.mkString(", ")}")
  println(s"Day Two Submissions: ${dayTwoSubmissions.mkString(", ")}")

  // a) Who submitted on both days
  // finding intersection using intersect - elements in both sets
  val submissionIntersection = dayOneSubmissions.intersect(dayTwoSubmissions)
  println(s"Submitted on both days: ${submissionIntersection.mkString(", ")}")

  // b) Who submitted only on the first day
  // finding the difference  between the two sets using diff
  val onlySubmittedDayOne = dayOneSubmissions.diff(dayTwoSubmissions)
  println(s"Submitted only on day 1: ${onlySubmittedDayOne.mkString(", ")}")

  // c) A combined list of all unique submitters
  // finding the union of the two sets - combination of all unique submitters
  val uniqueSubmitters = dayOneSubmissions.union(dayTwoSubmissions)
  println(s"Unique submitters: ${uniqueSubmitters.mkString(", ")}")

  /* RESEARCH

  1. Write a short summary explaining how knowing the difference between `Seq` and `Set`
  can help when writing tests.
    Knowing the difference between the two is really important when writing tests because sets and unordered and
    unique whereas sequences are ordered and not necesarily unique.
    For things like queues, the order is important but things like access rights, the order doesn't matter.

    If you're testing that a tax return was submitted once per user, using a Set for expected users helps prevent
    false positives from duplicates in a Seq

    2. A) Research the difference between the build in methods:

    val failedAttempts: Map[String, Int] = Map(
      "user1" -> 2,
      "user2" -> 4
    )

    --> so, we want to know how many times user1 failed log in , we can do that 3 ways...

      i. Map.get - returns a some(value) or None if there is no matching key.

      val result = failedAttempts.get("user1")
      println(result) // Output: Some(2)

      ii. Map(key) - returns value directly or throws an error if not found

      val result = failedAttempts("user1")
      println(result) // Output: 2

      OR

      val result = failedAttempts("user3") // Will crash with NoSuchElementException!

      iii. Map.getOrElse - This checks if the key exists, if it does it returns the value, if not it returns a default
      value that you specified

      val result = failedAttempts.getOrElse("user3", 0)
      println(result) // Output: 0

      B) Using you Map from MVP Q9, write an example using each of the commands above.

      ** see examples above


     C) In testing, when might it be dangerous to use Map(key) directly?

     This can be dangerous when testing because if the key doesn't exist, an exception will be thrown and our tests will crash
     unnecesarily, making it harder to find any real problems.gco main
   */


}

