package com.Amazon.pages;

import com.Amazon.utility.BrowserFactory;
import com.Amazon.utility.ConfigDataProvider;
import com.Amazon.utility.ExcelDataProvider;
import com.Amazon.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;



    @BeforeSuite
    public void setUpSuite(){
        excel=new ExcelDataProvider();
        config= new ConfigDataProvider();
    }
    @BeforeClass
    public  void setUp(){
        driver= BrowserFactory.startApp(driver,config.getBrowser(),config.getStagingURL());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);

    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            Helper.captureScreenshot(driver);
        }
    }


}
