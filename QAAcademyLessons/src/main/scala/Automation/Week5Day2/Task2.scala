package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Task2 extends App{
  // instantiate the chrome driver
  val driver:WebDriver = new ChromeDriver()

  // accessing the url for testing
  driver.get("https://demoqa.com/automation-practice-form")

  // naviagte to another url

  driver.navigate().to("https://example.com")
  println("> navigated to new url")

  // back
  driver.navigate().back()
  println("> moved back")

  // forward
  driver.navigate().forward()
  println("> moved forward")

  // refresh
  driver.navigate().refresh()
  println("> refreshed")

  // maximise
  driver.manage().window().maximize()
  println("> maximised")

  // minimise
  driver.manage().window().minimize()
  println("> minimised")

  // print the page source

  val pageSource:String = driver.getPageSource
  println(s"Page Source: $pageSource")

  // close current window and end session
  driver.quit()
}
