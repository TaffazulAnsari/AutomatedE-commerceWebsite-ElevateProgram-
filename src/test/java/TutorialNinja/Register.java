package TutorialNinja;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class Register extends BaseTest {

    @DataProvider(name = "RegisterData")
    public Object[][] registerDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/Register.xlsx", "Register");
    }

    @Test(dataProvider = "RegisterData")
    public void testRegister(String firstname, String lastname, String email, String telephone, String password, String confirmPassword) throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
        driver.findElement(By.cssSelector("input[value='1'][name='agree']")).click();
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        Thread.sleep(1000);
    }
}
