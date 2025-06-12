package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingButtonsAndLinks extends App{

  val driver:WebDriver =  new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")
  driver.manage().window().maximize()

  val submitButton:WebElement = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"))

  if (submitButton.isEnabled){
    val buttonText:String = submitButton.getText
    submitButton.click()
    println(s"The button that says [${buttonText}] has been clicked!")
  } else {
    println("Sorry, the button is not enabled so you cannot click it.")
  }
  driver.navigate().back()
  // Hyperlinks
  val hyperlink:WebElement = driver.findElement(By.partialLinkText("Return to index"))
  val href:String = hyperlink.getAttribute("href")
  hyperlink.click()
  println(s"Clicked the link and navigated to: ${href} ")
  // closing session
  driver.quit()
}
