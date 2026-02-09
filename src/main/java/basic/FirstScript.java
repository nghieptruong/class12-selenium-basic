package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
//        Start Firefox browser (geckodriver)
//        WebDriver driver = new FirefoxDriver();

//        Start Edge browser (msedgedriver)
//        WebDriver driver = new EdgeDriver();

//        Start Safari browser
//        WebDriver driver = new SafariDriver();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        //dung debug, latest version ko bi bug, khach hang (client) sao thay bug tren chrome version 143
//        options.setBrowserVersion("143");

        //      Start Chrome browser (chromedriver)
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demo1.cybersoft.edu.vn/");
        driver.manage().window().maximize(); // maximize browser
        Thread.sleep(3000);
        driver.quit(); // exit driver (tat browser & chromedriver process bi kill)
    }
}
