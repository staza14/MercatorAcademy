package Automation.Week5Day4

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object StaticTableMVP extends App {

  val driver:WebDriver =  new ChromeDriver()
  driver.get("https://cosmocode.io/automation-practice-webtable/")
  driver.manage().window().maximize()

  // instantiate js executor
  val js = driver.asInstanceOf[JavascriptExecutor]

  // Set a global implicit wait of 10 seconds.
  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

  // instantiate explicit wait object
  val waiting = new WebDriverWait(driver, Duration.ofMinutes(1))

  // Locate the table containing country data.
  val tableElement:WebElement = driver.findElement(By.id("countries"))
  println("Great, you've located the table.\n  ")

  // Extract and print all country names from the first column.
  // My method will be to find all the "tr" ( rows) elements and get the second "td" (cell)
  // element from each one

  // .tail to get rid of header row
  val allRows: List[WebElement] = tableElement.findElements(By.tagName("tr")).asScala.toList.tail
  println("-------------- All Countries in Table --------------")
  // loop through each row and get the second element
  allRows.foreach( row => {

    val cells: List[WebElement] = row.findElements(By.tagName("td")).asScala.toList
    val countryNameCell:WebElement = cells(1)
    val countryNameText:String = countryNameCell.getText

    if (countryNameText == "Germany"){
      js.executeScript("arguments[0].scrollIntoView(true);", countryNameCell)
      // Use JavaScript Executor to highlight each row as it’s read.
      js.executeScript("arguments[0].style.border='3px solid green'", countryNameCell)

      val germanyCapital:String = cells(2).getText
      val germanyCurrency:String = cells(3).getText
      println("-------------------------")
      println(s"$countryNameText - $germanyCapital - $germanyCurrency")
      println("-------------------------")

    } else {
      // Use JavaScript Executor to highlight each row as it’s read.
      js.executeScript("arguments[0].style.border='3px solid red'", countryNameCell)
      println(countryNameText)
    }
  })

  driver.quit()
}
