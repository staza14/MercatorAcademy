package ExtraScalaStuff

object LoopPractice extends App {

  /*
  for comprehension
  for (item <- collection){
  >> for every item in the collection given. Item is a placeholder that represents
  >> inside the loop we can do something to every item
  }
   */

  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")

  for (fruit <- fruits){
    println(s"> $fruit")
  }


  /*
  When using selenium we need to turn our java list into a scala list
  > fruits is s list of web elements

  for (fruit <- fruits.asScala){
    println(s"> ${fruit.getText}")
  }
   */
  /*
    val driver = new ChromeDriver()
    driver.get("https://example.com")

    val  items: util.List[WebElement] = driver.findElements(By.class("example"))
    for (item <- items.asScala){
      println(item.getText)
    }

    val buttons =  driver.findElements(By.class("button"))
    for (button <- buttons.asScala){
      button.click()
    }

    //find a specific element
    val links = driver.findElements(By.tagName("a"))

    for (link <- links.asScala){
      val linkText = link.getText
      if (linkText.contains('contact')){
        println("You found the contact link!")
        link.click()
      } else {
        println("That's not a contact link")
      }
    }
   */

  /* Zip with Index Method
 - pairs each row with its index, starting from 0
   */
  /*
  val rows = driver.findElements(By.tagName("tr"))
  for ((row, index) <- rows.asScala.zipWithIndex){
    val cells = row.findElements(By.tagName("td"))
    val formattedString = cells.asScala.map(_.getText).mk.String(" | ")

  }
   */
}
