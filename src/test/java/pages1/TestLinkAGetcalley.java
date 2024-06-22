package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestLinkAGetcalley {
    WebDriver driver;

    // Locators
    By calleyLinkA = By.linkText("https://www.getcalley.com/");
    By calleyLinkB = By.linkText("https://www.getcalley.com/calley-call-from-browser/");
    By calleyLinkC = By.linkText("https://www.getcalley.com/calley-pro-features/");
    By calleyLinkD = By.linkText("https://www.getcalley.com/best-auto-dialer-app/");
    By calleyLinkE = By.linkText("https://www.getcalley.com/how-calley-auto-dialer-app-works/");

    // Constructor
    public TestLinkAGetcalley(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkA() {
        driver.findElement(calleyLinkA).click();
    }

    public void clickLinkB() {
        driver.findElement(calleyLinkB).click();
    }

    public void clickLinkC() {
        driver.findElement(calleyLinkC).click();
    }

    public void clickLinkD() {
        driver.findElement(calleyLinkD).click();
    }

    public void clickLinkE() {
        driver.findElement(calleyLinkE).click();
    }

    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
