package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckboxHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Step: checkbox1 is unchecked
        By byChkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
        setCheckbox(driver, byChkbox1, false);

        //Step: checkbox2 is checked
        By byChkbox2 = By.xpath("(//input[@type='checkbox'])[2]");
        setCheckbox(driver, byChkbox2, true);

        Thread.sleep(3000);

        driver.quit();
    }

    /**
     * click on checkbox
     * @param driver
     * @param locator
     * @param status Ex: true(selected), false(unselected)
     */
    public static void setCheckbox(WebDriver driver, By locator, boolean status) {
        WebElement chkBox = driver.findElement(locator);
        boolean isSelected = chkBox.isSelected(); // kiem tra trang thai checkbox co dang dc chon chua
        if(status != isSelected) {
            chkBox.click();
        }
    }
}
