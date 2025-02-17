package TutorialNinja;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class wishlist extends BaseTest {

    @DataProvider(name = "wishlistData")
    public Object[][] wishlistDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/wishlist.xlsx", "wishlist");
    }

    @Test(dataProvider = "wishlistData")
    public void testWishList(String productName) throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector("button[type='button'][class*='btn-lg']")).click();
        driver.findElement(By.cssSelector("button[type='button'] i[class='fa fa-heart']")).click();
        driver.findElement(By.cssSelector("a[id='wishlist-total'] i[class='fa fa-heart']")).click();
        
        //login
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Taffazulansari7979@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Taffazul123");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        
        //logout
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")).click();
        
    }
}
