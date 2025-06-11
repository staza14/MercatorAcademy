package Automation.Week5Day2

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Task3 extends App{
  // instantiate the chrome driver
  val driver:WebDriver = new ChromeDriver()

  // accessing the url for testing
  driver.get("https://demoqa.com/automation-practice-form")

  driver.manage().window().maximize()
  // find the elements

  val firstNameInput:WebElement = driver.findElement(By.id("firstName"))
  val submitButton:WebElement = driver.findElement(By.id("submit"))
  val hobbiesCheckBoxes: java.util.List[WebElement] = driver.findElements(By.className("custom-checkbox"))

  if (firstNameInput.isDisplayed() && firstNameInput.isEnabled()) {
    firstNameInput.sendKeys("Anastasia")
    println("Sucessfully added a first name")
  } else {
    println("Sorry, something is wrong.\n Make sure the input is visible and enabled.")
  }

  hobbiesCheckBoxes.forEach(checkbox =>{
    if (checkbox.isSelected()){
      println("This checkbox has already been selected")
    } else {
      println("\nThis checkbox has not been selected yet.")
      println("Selecting this check box...")
      checkbox.click()
      println("Checkbox selected.")

    }
  })

  if (submitButton.isDisplayed() && submitButton.isEnabled()) {
    submitButton.click()
    println("Submitted!")
  } else {
    println("Sorry, something is wrong.\n Make sure the button is visible and enabled.")
  }

  driver.quit()
}
