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
}
