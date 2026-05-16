package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterPage {

    //variables
    private final WebDriver driver;

    //locators
    private final By filterDropdown =By.className("product_sort_container");
    private final By productNames =By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");
    // constructor

    public FilterPage(WebDriver driver){
        this.driver = driver;
    }

    //Actions
    //selectNameAToZ()
    public FilterPage selectNameAToZ() {

        Select select = new Select(driver.findElement(filterDropdown));

        select.selectByVisibleText("Name (A to Z)");

        return this;
    }
    //selectNameZToA()
    public FilterPage selectNameZToA() {

        Select select = new Select(driver.findElement(filterDropdown));

        select.selectByVisibleText("Name (Z to A)");

        return this;
    }
   // selectPriceLowToHigh()
   public FilterPage selectPriceLowToHigh() {

       Select select = new Select(driver.findElement(filterDropdown));

       select.selectByVisibleText("Price (low to high)");

       return this;
   }
    //selectPriceHighToLow()
    public FilterPage selectPriceHighToLow() {

        Select select = new Select(driver.findElement(filterDropdown));

        select.selectByVisibleText("Price (high to low)");

        return this;
    }
//validation
   // assertProductsSortedAscending()
public FilterPage assertProductsSortedAscending() {

    List<WebElement> productElements = driver.findElements(productNames);

    List<String> actualProducts = new ArrayList<>();

    for (WebElement product : productElements) {

        actualProducts.add(product.getText());
    }

    List<String> expectedProducts =new ArrayList<>(actualProducts);

    Collections.sort(expectedProducts);

    Assert.assertEquals(actualProducts, expectedProducts);

    return this;
}

   // assertProductsSortedDescending()
   public FilterPage assertProductsSortedDescending() {

       List<WebElement> productElements = driver.findElements(productNames);

       List<String> actualProducts = new ArrayList<>();

       for (WebElement product : productElements) {

           actualProducts.add(product.getText());
       }

       List<String> expectedProducts =new ArrayList<>(actualProducts);

       expectedProducts.sort(Collections.reverseOrder());
       // Collections.sort(expectedProducts, Collections.reverseOrder());
       Assert.assertEquals(actualProducts, expectedProducts);

       return this;
   }
   // assertPricesSortedLowToHigh()
   public FilterPage assertPricesSortedLowToHigh() {

       List<WebElement> priceElements =
               driver.findElements(productPrices);

       List<Double> actualPrices = new ArrayList<>();

       for (WebElement price : priceElements) {

           String priceText =
                   price.getText().replace("$", "");

           actualPrices.add(Double.parseDouble(priceText));
       }

       List<Double> expectedPrices =
               new ArrayList<>(actualPrices);

       Collections.sort(expectedPrices);

       Assert.assertEquals(actualPrices, expectedPrices);

       return this;
   }
   // assertPricesSortedHighToLow()
   public FilterPage assertPricesSortedHighToLow() {

       List<WebElement> priceElements =
               driver.findElements(productPrices);

       List<Double> actualPrices = new ArrayList<>();

       for (WebElement price : priceElements) {

           String priceText =
                   price.getText().replace("$", "");

           actualPrices.add(Double.parseDouble(priceText));
       }

       List<Double> expectedPrices =
               new ArrayList<>(actualPrices);

       expectedPrices.sort(Collections.reverseOrder());

       Assert.assertEquals(actualPrices, expectedPrices);

       return this;
   }
}
