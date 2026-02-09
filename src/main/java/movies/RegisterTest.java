package movies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

public class RegisterTest {
    public static void main(String[] args) throws InterruptedException {

        String account = UUID.randomUUID().toString();
        System.out.println(account);
        String email = account + "@example.com";

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        //Step 1: Go to https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn/");
        driver.manage().window().maximize(); // maximize browser
        Thread.sleep(3000); // hard sleep (đợi chết 3s)

        //Step 2: Click on "Đăng Ký" link on the top right
        By byLnkRegister = By.xpath("//a[@href='/sign-up']");
        WebElement lnkRegister = driver.findElement(byLnkRegister);
        lnkRegister.click();

        Thread.sleep(3000);

        //Step 3: Enter account name
        By byTxtAccount = By.id("taiKhoan");
        WebElement txtAccount = driver.findElement(byTxtAccount);
        txtAccount.sendKeys(account);

        Thread.sleep(3000);

        //Step 4: Enter password
        By byTxtPassword = By.id("matKhau");
        WebElement txtPassword = driver.findElement(byTxtPassword);
        txtPassword.sendKeys("Test123456@");

        Thread.sleep(3000);

        //Step 5: Re-enter password
        By byTxtRePassword = By.id("confirmPassWord");
        WebElement txtRePassword = driver.findElement(byTxtRePassword);
        txtRePassword.sendKeys("Test123456@");

        Thread.sleep(3000);

        //Step 6: Enter full name
        By byTxtFullName = By.id("hoTen");
        WebElement txtFullName = driver.findElement(byTxtFullName);
        txtFullName.sendKeys("Nghiep Truong");

        Thread.sleep(3000);

        //Step 7: Enter email
        By byTxtEmail = By.id("email");
        WebElement txtEmail = driver.findElement(byTxtEmail);
        txtEmail.sendKeys(email);

        Thread.sleep(3000);

        //Step 8: Click "Đăng Ký" button
        By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
        WebElement btnRegister = driver.findElement(byBtnRegister);
        btnRegister.click();

        Thread.sleep(3000);

        driver.quit(); // quit driver
    }
}
