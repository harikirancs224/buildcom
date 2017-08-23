package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

public class NewTest {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeTest
    // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser) {

        // If the browser is Firefox, then do this

        if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "../resources/utils/gecko.exe");
            driver = new FirefoxDriver();

            // If browser is Chrome, then do this

        } else if (browser.equalsIgnoreCase("chrome")) {

            // Here I am setting up the path for my Chrome

            System.setProperty("webdriver.chrome.driver", "../sample/src/test/resources/utils/chromedriver.exe");

            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testEasy() throws InterruptedException {
        // Navigate to the Build.com HomePage
        driver.get("https://www.build.com");
        Thread.sleep(10000);
        // Verify the Title of the Page (Title is hidden from the DOM)
        String tti = driver.getTitle();
        if (tti == "Pardon Our Interruption") {
            Thread.sleep(10000);
            System.out.println("Please fill out the captcha manually");
        } else {
            // Close the popup add
            WebDriverWait wait = new WebDriverWait(driver, 1000);
            driver.findElement(By.xpath("//*[@id='email-subscribe-splash']//span[1]")).click();
            // Find the item verify and add to cart
            WebElement textbox = driver.findElement(By.xpath("//input[@id='search_txt']"));
            // Searching for the First Product
            textbox.sendKeys("Suede Kohler K-6626-6U");
            textbox.submit();
            // Verify the element select is Kohler k-6626-6U
            WebElement productver = driver.findElement(By.xpath("//*[@id='heading']"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='heading']")));
            assertThat(productver.getText()).isEqualTo("Kohler k-6626-6U-0");
            // Select the color of the Product which is Suede in this Case
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Suede']")));
            driver.findElement(By.xpath("//img[@alt='Suede']")).click();
            // Add the element to the cart
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//button[@class='btn-standard add-to-cart js-add-to-cart ']")));
            WebElement addtocart = driver
                    .findElement(By.xpath("//button[@class='btn-standard add-to-cart js-add-to-cart ']"));
            addtocart.click();
            Thread.sleep(3000);
            // Adding Second Product to Cart
            WebElement pro1 = driver.findElement(By.id("search_txt"));
            pro1.sendKeys("Cashmere Kohler K-6626-6U");
            pro1.submit();
            WebElement productver1 = driver.findElement(By.xpath("//*[@id='heading']"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='heading']")));
            assertThat(productver1.getText()).isEqualTo("Kohler k-6626-6U-0");

            // Select the color of the Product which is Cashmere in this Case
            driver.findElement(By.xpath("//img[@alt='Cashmere']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@class='btn-standard add-to-cart js-add-to-cart ']")).click();
            // Adding the Third Product to Cart
            Thread.sleep(2000);
            WebElement pro2 = driver.findElement(By.id("search_txt"));
            pro2.sendKeys("Kohler K-5180-ST");
            pro2.submit();
            WebElement productver2 = driver.findElement(By.xpath("//*[@id='heading']"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='heading']")));
            assertThat(productver2.getText()).isEqualTo("Kohler K-5180-ST");
            WebElement quantity = driver.findElement(By.xpath("//*[@id='main-product-quantity']/div/input"));
            quantity.sendKeys(Keys.ARROW_UP);
            driver.findElement(By.xpath("//button[@class='btn-standard add-to-cart js-add-to-cart btn-lg ']")).click();
            Thread.sleep(2000);
            WebElement zip = driver.findElement(By.xpath("//*[@class='js-zip col-xs-8']"));
            zip.sendKeys("95926");
            driver.findElement(By.xpath("//button[@class='btn-standard btn-secondary col-xs-4']")).click();
            driver.findElement(By.xpath("//*[@class='pad-vert align-center hide-portrait']/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='guest-login']/button")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("shippingfirstname")).sendKeys("build");
            driver.findElement(By.id("shippinglastname")).sendKeys("com");
            WebElement zipa = driver.findElement(By.id("shippingpostalcode"));
            zipa.clear();
            zipa.sendKeys("95926");
            driver.findElement(By.id("shippingcity")).sendKeys("Chico");
            Select state = new Select(driver.findElement(By.id("shippingstate_1")));
            state.selectByIndex(10);
            driver.findElement(By.id("shippingaddress1")).sendKeys("402 Otterson Dr");
            driver.findElement(By.id("shippingphonenumber")).sendKeys("8572469285");
            driver.findElement(By.id("emailAddress")).sendKeys("build@gmail.com");
            driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
            Select month = new Select(driver.findElement(By.id("creditCardMonth")));
            month.selectByIndex(3);
            Select year = new Select(driver.findElement(By.id("creditCardYear")));
            year.selectByIndex(3);
            Thread.sleep(1000);
            driver.findElement(By.id("creditcardname")).sendKeys("buildcom");
            driver.findElement(By.id("creditCardCVV2")).sendKeys("888");
            driver.findElement(By.xpath("//*[@id=\"creditcard\"]/div[3]/input")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='checkout']/header/h1")));
            WebElement rd = driver.findElement(By.xpath("//*[@id='checkout']/header/h1"));
            assertThat(rd.getText()).isEqualTo("Review & Delivery (Don't Want Guest? Select Again)");
            WebElement st = driver.findElement(By.id("subtotalamount"));
            System.out.println("I am Here");
            String subt = st.getText().replace("$", "").replace(",", "");
            double sf = Double.parseDouble(subt);
            System.out.println(sf);
            WebElement tax = driver.findElement(By.id("taxAmount"));
            String taxt = tax.getText().replace("$", "").replace(",", "");
            double tf = Double.parseDouble(taxt);
            System.out.println(tf);
            WebElement gt = driver.findElement(By.id("grandtotalamount"));
            String gtot = gt.getText().replace("$", "").replace(",", "");
            double gf = Double.parseDouble(gtot);
            System.out.println(gf);
            double ftval = (sf * 0.0725);
            assertThat(ftval).isEqualTo(tf);
            assertThat(sf + tf).isEqualTo(gf);
        }

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
