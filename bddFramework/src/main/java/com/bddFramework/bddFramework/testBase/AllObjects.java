package com.bddFramework.bddFramework.testBase;

import com.bddFramework.bddFramework.pageObjects.HomePage;
import com.bddFramework.bddFramework.pageObjects.LoginPage;


public interface AllObjects {

	static LoginPage loginPage = new LoginPage(TestBase.driver);
	static HomePage homePage = new HomePage(TestBase.driver);
}
