package com.Amazon.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static void captureScreenshot(WebDriver driver){
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileHandler.copy(src,new File("./Screenshots/"+getCurrentDateTime()+".png"));
            System.out.println("Screnshot captured");
        }catch (IOException e){
            System.out.println("Unable to capture screnshot " + e.getMessage());
            }
    }


    public static String getCurrentDateTime(){

        DateFormat customformat=new SimpleDateFormat("MM-dd-yyyy--HH:mm:ss");
        Date currentDate=new Date();
        return  customformat.format(currentDate);
    }
}
