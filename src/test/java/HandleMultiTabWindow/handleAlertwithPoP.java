package HandleMultiTabWindow;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAlertwithPoP {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        //Handling Simple Alert
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        //Handling Confirm Alert
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.accept();

        //Handling Alert with Textbox
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hey, it's Taffazul");
        promptAlert.accept();

        driver.quit();
    }
}
