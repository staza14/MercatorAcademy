package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object BrowserMethods extends App{

  // instantiate the chrome driver
  val driver:WebDriver = new ChromeDriver()

  // accessing the url for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // maximize screen
  driver.manage().window().maximize()

  // navigate somewhere else
  driver.navigate().to("https://the-internet.herokuapp.com")

  // go back
  driver.navigate().back()

  // go forward
  driver.navigate().forward()

  // refresh
  driver.navigate().refresh()

  // close current tab
  driver.close()
  // driver.quit() > this won't work right now because nothing is left open
}
