# Selenium Techniques

>
> ### File Upload and Download
> 
>  You can upload a file with selenium by interacting with 
> the input element and using the .sendKeys() method.
> 
> Some things to note: 
> 
> - The file path you are sending to sendKeys() must be absolute.
> 
> - The file input field must be visible, you might need to make this visible if its hidden. 
>
> - You don't need to .click(), .sendKeys() is enough.
> 
> WebDriver can’t handle download prompt, this is OS level so selenium can't interact with it.
> We need to set our borwser preferences to download and save files automatically.


>
> ### Scrolling
> To scroll, we need to use the JavaScriptExecutor. It provides an interface that 
> enables us to run JavaScript methods in our Selenium scripts.
> 
> ```scala 
> import org.openqa.selenium.JavascriptExecutor
> import org.openqa.selenium.WebDriver
> val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
> jsExecutor.executeScript("window.scrollBy(0,250)")
> ```
>  Here we've instantiated the jsExecutor and then used .executeScript() to run the
> .scrollBy() method which takes two arguments, x and y, that represent the horizontal and vertical pixel values, respectively.
> 
> If you want to scroll until an element is in view:
> ```scala 
> //Locating element by link text and store in variable "Element"
> WebElement Element = driver.findElement(By.linkText("Click Me"));
> // Scrolling down the page till the element is found		
> js.executeScript("arguments[0].scrollIntoView();", Element);
> ```
> 
> And to scroll to the bottom of the page: 
> ```scala
> js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
> ```

>
> ### Dynamic Dropdown
> This is different because elements are loaded at runtime, meaning they aren't present 
> in the DOM initially. We need to ensure the dropdown is visible and the values are available 
> before interacting with it. An option for handling this could be to use WebDriverWait, which
> allows us to wait for a specific condition to be met before interacting. 
> 
> 
>

>
> ### Shadow DOM
> Shadow DOM is a web standard that encapsulates parts of the DOM within a host element.
> Selenium can’t directly access its elements using .findElement(), we'll need to use javascript.
>
> 