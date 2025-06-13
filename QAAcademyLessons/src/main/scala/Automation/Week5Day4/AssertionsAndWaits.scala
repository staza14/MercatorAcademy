package Automation.Week5Day4

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration

object AssertionsAndWaits extends App {
  val driver:WebDriver =  new ChromeDriver()

  // Implicit wait of 10 seconds
  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailInput:WebElement = driver.findElement(By.id("email"))
  emailInput.sendKeys("test@gmail.com")

  val passwordInput:WebElement = driver.findElement(By.id("password"))
  passwordInput.sendKeys("123456")

  val submitButton:WebElement = driver.findElement(By.id("login"))

  // instantiating executor and scrolling down to the specified element
  val js = driver.asInstanceOf[JavascriptExecutor]

  js.executeScript("arguments[0].scrollIntoView(true);", submitButton)
  js.executeScript("arguments[0].click();", submitButton)
  println("Clicked logIn button")

  // ASSERTION BIT
  val header = driver.findElement(By.tagName("h2")).getText
  // check that this equals "Thank You!" as we expect it to
  assert(header == "Thank you!")

  driver.quit()
}
