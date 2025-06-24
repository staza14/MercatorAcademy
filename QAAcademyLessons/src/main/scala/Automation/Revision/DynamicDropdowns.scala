package Automation.Revision

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object DynamicDropdowns extends App {
  // instantiate web driver
  val driver: WebDriver = new ChromeDriver()
  // wait object
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  driver.manage().window().maximize()
  driver.get("https://demoqa.com/automation-practice-form")

  // scroll down to the drop downs
  val stateField:WebElement = driver.findElement(By.id("state"))
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true)", stateField)

  // click it
  // this gives us the drop down
  stateField.click()

  // now we need to select a state from the drop down
  // we need to wait until it is clickable
  // we'll select NCR by its xpath

  val stateOption = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NCR')]"))
  )
  // click
  stateOption.click()
  // now our city drop down will be dynamically filled
  // same steps, lets find the second drop down, click it to get the dynamically generated list

  val cityField:WebElement = driver.findElement(By.id("city"))
  cityField.click()

  // now we have a list
  val cityOption = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Delhi')]"))
  )
  // click
  cityOption.click()

  // let's use an assertion to check we've selected the correct values

  // we'll use xpath to get the text value from the selected elements
  val chosenState = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'-singleValue')]")).getText
  val chosenCity  = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'-singleValue')]")).getText
  // and then assert that they are correct
  // an exception will be thrown if the assertion fails

  assert(chosenState == "NCR",  s"State was <$chosenState>")
  assert(chosenCity  == "Delhi", s"City  was <$chosenCity>")

  println("The desired state and city were selected from the dynamic dropdowns. ")

  driver.quit()
}
