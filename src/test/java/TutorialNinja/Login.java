package TutorialNinja;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/Login.xlsx", "Login");
    }

    @Test(dataProvider = "LoginData")
    public void testLogin(String email, String password) throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        
        Thread.sleep(1000);
        
    }
}
