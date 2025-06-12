# Selenium `Actions` Class – Research & Notes

### 1. What is the Selenium Actions Class and Why Is It Used?

The `Actions` class in Selenium is used to simulate interactions that go beyond 
the capabilities of simple WebElement methods like `.click()` or `.sendKeys()`.

It provides advanced user interactions to mimic scenarios like:
- Mouse movements
- Hovering
- Drag-and-drop
- Context clicking (right click)
- Double clicking

This is useful for automating interactive web apps, dropdowns, sliders, 
or elements that only appear upon hovering.

---

### 2. Commonly Used Methods in the Actions Class

#### 1. `moveToElement(element: WebElement)`
**Purpose:** Moves the mouse to the center of the given element.

**Scenario:** Hovering over a dropdown to reveal hidden sub-menu items.

```scala
actions.moveToElement(menuElement).perform()
```

#### 2. `contextClick(WebElement target)`
**Purpose:** Performs a right-click on the specified element.

**Scenario:** Open a context menu.

```scala
actions.contextClick(driver.findElement(By.id("clickable"))).perform()
```

#### 3. `doubleClick(WebElement target)`
**Purpose:** Double-clicks on a web element.

**Scenario:** Trigger edit mode in a form field.

```scala
actions.doubleClick(driver.findElement(By.id("name"))).perform()
```

#### 4. `dragAndDrop(WebElement source, WebElement target)`
**Purpose:** Drags the source element and drops it on the target.

**Scenario:** Reordering list items.

```scala
actions.dragAndDrop(sourceElement, targetElement).perform()
```

#### 5. `clickAndHold(WebElement element)`
**Purpose:** Clicks without releasing on the specified element.

**Scenario:** Useful when performing a drag operation or simulating press-and-hold behavior, 
such as selecting multiple items or dragging a slider.

```scala
actions.clickAndHold(element).perform()
```
---

### 3. How do you chain multiple actions together?

Chaining is done by calling methods in sequence before finalizing them with .perform(). The actions are queued up 
internally and only executed when .perform() is invoked.

```scala
object ChainedActionsExample extends App {
  val driver: WebDriver = new ChromeDriver()
  driver.get("https://example.com")
  driver.manage().window().maximize()

  val actions = new Actions(driver)

  val menu = driver.findElement(By.id("menu"))
  val submenu = driver.findElement(By.id("submenu"))
  val clickableItem = driver.findElement(By.id("item"))

  // Chain: Hover over menu -> move to submenu -> click item
  actions
    .moveToElement(menu)
    .moveToElement(submenu)
    .click(clickableItem)
    .perform()

  driver.quit()
}
```
---

### 4. What is the difference between `click()` and `moveToElement(element).click()`?

