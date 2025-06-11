package Automation.Week5Day3

import org.openqa.selenium.{Alert, By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object AlertsExtTask extends App {

  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php")
  driver.manage().window().maximize()

  //Trigger and accept a simple alert.
  driver.findElement(By.cssSelector("body > main > div > div > div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(2) > button")).click()
  val simpleAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Simple Alert is : ${simpleAlert.getText}")
  simpleAlert.accept()
  println("You did it! Simple Alert ✅ \n")

  //Trigger and dismiss a confirmation alert.
  driver.findElement(By.cssSelector("body > main > div > div > div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(4) > button")).click()
  val confirmationAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Confirmation Alert is : ${confirmationAlert.getText}")
  confirmationAlert.dismiss()
  println("Dismissed! Confirmation Alert ✅ \n")

  //Trigger a prompt alert, enter text, and accept.
  driver.findElement(By.cssSelector("body > main > div > div > div.col-md-8.col-lg-8.col-xl-8 > div:nth-child(5) > button")).click()
  val promptAlert:Alert = driver.switchTo().alert()
  println(s"The text for the Prompt Alert is : ${promptAlert.getText}")
  promptAlert.sendKeys("Anastasia")
  promptAlert.accept()
  println("Nice! Prompt Alert ✅ \n")
}
