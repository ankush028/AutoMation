package com.qacapital.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static WebDriver driver;
    public static void initialization(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }
    public static void main(String args[]){
        initialization();
    }
}
