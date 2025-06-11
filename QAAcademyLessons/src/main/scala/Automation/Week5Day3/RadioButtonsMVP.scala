package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}

import java.time.Duration

object RadioButtonsMVP extends App{

  // instantiating the chrome driver
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://testpages.herokuapp.com/styled/index.html")

  // maximize page
  driver.manage().window().maximize()

  // Go to the "HTML Form Example" page
  val formExampleLink:WebElement = driver.findElement(By.linkText("HTML Form Example"))
  formExampleLink.click()

  // Fill in the username and password fields.
  val usernameField:WebElement = driver.findElement(By.cssSelector("input[name='username']"))
  val passwordField:WebElement = driver.findElement(By.cssSelector("input[name='password']"))

  usernameField.sendKeys("TestUser")
  passwordField.sendKeys("123456")

  // Locate a checkbox - I'm going to locate all
  val listOfCheckboxes: java.util.List[WebElement] = driver.findElements(By.name("checkboxes[]"))

  // Select the checkbox located if not already selected
  // I'm going to check both to make sure my if logic works

  println("---------checking checkboxes---------")
  listOfCheckboxes.forEach(element => {
    if (element.isSelected){
      println(s"${element.getAttribute("value")} is already selected!")
    } else {
      element.click()
      println(s"Nice, you just selected ${element.getAttribute("value")}!")
    }
  })
  println("-------------------------------------\n")

  //  Select a radio option.
  val radioOne:WebElement = driver.findElement(By.cssSelector("input[value='rd1']"))
  radioOne.click()

  // Choose an option from the dropdown.
  val dropdownElement:WebElement = driver.findElement(By.name("dropdown"))
  val select = new Select(dropdownElement)

  select.selectByValue("dd3")
  println(s"Nice, you selected an option using the value. You selected: ${select.getFirstSelectedOption.getText}")

  // Click the "Submit" button.
  driver.findElement(By.cssSelector("input[value='submit']")).click()

  // Click a link to return to the homepage.

  //driver.findElement(By.linkText("Index")).click()

  // we're having an issue of timing here so we will add a web driver wait
  val waiting = new WebDriverWait(driver, Duration.ofSeconds(10))
  val indexLink:WebElement = waiting.until(ExpectedConditions.elementToBeClickable(By.linkText("Index")))
  indexLink.click()
  println("\n ** Back at the homepage **")

  // ending the session
  driver.quit()
}
