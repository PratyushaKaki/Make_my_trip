package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import dev.failsafe.internal.util.Assert;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://www.makemytrip.com/";
        if(actualResult.equals(expectedResult)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        //click from btn
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        Thread.sleep(2000);
        //entering text in to from box
        WebElement frombox = driver.findElement(By.xpath("//input[@placeholder='From']"));
        frombox.sendKeys("blr");
        Thread.sleep(2000);
        //click on banglore location in list
        WebElement bangloreloc = driver.findElement(By.xpath("//p[text()='Bengaluru, India']"));
        bangloreloc.click();
        Thread.sleep(2000);
        //click to btn
        driver.findElement(By.xpath("//label[@for='toCity']")).click();
        Thread.sleep(2000);
        //entering text in to TO btn
        WebElement tobox = driver.findElement(By.xpath("//input[@placeholder='To']"));
        tobox.sendKeys("del");
        Thread.sleep(2000);
        //click on new delhi location in list
        WebElement delhiloc = driver.findElement(By.xpath("//p[text()='New Delhi, India']"));
        delhiloc.click();
        Thread.sleep(2000);
        //click on JAN20 2024 btn
        WebElement calendar20Date = driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']"));
        WebElement Jan20 = driver.findElement(By.xpath("//div[text()='January 2024']"));
        String calendartext = Jan20.getText();
        //String expcalendardate = "20";
        if(calendartext.contains("January 2024")) {
            System.out.println("Date is matched");
        } else {
            System.out.println("Date is not matched");
        }
        calendar20Date.click();
        
        Thread.sleep(2000);
        //click on search btn
        WebElement searchbtn = driver.findElement(By.xpath("//a[text()='Search']"));
        searchbtn.click();
        Thread.sleep(10000);
        //store the price of the flight and print the value of the price
        WebElement adult = driver.findElement(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        String pricevalue = adult.getText();
        System.out.println("The price of the flight is " +pricevalue);
        System.out.println("end Test case: testCase02");
    }


    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        //click train btn
        driver.findElement(By.xpath("//span[text()='Trains']")).click();
        //click from btn
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        Thread.sleep(2000);
        //entering text in to from box
        WebElement frombox = driver.findElement(By.xpath("//input[@placeholder='From']"));
        frombox.sendKeys("ypr");
        Thread.sleep(2000);
        //click banglore location in list
        WebElement bangloreloc = driver.findElement(By.xpath("//span[text()='YPR']"));
        bangloreloc.click();
        Thread.sleep(2000);
        //entering text into TO box
        WebElement tobox = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
        tobox.sendKeys("ndls");
        Thread.sleep(2000);
        //click delhi location in list
        WebElement delhiloc = driver.findElement(By.xpath("//span[text()='NDLS']"));
        delhiloc.click();
        Thread.sleep(2000);
        //click on JAN20 2024 btn
        WebElement calendar20Date = driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']"));
        WebElement Jan20 = driver.findElement(By.xpath("//div[text()='January 2024']"));
        String calendartext = Jan20.getText();
        //String expcalendardate = "20";
        if(calendartext.contains("January 2024")) {
            System.out.println("Date is matched");
        } else {
            System.out.println("Date is not matched");
        }
        calendar20Date.click();
    
        Thread.sleep(2000);
        //click third AC btn
        WebElement thirdAc = driver.findElement(By.xpath("//li[text()='Third AC']"));
        thirdAc.click();
        //click on search btn
        WebElement searchbtn = driver.findElement(By.xpath("//a[text()='Search']"));
        searchbtn.click();
        Thread.sleep(10000);
        //store the price of the 3AC train and print the value of the price
        WebElement price = driver.findElement(By.xpath("//div[@class='ticket-price justify-flex-end']"));
        String pricevalue = price.getText();
        System.out.println("The price of the Train 3AC is " +pricevalue);
        System.out.println("end Test case: testCase03");
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(5000);
        //click buses btn
        driver.findElement(By.xpath("//span[text()='Buses']")).click();
        Thread.sleep(3000);
        //click from btn
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        Thread.sleep(2000);
        //entering text in to from box
        WebElement frombox = driver.findElement(By.xpath("//input[@placeholder='From']"));
        frombox.sendKeys("banglore");
        Thread.sleep(2000);
        //click on banglore location in list
        WebElement bangloreloc = driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']"));
        bangloreloc.click();
        Thread.sleep(2000);
        WebElement tobox = driver.findElement(By.xpath("//input[@placeholder='To']"));
        tobox.sendKeys("New Delhi");
        Thread.sleep(2000);
        //click on new delhi location in list
        WebElement delhiloc = driver.findElement(By.xpath("//span[text()='Delhi']"));
        delhiloc.click();
        Thread.sleep(2000);
        //click on JAN20 2024 btn
        WebElement calendar20Date = driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']"));
        WebElement Jan20 = driver.findElement(By.xpath("//div[text()='January 2024']"));
        String calendartext = Jan20.getText();
        //String expcalendardate = "20";
        if(calendartext.contains("January 2024")) {
            System.out.println("Date is matched");
        } else {
            System.out.println("Date is not matched");
        }
        calendar20Date.click();
        Thread.sleep(2000);
        //click on search btn
        WebElement searchbtn = driver.findElement(By.id("search_button"));
        searchbtn.click();
        Thread.sleep(10000);
        //verific NO SUCH BUSES ARE FOUND ON 20TH JAN"
        WebElement verifyTexxt = driver.findElement(By.xpath("//span[text()='No buses found for 20 Jan']"));
        
        String actualmessage = verifyTexxt.getText();
        String expectedmessage = "No buses found for 20 Jan";
        if(actualmessage.equals(expectedmessage)) {
            System.out.println("No buses found is Displayed");
        } else {
            System.out.println("No buses found is not Displayed");
        }
    
        System.out.println("end Test case: testCase04");
    }



}
