package TutorialNinja;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class search extends BaseTest {

    @DataProvider(name = "searchData")
    public Object[][] searchDataProvider() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/search.xlsx", "search");
    }

    @Test(dataProvider = "searchData")
    public void testCart(String productName) throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys(productName);
        driver.findElement(By.cssSelector("button[type='button'][class*='btn-lg']")).click();
    }
}
