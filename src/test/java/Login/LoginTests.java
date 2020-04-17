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
        //Thread.sleep(5000);

        //Mouseover Phones and Tablet Category
        WebElement Phone = driver.findElement(By.linkText("Phones and Tablets"));
        actions.moveToElement(Phone).perform();

        //Select the cover and cases menu
        driver.findElement(By.xpath("//a[@href='/category/cases-covers-5335']")).click();
        //Thread.sleep(3000);

        //Enter search item into searchbox
       //driver.findElement(By.cssSelector("input#jsSearchInput.fe151_2KRxn")).sendKeys("iPhone 6s case");
        driver.findElement(By.xpath("//input[@id='jsSearchInput']")).sendKeys("iPhone 6s case");

        //Press Enter after typing in search text
        //WebElement search = driver.findElement(By.cssSelector("input#jsSearchInput.fe151_2KRxn"));
        //search.sendKeys(Keys.ENTER);
        WebElement search = driver.findElement(By.xpath("//input[@id='jsSearchInput']"));
        search.sendKeys(Keys.ENTER);


    }

    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }

}
