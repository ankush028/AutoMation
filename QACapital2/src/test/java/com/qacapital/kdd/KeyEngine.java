package com.qacapital.kdd;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class KeyEngine {

    public static WebDriver driver;

    public void executeTest(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String keyword = row.getCell(0).getStringCellValue();
            String locatorType = row.getCell(1).getStringCellValue();
            String locatorValue = row.getCell(2).getStringCellValue();
            String data = row.getCell(3).getStringCellValue();

            service(keyword, locatorType, locatorValue, data);
        }

        workbook.close();
    }

    public void service(String keyword, String locatorType, String locatorValue, String data){

        switch (keyword){
            case "OpenBrowser":
                if(data.equals("firefox")) {
                    driver = new FirefoxDriver();
                }else{
                    driver = new ChromeDriver();
                    }
                driver.manage().window().maximize();
                break;
            case "navigate":
                driver.get(data);
                break;
            case "sendKeys":
//                findElement(locatorType,locatorValue).clear();
                findElement(locatorType,locatorValue).sendKeys(data);
                break;
            case "click":
                findElement(locatorType, locatorValue).click();
                break;
            case "close":
                driver.quit();
                break;
            case "NA":
                break;
            default:
                System.out.println("Invalid keyword"+keyword);
        }

    }
    public static WebElement findElement(String locatorType, String locatorValue){
        WebElement element = null;

            switch (locatorType){
                case "id":
                    element = driver.findElement(By.id(locatorValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(locatorValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(locatorValue));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(locatorValue));
                    break;
                case "NA":
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type "+locatorType);
            }
        return element;
    }
}
