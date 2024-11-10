package com.qacapital2.test;

import com.qacapital2.base.Base;
import com.qacapital2.pages.LoginPage;
import com.qacapital2.util.CustomListener;
import com.qacapital2.util.ExtentReportListener;
import com.qacapital2.util.ReadExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners(ExtentReportListener.class)
public class LoginTest extends Base {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeTest
    public void login(){

        logger.info("For information");
        logger.debug("Initialized driver");
        logger.error("Error Generated");
        logger.info("For information");
        initialization();
    }


    @DataProvider(name = "login")
    public Object[][] loginData() throws IOException {
        Object[][] data = ReadExcel.getHardData();
        return data;
    }

    /**
     * @purpose To test login functionality
     * @param username
     * @param password
     */
    @Test(dataProvider = "login")
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
