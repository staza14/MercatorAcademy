package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object DemoQATask extends App{
  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://demoqa.com/")

  // Navigate to correct page

  val elementsButton:WebElement = driver.findElement(By.className("top-card"))
  elementsButton.click()
}
