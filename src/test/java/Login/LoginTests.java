package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //fetch URL to automate
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);

        // maximize the page of your browser while page loads
        driver.manage().window().maximize();

        // get page title
        System.out.println(driver.getTitle());

        // make page wait while url fully loads
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        //click on login/signup button
        driver.findElement(By.linkText("Login / Signup")).click();

        //Enter username
        driver.findElement(By.id("username")).sendKeys("henryt1455@gmail.com");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("7FE@fake");

        //Click on Login
        driver.findElement(By.xpath("//button[text() = 'Login']")).click();

        //Wait, so the next operation won't happen so fast
        Thread.sleep(5000);

        //Mouseover Phones and Tablet Category
        WebElement Phone = driver.findElement(By.linkText("Phones and Tablets"));
        actions.moveToElement(Phone).perform();

        //Select the cover and cases menu
        driver.findElement(By.xpath("//a[@href='/category/cases-covers-5335']")).click();
        Thread.sleep(5000);

        //Enter search item into searchbox
        driver.findElement(By.cssSelector(".f6ed2_25oVd #jsSearchInput")).sendKeys("iPhone 6s case");

        //Press Enter after typing in search text
        WebElement search = driver.findElement(By.cssSelector(".f6ed2_25oVd #jsSearchInput"));
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        //Click on the Add to cart button
        driver.findElement(By.xpath("(//button[@class='_0a08a_3czMG' and text() = 'Add To Cart'])[2]")).click();

        //Click on the My Cart menu button
        driver.findElement(By.xpath("//a[@class='_79484_1sLEt _7ad32_SD12Y _16536_xxIKG' and @href='/cart/overview']")).click();

        //Increase the number of item to four
        //WebElement item = driver.findElement(By.xpath("//div[@class='a03ba_1Zj-T']"));
        //int itemno = Integer.parseInt(item.getText());
        //WebElement increase = driver.findElement(By.xpath("//button[@name='increment']"));

        //while (itemno < 4){
        //   increase.click();
       // }

        //Increase the number of item to four
        driver.findElement(By.xpath("//button[@name='increment']")).click();
        driver.findElement(By.xpath("//button[@name='increment']")).click();
        driver.findElement(By.xpath("//button[@name='increment']")).click();
        Thread.sleep(5000);

        //Click on Checkout
        driver.findElement(By.xpath("//button[@class='_0a08a_3czMG' and text() = 'Checkout']")).click();
        Thread.sleep(7000);

        //Select the PAY NOW Option
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG _4a291_2cOtr' and @name = 'selectPaymentMethod']")).click();

        //Click on the Continue to Payment button
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG' and @name='placeOrder']")).click();

        //Select iframe that comes up for payment
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);

        //Click on the card option
        driver.findElement(By.xpath("//button[@class = 'dashboard-card__button Card']")).click();

        //Enter the card number
        driver.findElement(By.xpath("//input[@class = 'card-number input_class' and @id = 'card-number']")).sendKeys("245376409876344");

        //Enter Expiry Date
        driver.findElement(By.xpath("//input[@class = 'date input_class' and @id = 'expiry']")).sendKeys("0520");

        //Enter CVV
        driver.findElement(By.xpath("//input[@class = 'cvv input_class' and @id = 'cvv']")).sendKeys("987");

        //Click on the Pin input box
        driver.findElement(By.xpath("//input[@class = 'card-pin' and @id = 'card-pin-new']")).click();

        //Enter Pin
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '3']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '4']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '0']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '1']")).click();

        //Print error message of card number field
        WebElement error = driver.findElement(By.xpath("//label[@id='card-number_unhappy' and text() = 'Invalid card number']"));
        String errorPrint = error.getText();
        System.out.println(errorPrint);

    }

    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }

}
