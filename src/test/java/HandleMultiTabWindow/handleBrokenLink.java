package HandleMultiTabWindow;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleBrokenLink {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/"
        		+ "");
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + links.size());
        
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                checkBrokenLink(url);
            }
        }
        
        driver.quit();
    }
    
    public static void checkBrokenLinksAndImages(WebDriver driver) {
        // Find all <a> and <img> tags
        List<WebElement> elements = driver.findElements(By.xpath("//a[@href] | //img[@src]"));

        System.out.println("Total links and images found: " + elements.size());

        for (WebElement element : elements) {
            String url = element.getTagName().equals("a") ? element.getAttribute("href") : element.getAttribute("src");

//            // Validate the URL
//            if (url != null && !url.isEmpty() && !url.startsWith("javascript")) {
//                verifyURL(url);
//            } else {
//                System.out.println("Skipping empty or JavaScript URL: " + url);
//            }
        }
    }

    public static void checkBrokenLink(String linkUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            System.out.println(linkUrl + " >>> " + connection.getResponseMessage() + 
                (connection.getResponseCode() >= 400 ? " is a broken link" : ""));
        } catch (IOException e) {
            System.out.println(linkUrl + " >>> Could not be checked: " + e.getMessage());
        }
    }
}
