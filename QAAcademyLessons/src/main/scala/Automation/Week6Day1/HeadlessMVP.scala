package Automation.Week6Day1

import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriver, WebElement, NoSuchElementException}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.net.UrlChecker.TimeoutException

import java.io.File
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date

object HeadlessMVP extends App{

  // Screenshot method
  def takeScreenshot(driver:WebDriver, status:String): Unit = {

    val timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date())

    val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcFull, new File(s"/Users/anastasia.florentis/Desktop/SeleniumScreenshots/$timestamp-$status.png"))

    println(s"Screenshot saved")
  }

  // Use ChromeDriver with `--headless=new option`
  val options = new ChromeOptions()
  options.addArguments("--headless=new")

  // instantiate chrome driver w options
  val driver: WebDriver = new ChromeDriver(options)
  driver.get("https://the-internet.herokuapp.com/login")
  driver.manage().window().maximize()

  try {
    // fill in username and password
    val usernameInput: WebElement = driver.findElement(By.id("username"))
    usernameInput.sendKeys("tomsmith")
    println("Username entered")

    val passwordInput: WebElement = driver.findElement(By.id("password"))
    passwordInput.sendKeys("SuperSecretPassword!")
    println("Password entered")


    // submit the login form
    val submitButton: WebElement = driver.findElement(By.id("cat"))
    submitButton.click()
    println("Submit Button Clicked")

    // create a wait object
    // and wait for the result message
    val waiting = new WebDriverWait(driver, Duration.ofMinutes(1))
    val flashElement = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))

    // get the class of the flash element to check if it is success or error
    val classAttr = flashElement.getAttribute("class")

    if (classAttr.contains("success")) {
      println("Login was successful.")
      takeScreenshot(driver, "success")
    } else if (classAttr.contains("error")) {
      println("Login failed.")
      takeScreenshot(driver, "failure")
    } else {
      println(s"Unexpected flash alert: $classAttr")
    }
  } catch {
    case e: NoSuchElementException =>
      println("Sorry, element not found: " + e.getMessage)
    case e: TimeoutException =>
      println("Timeout waiting for element: " + e.getMessage)
    case e: Exception =>
      println("Unexpected exception: " + e.getMessage)
  } finally {
    if (driver != null){
      driver.quit()
    }
  }

}
