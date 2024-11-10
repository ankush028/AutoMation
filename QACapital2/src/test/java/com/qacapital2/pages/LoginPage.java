package com.qacapital2.pages;

import com.qacapital2.base.Base;
import org.openqa.selenium.By;

public class LoginPage extends Base {

    public void login(String username, String password){
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
