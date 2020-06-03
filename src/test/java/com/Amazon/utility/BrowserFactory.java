package com.Amazon.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

     public static WebDriver startApp(WebDriver driver,String broserName,String appURL){


         if(broserName.equals("Chrome")){
             WebDriverManager.chromedriver().setup();
              driver= new ChromeDriver();
         }
         else if(broserName.equals("Firefox")){
             WebDriverManager.firefoxdriver().setup();
              driver= new FirefoxDriver();
         }
         else if(broserName.equals("IE")){
             WebDriverManager.iedriver().setup();
              driver= new InternetExplorerDriver();
         }

         driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get(appURL);
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


         return driver;
     }


     public static void quitBrowser(WebDriver driver){

         driver.quit();
     }
}
