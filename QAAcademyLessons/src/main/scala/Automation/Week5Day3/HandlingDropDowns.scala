package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingDropDowns extends App{
  // instantiating the chrome driver
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")
  driver.manage().window().maximize()

  // switching to the correct frame, to avoid the popup
  // You can pass the id, name index or web element
  driver.switchTo().frame("iframeResult")

  // finding drop down
  val dropdownElement:WebElement = driver.findElement(By.id("cars"))

  // creating a selenium dropdown element
  val select = new Select(dropdownElement)

  /* now we can select different elements inside using:
  - selectByVisibleText
  - selectByValue
  - selectByIndex
   */

  select.selectByVisibleText("Opel")
  println(s"Selected by visible text: ${select.getFirstSelectedOption.getText}")

  select.selectByValue("volvo")
  println(s"Selected by visible text: ${select.getFirstSelectedOption.getText}")

  select.selectByIndex(3)
  println(s"Selected by visible text: ${select.getFirstSelectedOption.getText}")

  // closing the session
  driver.quit()
}

