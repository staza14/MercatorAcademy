package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object ByTask extends App {
  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  driver.manage().window().maximize()

  // by ID - locate the text input and enter any name
  val textInput:WebElement = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Anastasia")

  // by Name - locate password field and enter a password
  val passwordInput:WebElement = driver.findElement(By.name("my-password"))
  passwordInput.sendKeys("12345678")

  // by Class Name  - find textarea and enter some text
  val textArea:WebElement = driver.findElements(By.className("form-control")).get(2)
  textArea.sendKeys("Sample text...")

  // by Tag Name - locate all input elements and count how many there are
  val allInputs: java.util.List[WebElement]  = driver.findElements(By.tagName("input"))
  println(s"there are ${allInputs.size()} inputs on this webpage")

  // by linkText - click on the return to index link
  val returnLink: WebElement = driver.findElement(By.linkText("Return to index"))
  returnLink.click()

  driver.navigate().back()
  // by partial link text - navigate back to the form using return partial
  val returnPartial: WebElement = driver.findElement(By.partialLinkText("Return"))
  returnPartial.click()

  driver.quit()
}
