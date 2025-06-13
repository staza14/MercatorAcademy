package Automation.Week5Day4

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object JSExecutor extends App{

  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailInput:WebElement = driver.findElement(By.id("email"))
  // to send info to an input field use sendKeys
  emailInput.sendKeys("test@gmail.com")

  val passwordInput:WebElement = driver.findElement(By.id("password"))
  passwordInput.sendKeys("123456")

  val submitButton:WebElement = driver.findElement(By.id("login"))

  // instantiating executor and scrolling down to the specified element
  val js = driver.asInstanceOf[JavascriptExecutor]

  js.executeScript("arguments[0].scrollIntoView(true);", submitButton)
  js.executeScript("arguments[0].click();", submitButton)
  println("Clicked logIn button")

  driver.quit()
}
