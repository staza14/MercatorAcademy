package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object WThreeTask extends App{
  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.w3schools.com/html/html_examples.asp")

  //a
  val buttons: java.util.List[WebElement]  = driver.findElements(By.tagName("a"))
  println(s"there are ${buttons.size()} buttons on this webpage")

  //b
  val images: java.util.List[WebElement]  = driver.findElements(By.tagName("img"))
  println(s"there are ${images.size()} images on this webpage")

  //c
  val headers: java.util.List[WebElement]  = driver.findElements(By.tagName("h1"))
  println(s"there are ${headers.size()} h1s on this webpage")

  // d

  val tags: List[String] = List("a", "img", "h1")

  tags.foreach(tag => {
    val elements: java.util.List[WebElement] = driver.findElements(By.tagName(tag))
    println(s"there are ${elements.size()} h1s on this webpage")
  }
  )

  driver.quit()
}
