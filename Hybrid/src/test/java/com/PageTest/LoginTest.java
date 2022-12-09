package com.PageTest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.LoginPage;


public class LoginTest extends BaseClass {

	LoginPage lp=null;
	@BeforeSuite
	public void setup() throws Exception{
		initialization()  ;
		lp= new LoginPage(driver);
	}
	@Test
	public void test01(){
		lp.LoginToApplication("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void test02(){
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard1");
	}
	@Test
	public void test03(){
		throw new SkipException("TestCase skippes");
	}
}
