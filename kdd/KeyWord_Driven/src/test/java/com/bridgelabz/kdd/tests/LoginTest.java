package com.bridgelabz.kdd.tests;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bridgelabz.kdd.base.Base;
import com.bridgelabz.kdd.keywordengine.KeyEngine;

public class LoginTest extends Base{
	
	KeyEngine engine;
		
	public LoginTest() throws IOException {
		property = Base.init_property();		
	}
	
	@BeforeMethod
	public void setUp() {
		 engine = new KeyEngine();
	}
	
	@Test
	public void loginTest() {
		
		engine.startExecution(property.getProperty("loginSheet"));

		 
	}
	
//	@Test(priority = 1)
//	public void postTest() {
//		engine.startExecution(property.getProperty("postSheet"));
//	}
}
