package com.softserve.edu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
    
    private final String dataForMethod0 = "dataForMethod0";
    private final String dataForMethod1 = "dataForMethod1";
    private final String dataForMethod2 = "dataForMethod2";
    private final String dataForMethod3 = "dataForMethod3";
    private final String dataForMethod4 = "dataForMethod4";
    
    @DataProvider
    public Object[][] dataMethod0(){
        return new Object[][] {{dataForMethod0}};
    }
    
    @DataProvider
    public Object[][] dataMethod1(){
        return new Object[][] {{dataForMethod1}};
    }
    
    @DataProvider
    public Object[][] dataMethod2(){
        return new Object[][] {{dataForMethod2}};
    }
    
    @DataProvider
    public Object[][] dataMethod3(){
        return new Object[][] {{dataForMethod3}};
    }
    
    @DataProvider
    public Object[][] dataMethod4(){
        return new Object[][] {{dataForMethod4}};
    }
    
    
    @Test(invocationCount = 3, dataProvider = "dataMethod0")
    public void testMethod0(String value){
        System.out.println("This is method 0");
        System.out.println(value);
    }
    
    @Test(dependsOnMethods={"testMethod0"}, 
            invocationCount = 3,
            dataProvider = "dataMethod1")
    public void testMethod1(String value){
        System.out.println("This is method 1");
        System.out.println(value);
    }
    
    @Test(dependsOnMethods={"testMethod1"}, 
            invocationCount = 3,
            dataProvider = "dataMethod2")
    public void testMethod2(String value){
        System.out.println("This is method 2");
        System.out.println(value);
    }
    
    @Test(invocationCount = 3, dataProvider = "dataMethod3")
    public void testMethod3(String value){
        System.out.println("This is method 3");
        System.out.println(value);
    }
    
    @Test(invocationCount = 3, dataProvider = "dataMethod4")
    public void testMethod4(String value){
        System.out.println("This is method 4");
        System.out.println(value);
    }
    
}
