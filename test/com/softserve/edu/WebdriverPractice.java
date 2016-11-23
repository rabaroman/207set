package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebdriverPractice {
    
    WebDriver driver;
    WebElement googleLogo;
    WebElement first_Link;
    
    @BeforeClass
    public void oneTimeSetUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.findElement(By.id("gs_lc0")).sendKeys("funny picture");
        driver.findElement(By.name("btnG")).click();
        WebElement elem = driver.findElement(By.xpath(".//*[@id='rso']/div/div[1]/div/h3/a"));
        Assert.assertTrue(elem.getText().toLowerCase().contains("funny picture"));
       }     
        
    @Test(dependsOnMethods={"test1"})
    public void test2(){
        driver.findElement(By.xpath(".//*[@id='hdtb-msb']/div[2]")).click();
        List<WebElement> list =  driver.findElements(By.cssSelector("img"));
        Assert.assertTrue(list.size() >= 5);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("testScreenShot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       } 
    
    @Test(dependsOnMethods={"test2"})  
    public void test3(){ 
        driver.navigate().to("https://www.google.com");
        googleLogo = driver.findElement(By.id("hplogo"));
        Assert.assertTrue(googleLogo.isDisplayed());
    }
        
    @Test(dependsOnMethods={"test3"})
    public void test4(){ 
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", googleLogo);
        Assert.assertFalse(googleLogo.isDisplayed());
    }
      
    @Test(dependsOnMethods={"test4"})
    public void test5(){ 
        driver.findElement(By.id("gs_lc0")).sendKeys("funny kitten picture");
        driver.findElement(By.name("btnG")).click();
        first_Link = driver.findElement(By.xpath(".//*[@id='rso']/div/div[1]/div/h3/a"));
        Assert.assertTrue(first_Link.getText().toLowerCase().contains("funny kitten picture"));
    } 
    
    @Test(dependsOnMethods={"test5"})
    public void test6(){ 
        String old_Color_Link = first_Link.getCssValue("color");
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color='red'",first_Link);
        Assert.assertNotEquals(old_Color_Link, first_Link.getCssValue("color"));
    }

    @AfterClass
    public void oneTimeTearDown( ) {
        driver.close();
        
    }
   
}
