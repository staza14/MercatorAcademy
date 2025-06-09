package Automation.Week5Day1

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Xpath extends App {
  val driver: WebDriver = new ChromeDriver
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailAddress: WebElement = driver.findElement(By.xpath("//*[@id=\"email\"]"))
  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - passed")

  driver.quit()
}
