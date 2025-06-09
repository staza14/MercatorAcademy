package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object ByID extends App {

  // instantiating the ChromeDriver for interacting with the Chrome browser
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")
  val emailInput:WebElement = driver.findElement(By.id("email"))
  // to send info to an input field use sendKeys
  emailInput.sendKeys("test@gmail.com")

  val passwordInput:WebElement = driver.findElement(By.id("password"))
  passwordInput.sendKeys("123456")

  val submitButton:WebElement = driver.findElement(By.id("login"))
  // to click a button use click
//  submitButton.click()
//  println("Clicked logIn button")
  // close the browser
  driver.quit()
}
