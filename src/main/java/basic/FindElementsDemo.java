package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FindElementsDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demo1.cybersoft.edu.vn/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //luc tim thay, tra ve list WebElements
        List<WebElement> listCell = driver.findElements(By.xpath("//span[text()='C18']"));
        System.out.println(listCell.size()); // 54

        //luc ko tim thay, tra ve list empty
        List<WebElement> listCell2 = driver.findElements(By.xpath("//span[text()='C1800']"));
        System.out.println(listCell2.isEmpty()); // true
        System.out.println(listCell2.size()); // 0


        driver.quit();
    }
}
