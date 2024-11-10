package com.qacapital.kdd;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase {

    @Test
    public void loginTest() throws IOException {
        String filePath = "/home/ankush/Desktop/LogInTest.xlsx";
        KeyEngine keyEngine = new KeyEngine();
        keyEngine.executeTest(filePath);
    }
}
