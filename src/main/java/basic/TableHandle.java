package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TableHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Get table cell value at row 1 and column 2
        String tableLocator = "//table[@id='product']";
        String value = getTableCellValue2(driver, tableLocator, 1, 2);
        System.out.println(value);

        driver.quit();
    }

    /**
     * Get table cell value by index
     * @param tableLocator
     * @param row : row data index .Ex: 1 is first row
     * @param col : col data index .Ex: 1 is first column
     */
    public static String getTableCellValue(WebDriver driver, String tableLocator, int row, int col) {
        int actualRow = row + 1;
        String cellDynamicLocator = tableLocator + "/tbody/tr[%d]/td[%d]";
        String cellLocator = String.format(cellDynamicLocator, actualRow, col);
        WebElement cellElement = driver.findElement(By.xpath(cellLocator));
        return cellElement.getText();
    }

    public static String getTableCellValue2(WebDriver driver, String tableLocator, int row, int col) {
        String cellDynamicLocator = "(" + tableLocator + "/tbody/tr[not (./th)])[%d]/td[%d]";
        String cellLocator = String.format(cellDynamicLocator, row, col);
        WebElement cellElement = driver.findElement(By.xpath(cellLocator));
        return cellElement.getText();
    }

    public static String getTableCellByColumnName(WebDriver driver, String tableLocator, int row, String colName) {

        return "";
    }

    public static String getTableHeader(WebDriver driver, String tableLocator, int index) {

        return "";
    }

    public static boolean isCellDataExist(WebDriver driver, String tableLocator, String cellValue) {

        return true;
    }

    public static List<String> getAllTableCellValue(WebDriver driver, String tableLocator) {

        return null;
    }
}
