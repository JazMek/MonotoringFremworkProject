package com.Amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver ldriver) {

            this.driver=ldriver;
        }


    @FindBy(name="username")
    WebElement userName;
    @FindBy(xpath="//*[@id=\"loginForm\"]/div/input[2]")
    WebElement passWord;
    @FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
    WebElement loginBut;


    public void longinToHomePage(String UserName,String PassWord) {

        userName.sendKeys(UserName);

        passWord.sendKeys(PassWord);

        loginBut.click();

    }
    public static final String webElementlogo="//img[contains(@class,'img-responsive')]";
    @FindBy(how = How.XPATH, using = webElementlogo)
    public WebElement logo;

    public boolean validatePageLogo(){

        return logo.isDisplayed();
    }


    public String validateLoginPageTitle(){

        return driver.getTitle();
    }

}
