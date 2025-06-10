package Automation.Week5Day2

import org.openqa.selenium.{WebDriver, WindowType}
import org.openqa.selenium.chrome.ChromeDriver

object ExtResearch extends App{

  /* explore quit() vs close()

    close() closes only the current window on which Selenium is
    running but the WebDriver session remains
    active. quit() closes all browser windows and ends the
    WebDriver session

   */

  val driver:WebDriver = new ChromeDriver()

  // open one
  driver.get("https://demoqa.com/automation-practice-form")
  driver.manage().window().maximize()

  // open another
  driver.switchTo().newWindow(WindowType.TAB)
  driver.get("https://demoqa.com/browser-windows")
 // open a new window
  driver.switchTo().newWindow(WindowType.WINDOW)
  driver.get("https://demoqa.com/browser-windows")
  // close current tab
  driver.close()
  // at this point this closes the last window
  // it doesn't seem to work to run it again
  //  driver.close()

  // open another window
  // It doesn't seem like we can open another
  driver.quit()
}
