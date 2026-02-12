package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //khai bao dynamic locator cho radio button
        String dynamicLocatorRadio = "//input[@type='radio' and @value='%s']";

        //Step: Select Benz radio
        selectRadioValue(driver, dynamicLocatorRadio, "benz");

        Thread.sleep(3000);

        //Step: Select Honda radio
        selectRadioValue(driver, dynamicLocatorRadio, "honda");

        Thread.sleep(3000);

        driver.quit();
    }
    public static void selectRadioValue(WebDriver driver, String dynamicLocator, String value) {
        String locator = String.format(dynamicLocator, value);
        By byRadButton = By.xpath(locator);
        WebElement radButton = driver.findElement(byRadButton);
        radButton.click();
    }
}
