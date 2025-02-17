package HandleMultiTabWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboardAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        
        Actions actions = new Actions(driver);

        //Typetext
        WebElement inputField = driver.findElement(By.id("clickable"));
        inputField.sendKeys("Hey its Taffazul");
        Thread.sleep(2000);

        //HoverOver
        WebElement hoverElement = driver.findElement(By.id("hover"));
        actions.moveToElement(hoverElement).perform();
        Thread.sleep(2000);

        //DragandDrop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(2000);
        
        //hover
        WebElement hover = driver.findElement(By.id("hover"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(hover).perform();

        //RightClick
        WebElement rightClickElement = driver.findElement(By.id("clickable"));
        actions1.contextClick(rightClickElement).perform();
        Thread.sleep(2000);

        //Double Click
        WebElement doubleClick = driver.findElement(By.id("clickable"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(1000);

        inputField.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        inputField.sendKeys(Keys.CONTROL + "Taffa");
        Thread.sleep(1000);
        
        //KeyboardHanlde
        WebElement inputField2 = driver.findElement(By.id("clickable"));

        Actions actions2 = new Actions(driver);
        actions2.sendKeys(inputField2, "Hey Taffazul ").perform();
        actions2.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions2.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        
//        driver.quit();
    }
}

