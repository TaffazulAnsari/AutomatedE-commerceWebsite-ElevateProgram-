package HandleMultiTabWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class FileUploadDownload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");

        // File Upload
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        uploadElement.sendKeys("C:\\Users\\taffa\\eclipse-workspace\\AutomateTutorialNinja\\src\\test\\resources\\demoUpload.txt");

        // Accept terms and submit
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();

        // Verify upload success
        Thread.sleep(3000);
        WebElement successMsg = driver.findElement(By.id("res"));
        if (successMsg.getText().contains("successfully uploaded")) {
            System.out.println("File uploaded successfully!");
        } else {
            System.out.println("File upload failed!");
        }

        // File Download
        driver.get("https://filesamples.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > a:nth-child(1) > div:nth-child(2) > span:nth-child(1)")).click();
        driver.findElement(By.linkText("Get .csv samples")).click();
        driver.findElement(By.xpath("//div[@class='output']//div[1]//a[1]")).click();
        
        Thread.sleep(2000);

        // Verify download
        File downloadedFile = new File("C:\\Users\\taffa\\Downloads\\sample4.csv");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully!");
        } else {
            System.out.println("File download failed!");
        }

        driver.quit();
    }
}
