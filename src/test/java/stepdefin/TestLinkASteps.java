package stepdefin;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages1.TestLinkAGetcalley;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLinkASteps {
    WebDriver driver;
    TestLinkAGetcalley testLinkAGetcalley;
    String browserName;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws InterruptedException {
        this.browserName = browser;
      //  if (browser.equalsIgnoreCase("chrome")) {
        //    WebDriverManager.chromedriver().setup();
         //   driver = new ChromeDriver();
       // } else 
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }  
      
        driver.manage().window().maximize();
        driver.get("https://www.getcalley.com/page-sitemap.xml");
        testLinkAGetcalley = new TestLinkAGetcalley(driver);
        Thread.sleep(3000);
    }

    @DataProvider(name = "resolutions")
    public Object[][] resolutions() {
        return new Object[][]{
                {"Desktop", 1920, 1080}, // Desktop
                {"Desktop", 1366, 768},  // Desktop
                {"Desktop", 1536, 864},  // Desktop
                {"Mobile", 360, 640},   // Mobile
                {"Mobile", 414, 896},   // Mobile
                {"Mobile", 375, 667}    // Mobile
        };
    }

    @Test(dataProvider = "resolutions")
    public void testLinkA(String device, int width, int height) throws InterruptedException {
        takeScreenshot(device, "LinkA", width, height);
    }

    @Test(dataProvider = "resolutions")
    public void testLinkB(String device, int width, int height) throws InterruptedException {
        takeScreenshot(device, "LinkB", width, height);
    }

    @Test(dataProvider = "resolutions")
    public void testLinkC(String device, int width, int height) throws InterruptedException {
        takeScreenshot(device, "LinkC", width, height);
    }

    @Test(dataProvider = "resolutions")
    public void testLinkD(String device, int width, int height) throws InterruptedException {
        takeScreenshot(device, "LinkD", width, height);
    }

    @Test(dataProvider = "resolutions")
    public void testLinkE(String device, int width, int height) throws InterruptedException {
        takeScreenshot(device, "LinkE", width, height);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String device, String linkName, int width, int height) throws InterruptedException {
        driver.manage().window().setSize(new Dimension(width, height));
        // Call the appropriate method in testLinkAGetcalley based on linkName
        switch (linkName) {
            case "LinkA":
                testLinkAGetcalley.clickLinkA();
                break;
            case "LinkB":
                testLinkAGetcalley.clickLinkB();
                break;
            case "LinkC":
                testLinkAGetcalley.clickLinkC();
                break;
            case "LinkD":
                testLinkAGetcalley.clickLinkD();
                break;
            case "LinkE":
                testLinkAGetcalley.clickLinkE();
                break;
        }
        Thread.sleep(2000);
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String folderPath = String.format("screenshots/%s/%s/Resolution-%dx%d", browserName, device, width, height);
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        Shutterbug.shootPage(driver, Capture.FULL, true)
                .withName(linkName + "-" + timestamp)
                .save(directory.getAbsolutePath());
    }
}
