package Automation.Week4Day4

// we  need to call import the web diver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object ChromeBrowserInvoke extends App{


  val driver:WebDriver =  new ChromeDriver()
  println("Invoking Chrome Browser")

  driver.get("https://www.google.com")
  println(s"Title of the page: ${driver.getTitle}")

  // close the browser
  driver.quit()

}
