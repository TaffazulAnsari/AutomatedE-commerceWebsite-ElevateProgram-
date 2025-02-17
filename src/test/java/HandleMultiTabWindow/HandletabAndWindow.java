package HandleMultiTabWindow;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Set;

public class HandletabAndWindow {
    static WebDriver driver;
    public static void main(String[] args) {
        runTest("chrome");
        runTest("firefox");
        runTest("edge");
    }

    public static void runTest(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser: " + browserName);
                return;
        }
        try {
            driver.manage().window().maximize();
            handleMultipleWindows();
            
            //Handle iFrames
            handleFrames();

        } finally {
            driver.quit();
        }
    }

    //Handle multiple windowsAndtab
    public static void handleMultipleWindows() {
        driver.get("https://demo.automationtesting.in/Windows.html");

        //Click button to open a new window
        WebElement newWindowButton = driver.findElement(By.xpath("//button[text()='click']"));
        newWindowButton.click();

        //Get all open window handle
        Set<String> handles = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        //Switch to the new window
        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window: " + driver.getTitle());
                driver.close();
            }
        }

        //Switch back to main window
        driver.switchTo().window(mainWindow);
        System.out.println("Back to main window:" + driver.getTitle());
    }

    //Handle iFrames
    public static void handleFrames() {
        driver.get("https://demo.automationtesting.in/Frames.html");

        // Switch to iFrame
        driver.switchTo().frame(driver.findElement(By.id("singleframe")));

        // Interact with text box inside iFrame
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.sendKeys("Testing iFrame");

        // Switch back to main content
        driver.switchTo().defaultContent();
        System.out.println("iFrame handled successfully!");
    }
}
