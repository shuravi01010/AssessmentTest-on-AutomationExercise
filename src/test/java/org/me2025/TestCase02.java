package org.me2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCase02 {

    public static void main(String[] args) throws InterruptedException {
        // 1. Set up WebDriver (No need to manually download ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "D:\\2024-automation-qa-lab\\chrome\\chromedriver-feb25.exe");        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to URL
        driver.get("http://automationexercise.com");

        // 3. Verify home page is visible
        if (driver.getTitle().contains("Automation Exercise")) {
            System.out.println("Home page is visible.");
        } else {
            System.out.println("Home page not visible.");
        }

        // 4. Click 'View Product' for first product
        driver.findElement(By.cssSelector("a[href*='product_details']")).click();
        Thread.sleep(2000); // Wait for page load

        // 5. Verify product detail page is opened
        WebElement productInfo = driver.findElement(By.className("product-information"));
        if (productInfo.isDisplayed()) {
            System.out.println("Product details page opened.");
        } else {
            System.out.println("Product details page not visible.");
        }

        // 6. Increase quantity to 4
        WebElement quantityBox = driver.findElement(By.id("quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("4");

        // 7. Click 'Add to Cart'
        driver.findElement(By.cssSelector("button.btn.btn-default.cart")).click();
        Thread.sleep(2000); // Wait for modal popup

        // 8. Click 'View Cart'
        driver.findElement(By.xpath("//a[contains(@href, 'view_cart')]")).click();
        Thread.sleep(2000); // Wait for page load

        // 9. Verify product is in cart with correct quantity
        WebElement cartQuantity = driver.findElement(By.cssSelector("td.cart_quantity input"));
        String actualQuantity = cartQuantity.getAttribute("value");
        if (actualQuantity.equals("4")) {
            System.out.println("Product is in cart with correct quantity.");
        } else {
            System.out.println("Quantity mismatch! Expected 4 but got " + actualQuantity);
        }

        // Close browser
        //driver.quit();

    }

}
