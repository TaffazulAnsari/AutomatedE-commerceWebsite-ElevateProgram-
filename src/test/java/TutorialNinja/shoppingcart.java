package TutorialNinja;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class shoppingcart extends BaseTest {

    @DataProvider(name = "cartData")
    public Object[][] cartDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/shoppingcart.xlsx", "shoppingcart");
    }

    @Test(dataProvider = "cartData")
    public void testShoppingCart(String productName) throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();
    }
}
