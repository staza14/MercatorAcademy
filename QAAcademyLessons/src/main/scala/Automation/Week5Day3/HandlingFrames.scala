package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrames extends App{

  // instantiating the chrome driver
  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/nested_frames")
  driver.manage().window().maximize()

  // we want to move to the middle frame so we switch to top frame because it is nested within there
  driver.switchTo().frame("frame-top")
  println("> Moved into a new frame")
  // and now to the next one
  driver.switchTo().frame("frame-middle")
  println("> Moved into another new frame")

  // We can get the text from the frame we are in:
  // We wouldn't be able to access this without going into the correct frame
  val middleText:String = driver.findElement(By.id("content")).getText
  println(s"The text in your current frame is: ${middleText} ")

  // to move back
  driver.switchTo().defaultContent()
  println("> Moved back to default frame")

  // we can now move into another frame, by index this time
  // remember, first frame 0, next frame 1 and so on ...
  driver.switchTo().frame(1)
  println("> Moved again this time using index")
  val pageSource:String = driver.getPageSource
  println(s"Page Source of Current Frame: $pageSource")

  driver.switchTo().defaultContent()
  println("> Moved back to default frame")

  // let's move to another frame using the web element
  val frameTop:WebElement = driver.findElement(By.name("frame-top"))
  driver.switchTo().frame(frameTop)
  driver.switchTo().frame("frame-left")
  val leftText:String = driver.findElement(By.tagName("body")).getText
  println(s"The text in your current frame is: ${leftText} ")

  // close the session
  driver.quit()
}
