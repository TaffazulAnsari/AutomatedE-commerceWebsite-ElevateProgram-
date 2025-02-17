package TutorialNinja;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class Cart extends BaseTest {

    @DataProvider(name = "CartData")
    public Object[][] cartDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/Cart.xlsx", "Cart");
    }

    @Test(dataProvider = "CartData")
    public void testCart(String productName, String quantity) throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector("button[type='button'][class*='btn-lg']")).click();
        driver.findElement(By.xpath("//a[contains(text(), '" + productName + "')]")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys(quantity);
        driver.findElement(By.id("button-cart")).click();
        
        Thread.sleep(1000);
    }
}