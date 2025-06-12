package Automation.Week5Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTables extends App {
  // instantiating chrome driver
  val driver:WebDriver =  new ChromeDriver()

  // static table
  driver.get("https://www.w3schools.com/html/html_tables.asp")
  driver.manage().window().maximize()

  // get all rows
  val rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[position() > 1]"))
  // get the associated columns

  for (i <- 0 until  rows.size()){
    val cols = rows.get(i).findElements(By.tagName("td"))
    val rowText = cols.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString("|")
    println(s"Row ${i + 1}: $rowText")
  }

  driver.quit()
}
