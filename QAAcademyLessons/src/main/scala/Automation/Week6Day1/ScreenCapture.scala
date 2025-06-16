package Automation.Week6Day1

import org.openqa.selenium.{By, OutputType, TakesScreenshot}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date


object ScreenCapture extends App{

  val driver = new ChromeDriver()
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // get timestamp
  val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())

  val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcFull, new File(s"/Users/anastasia.florentis/Desktop/SeleniumScreenshots/TestResult-$timeStamp.png"))

  val element = driver.findElement(By.name("my-disabled")) // Locate the element by its name (update if needed)
  val srcElement: File = element.getScreenshotAs(OutputType.FILE) // Capture only that element
  // Save the screenshot of the element
  FileHandler.copy(srcElement, new File(s"/Users/anastasia.florentis/Desktop/SeleniumScreenshots/SpecificElementTestResult-$timeStamp.png"))

  driver.quit()
}
