package HandleMultiTabWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSubmitAndValidation {
    public static void main(String[] args) throws InterruptedException { 
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        // Fill First and Last Name
        driver.findElement(By.id("firstName")).sendKeys("Taffazul");
        driver.findElement(By.id("lastName")).sendKeys("Ansari");

        // Fill Email
        driver.findElement(By.id("userEmail")).sendKeys("taffazulansari7979@gmail.com");

        // Select Gender
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        
        // Fill Mobile Number
        driver.findElement(By.id("userNumber")).sendKeys("7979047741");

        // Select Date of Birth
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys("1997");
        driver.findElement(By.cssSelector(".react-datepicker__month-select")).sendKeys("December");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='22']")).click();
        //Thread.sleep(3000);
        // Add Subjects
//        driver.findElement(By.cssSelector(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3")).sendKeys("Computer Science");
        
        //subject
//        Thread.sleep(1000);
//        WebElement sub = driver.findElement(By.xpath("(//div[contains(@class,'subjects-auto-complete__value-container')])[1]"));
//        sub.sendKeys("English");
//        sub.click();
        
        //WebElement = driver.findElement(By.xpath("(//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3'])[1]")).sendKeys("English");
        
        
        // Select Hobbies
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();

        // Upload Picture
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\taffa\\eclipse-workspace\\AutomateTutorialNinja\\src\\test\\resources\\images.jpeg");

        // Fill Address
        Thread.sleep(2000);
        driver.findElement(By.id("currentAddress")).sendKeys("Hazaribagh, Jharkhand");

        // Select State and City
        Thread.sleep(3000);
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        driver.quit();
    }
}
