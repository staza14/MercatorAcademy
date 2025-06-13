package Automation.Week5Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingMultipleWindows extends App{

  // instantiating chrome driver
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/windows")
  driver.manage().window().maximize()

  // find the handle for the parent window
  val parentWindow:String = driver.getWindowHandle
  println(s"The handle of the Parent Window is: $parentWindow")

  // open a new window
  driver.findElement(By.linkText("Click Here")).click()

  // get all the handles now
  val allWindowHandles:List[String] = driver.getWindowHandles.asScala.toList
  val iterator = allWindowHandles.iterator

  while (iterator.hasNext){
  //    println(iterator.hasNext)
    val handle = iterator.next()

    if (handle != parentWindow){
      // switching windows
      driver.switchTo().window(handle)
      println(s"The handle of the current window is: $handle")
      println(s"The title of this page is: ${driver.getTitle}")
    }
  }

  driver.quit()
}
