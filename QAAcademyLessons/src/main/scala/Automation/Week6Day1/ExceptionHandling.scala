package Automation.Week6Day1

import org.openqa.selenium.{By, NoSuchElementException}

import org.openqa.selenium.chrome.ChromeDriver

object ExceptionHandling extends App{
  val driver = new ChromeDriver()

  // NoSuchElementException
  // This stops our file from running so we need to handle it properly

  /* Try-catch- finally
  in the try block - this is what we want to happen
  in the catch block - what exception we are expecting and what we want to do if we get that
  in the finally block - these statements execute regardless of whether an exception was thrown or caught
   */

  try{
    driver.get("https://www.selenium.dev/selenium/web/web-form.html")
    val element = driver.findElement(By.id("my"))
  } catch {
    case e : NoSuchElementException => println(s"Sorry, that element doesn't exist! ${e.getMessage}")
    case a : Exception => println(s"Sorry, something went wrong! $a.getMessage}")

  } finally {
    if (driver != null){
      driver.quit()
    }
  }
}
