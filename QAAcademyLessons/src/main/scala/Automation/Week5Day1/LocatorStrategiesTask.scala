package Automation.Week5Day1

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object LocatorStrategiesTask extends App {

  val driver: WebDriver = new ChromeDriver
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")

  // USERNAME

  val usernameInput:WebElement = driver.findElement(By.name("username"))
  usernameInput.sendKeys("Anastasia")
  println("Username entered - field found using name")

  // PASSWORD

  val passwordInput:WebElement = driver.findElement(By.xpath("//input[@type='password']"))
  passwordInput.sendKeys("123456")
  println("Password entered - field found using xpath")

  //COMMENT

  val commentInput:WebElement = driver.findElement(By.tagName("textarea"))
  commentInput.sendKeys("Here is a comment")
  commentInput.clear()
  println("Comment entered - field found using tag")

  // CHECKBOX

  val checkbox:WebElement = driver.findElement(By.cssSelector("table>tbody>tr:nth-child(5)>td>input[type=checkbox]:nth-child(2)"))
  checkbox.click()
  println("Checkbox checked - found using cssSelector")

  // SUBMIT

  val submitButton:WebElement = driver.findElements(By.className("styled-click-button")).get(1)
  submitButton.click()
  println("Submitted - button found using link text")


  // LINK
  val backButton:WebElement = driver.findElement(By.partialLinkText("Go back"))
  backButton.click()
  println("Gone back- link found using partial link text")

  driver.quit()
}
