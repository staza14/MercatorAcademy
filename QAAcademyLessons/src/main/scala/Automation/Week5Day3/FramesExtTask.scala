package Automation.Week5Day3

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object FramesExtTask extends App {
  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")
  driver.manage().window().maximize()
}
