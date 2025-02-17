package TutorialNinja;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class checkout extends BaseTest {

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/checkout.xlsx", "checkout");
    }

    @Test(dataProvider = "checkoutData")
    public void testCheckout(String productName, String quantity, String couponCode, 
                             String country, String region, String postCode, String giftCode) 
                             throws InterruptedException {
       
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector("button[type='button'][class*='btn-lg']")).click();
        driver.findElement(By.cssSelector("button[onclick*='cart.add']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Shopping Cart")).click();
        Thread.sleep(2000);
        WebElement qtyField = driver.findElement(By.cssSelector("input[name*='quantity']"));
        qtyField.clear();
        qtyField.sendKeys(quantity);
        driver.findElement(By.cssSelector("button[data-original-title='Update']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Use Coupon Code")).click();
        driver.findElement(By.id("input-coupon")).sendKeys(couponCode);
        driver.findElement(By.id("button-coupon")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Estimate Shipping & Taxes")).click();
        driver.findElement(By.id("input-country")).sendKeys(country);
        driver.findElement(By.id("input-zone")).sendKeys(region);
        driver.findElement(By.id("input-postcode")).sendKeys(postCode);
        driver.findElement(By.id("button-quote")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Use Gift Certificate")).click();
        driver.findElement(By.id("input-voucher")).sendKeys(giftCode);
        driver.findElement(By.id("button-voucher")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Checkout")).click();
        Thread.sleep(2000);
    }
}
