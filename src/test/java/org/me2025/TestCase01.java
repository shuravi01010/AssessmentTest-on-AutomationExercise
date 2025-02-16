package org.me2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import java.io.FileWriter;
import java.io.IOException;

public class TestCase01 {
    public static void main(String[] args) {
        // Setup WebDriver
        // Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\2024-automation-qa-lab\\chrome\\chromedriver-feb25.exe");
        WebDriver driver=new ChromeDriver();

        // Microsoft Edge browser
//        System.setProperty("webdriver.edge.driver", "D:\\2024-automation-qa-lab\\microsoft-edge\\msedgedriver.exe");
//        WebDriver driver = new EdgeDriver();

        try {
            // Step 1: Launch browser
            driver.manage().window().maximize();

            // Step 2: Navigate to URL
            driver.get("http://automationexercise.com");

            // Step 3: Verify home page is visible
            WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
            if (homePage.isDisplayed()) {
                System.out.println("Home page is visible.");
            } else {
                System.out.println("Home page is NOT visible.");
            }

            // Step 4: Click on 'Products' button
            WebElement productsButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
            productsButton.click();

            // Step 5: Verify user is navigated to ALL PRODUCTS page
            WebElement allProductsPage = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
            if (allProductsPage.isDisplayed()) {
                System.out.println("Navigated to ALL PRODUCTS page.");
            } else {
                System.out.println("Failed to navigate to ALL PRODUCTS page.");
            }

            // Step 6: Enter product name in search input and click search button
            WebElement searchBox = driver.findElement(By.id("search_product"));
            searchBox.sendKeys("Summer White Top\n" + "\n\n" + "\n");

            WebElement searchButton = driver.findElement(By.id("submit_search"));
            searchButton.click();

            // Step 7: Verify 'SEARCHED PRODUCTS' is visible
            WebElement searchedProducts = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
            if (searchedProducts.isDisplayed()) {
                System.out.println("'SEARCHED PRODUCTS' is visible.");
            } else {
                System.out.println("'SEARCHED PRODUCTS' is NOT visible.");
            }

            // Step 8: Verify all related products are visible
            WebElement productResults = driver.findElement(By.className("product-grid"));
            if (productResults.isDisplayed()) {
                System.out.println("All related products are visible.");
            } else {
                System.out.println("No related products found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
    // Generate HTML report
//        private void generateReport() {
//            reportContent.append("</table></body></html>");
//            try (FileWriter fileWriter = new FileWriter("test-output/ExtentReport.html")) {
//            fileWriter.write(reportContent.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
