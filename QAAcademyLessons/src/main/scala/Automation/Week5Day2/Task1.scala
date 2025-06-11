package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Task1 extends App{
  // instantiate the chrome driver
  val driver:WebDriver = new ChromeDriver()

  // accessing the url for testing
  driver.get("https://demoqa.com/browser-windows")

  // page title
  val pageTitle:String = driver.getTitle
  println(s"The title of the page is: $pageTitle")

  // page url
  val pageUrl:String = driver.getCurrentUrl
  println(s"The title of the page is: $pageUrl")

  // close the current window, in this case this also ends the session because we have no other windows open
  driver.close()
}
