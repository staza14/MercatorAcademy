package Automation.Week5Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object ExplicitWait extends App {

  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.w3schools.com/howto/howto_css_custom_checkbox.asp")
  driver.manage().window().maximize()

  val acceptAllButton: WebElement = driver.findElement(By.id("accept-choices"))
  acceptAllButton.click()

  // We need to create a wait object

  val waiting = new WebDriverWait(driver, Duration.ofMinutes(1))

  // find what you want to do but put a wait on it
  val checkBox:WebElement = waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/label[1]")))
  checkBox.click()
  driver.quit()
}
