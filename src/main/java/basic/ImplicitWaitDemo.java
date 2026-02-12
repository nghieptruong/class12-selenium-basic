package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ImplicitWaitDemo {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        //Step 1: Go to https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn/");
        driver.manage().window().maximize(); // maximize browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Step 2: Click on "Đăng Ký" link on the top right
        By byLnkRegister = By.xpath("//a[@href='/sign-up']");

        ZonedDateTime startTime = null;
        try {
            startTime = ZonedDateTime.now(); // lay current time (time hien tai)
            WebElement lnkRegister = driver.findElement(byLnkRegister);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ZonedDateTime endTime = ZonedDateTime.now(); // lay current time (time hien tai)
            long duration = ChronoUnit.SECONDS.between(startTime, endTime);
            System.out.println("Duration = " + duration);
        }
    }
}
