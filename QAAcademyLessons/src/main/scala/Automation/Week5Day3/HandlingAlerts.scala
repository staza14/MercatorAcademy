package Automation.Week5Day3

import org.openqa.selenium.{Alert, By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingAlerts extends App{
  /* Alerts are browser generated pop-up messages that appear. they are created using javascript
   and are not part of the HTML DOM so they must be handled differently from regular elements.
  Three types of alerts :
  1. simple alert - message with only OK button
  2. confirmation alert - message with OK and Cancel buttons
  3. prompt alert - Message with input box, OK and Cancel buttons
   */

  val driver:WebDriver =  new ChromeDriver()

  // Note: This url is for testing, we need to click on the buttons to get the alerts..
  // this is not the norm
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  // simple alert
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()
  // move to the alert "frame" and select the OK button
  val simpleAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Simple Alert is : ${simpleAlert.getText}")
  simpleAlert.accept()
  println("Test passed for Simple Alert\n")

  // Confirmation Alert
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click()
  val confirmationAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Confirmation Alert is : ${confirmationAlert.getText}")
  // we can accept of dismiss these alerts
  confirmationAlert.dismiss()
  println("Test passed for Confirmation Alert\n")

  // Prompt Alert
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val promptAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Prompt Alert is : ${promptAlert.getText}")
  promptAlert.sendKeys("This is a test")
  promptAlert.accept()

  // find the result box to see if our text came through
  val result:WebElement = driver.findElement(By.id("result"))
  println(s"The result of this prompt was: ${result.getText}")
  println("Test passed for Prompt Alert\n")
  // Ending the session
  driver.quit()
}
