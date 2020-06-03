package com.Amazon.testcases;

import com.Amazon.pages.BaseClass;
import com.Amazon.pages.LoginPage;
import com.Amazon.utility.BrowserFactory;
import com.Amazon.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestapp extends BaseClass {



    @Test(priority = 1)
    public void loginPageTitleTest(){
        LoginPage loginPage= new LoginPage(driver);
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
    public void loginApp() {

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.longinToHomePage(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));

        Helper.captureScreenshot(driver);
    }
}
