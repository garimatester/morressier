package com.morressier.selenium.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.morressier.selenium.base.BaseSeleniumSetup;
import com.morressier.selenium.base.SeleniumToolException;
import com.morressier.selenium.pages.LogInPageWidget;
import com.morressier.selenium.pages.QAAccountPage;



//@Listeners(CustomListener.class) 

public class LogInTest extends BaseSeleniumSetup{
    
   
	private LogInPageWidget loginpage;
	private QAAccountPage accountPage;

@Override
	@BeforeClass
    @Parameters({"testdatafile"})
   	public void setUp(@Optional("src/test/resources/configurableData.json")String testDataFile) throws  IOException, SeleniumToolException {
    	
    	super.setUp(testDataFile);
    	//driver=super.driver;
    	//wait = super.wait;
    }

    
    @Test(priority=0)
    public void logInTest() throws InterruptedException {
    	log.info("login test");
        loginpage = getLoginPage(driver,wait);
        loginpage.doLogin();
        accountPage=new QAAccountPage(driver, wait);
        accountPage.validateElements(testData);
       
    	
       
        
    }
    
    
    @Test(priority=1)
    public void logOutTest() throws InterruptedException {
    	log.info("logout test");
    	loginpage.doLogOut();
    	Assert.assertEquals(driver.getCurrentUrl(), "https://www.morressier.com/");
        
       
        
    }
    
    

   
    

    
    
}
