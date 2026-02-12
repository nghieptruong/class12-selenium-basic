package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        By bySelCarDropdown = By.id("carselect");
        WebElement carDropdownElement = driver.findElement(bySelCarDropdown);
        Select selCarDropdown = new Select(carDropdownElement);
//        selCarDropdown.selectByValue("benz");
//        selCarDropdown.selectByVisibleText("Benz");
//        selCarDropdown.selectByIndex(1); // index tinh tu 0

        //Step: Check default selected option
        WebElement defaultOptionElement = selCarDropdown.getFirstSelectedOption();
        System.out.println(defaultOptionElement.getText());

        //Step: Kiem tra cac options. Expected nhu sau: BMZ, Benz, Honda
        List<String> listOptions = new ArrayList<>();
        List<WebElement> listElements = selCarDropdown.getOptions();
        for (WebElement element : listElements) {
            String option = element.getText();
            listOptions.add(option);
        }
        System.out.println(listOptions);

        Thread.sleep(3000);

        driver.quit();
    }
}
