package app.aliexpress.test;

import app.classes.DRIVERS;
import app.classes.SearchAliExpress;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchTest {
        private WebDriver driver;
        String expectedResult = null;
        String actualResult = null;
        String baseURL = "https://www.aliexpress.com/";
        SearchAliExpress searchPage;

        @BeforeTest
        public void openAliExpress(){
                searchPage = new SearchAliExpress(driver);
                driver = searchPage.CreateMyDriver(DRIVERS.CHROME);
                searchPage.visitTo(baseURL);
        }

        @AfterTest
        public void tearDown(){
             //driver.quit();
        }













//searchAli = new SearchAliExpress(driver);

//        @BeforeTest
//        public void openAliExpress(){
//                driver = setUp.CreateMyDriver(DRIVERS.CHROME);
//                //setUp.setDriver(driver);
//                setUp.navegateTo(baseURL);
//
////                expectedResult = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products - AliExpress";
////                actualResult = searchAli.getAliExpressTittle();
////                Assert.assertEquals(actualResult, expectedResult);
//        }
//
//        @Test(priority = 0)
//        public void searchItem(){
//                String search_txt = "Iphone";
//
//                searchAli.searchText(search_txt);
//                searchAli.clickOnSubmitButton();
//
//                expectedResult = "Iphone - Buy Iphone with free shipping on AliExpress";
//                actualResult = searchAli.getAliExpressTittle();
//                Assert.assertEquals(actualResult, expectedResult);
//        }
//


        //WebDriverWait myWait= new WebDriverWait(searchAli.getDriver(), 15);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Boolean getUrl = wait.until(ExpectedConditions.titleContains(expectedResult));
//
//        expectedResult = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products  - AliExpress";
//        actualResult = searchAli.getAliExpressTittle();
//                Assert.assertEquals(actualResult, expectedResult);








}
