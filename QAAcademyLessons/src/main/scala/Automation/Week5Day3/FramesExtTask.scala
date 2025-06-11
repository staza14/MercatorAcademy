package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object FramesExtTask extends App {
  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")
  driver.manage().window().maximize()

  // Switch to the frame and interact with the simple content inside it.
  // I will try and print the inner H1 to my terminal
  driver.switchTo().frame("iframeResult")
  // remember with indexes, 0 refers to the first child
  driver.switchTo().frame(0)
  val hOneContent:String = driver.findElement(By.tagName("h1")).getText
  println(s"The text I've found is: ${hOneContent}")

  // navigate to another page
  driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/nestedframes.php")

  // Switch to a frame that is nested and access content inside it.
  // My goal will be to get the value of the href attached to the tutorials
  // point logo

  driver.switchTo().frame("frame1")
  val href: WebElement = driver.findElement(By.tagName("a"))
  println(s"The href you've found is: ${href.getAttribute("href")}")

  driver.quit()
}
