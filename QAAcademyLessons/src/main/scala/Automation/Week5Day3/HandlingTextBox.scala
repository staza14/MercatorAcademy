package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTextBox extends App{

  // instantiating the ChromeDriver for interacting with the Chrome browser
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // finding text input box
  val textInput:WebElement = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Welcome to Mercator")
  println("The value has been entered.")
  val textValue:String = textInput.getAttribute("value")
  println(s"The value entered was: $textValue")
  textInput.clear()
  println("The textbox has been cleared.")

  // closing session
  driver.quit()
}
