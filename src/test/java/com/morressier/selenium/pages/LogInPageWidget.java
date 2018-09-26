package com.morressier.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.morressier.selenium.base.BaseSeleniumWebPageAction;




public class LogInPageWidget extends BaseSeleniumWebPageAction{
	
	
	
	
	
	
	
	private By login=By.xpath("//h5[contains(text(),'Log in')]");
	
    private By email=By.xpath("//input[@name='email']");
	private By passwd=By.xpath("//input[@name='password']");
	private By SubmitLogin=By.xpath("//button[contains(text(),'Log in')]");
		
	private By logout=By.xpath("//a[contains(text(),'Log out')]");
	private By menuLocator=By.xpath("//div[@class='style__AvatarContent-sc-1e2w3yk-2 hhWOPP']");
	


	protected  WebDriverWait _wait;
	protected WebDriver driver;
	 String existingUserEmail = "task@morressier.com";
	   String existingUserPassword = "Morressier";

	    
    

	public LogInPageWidget(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}
	
	
	
	
	
	
	public void doLogin() throws InterruptedException {
		
        _wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        click(login);
        
        log.info("clicked login");
        
        _wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        
        WebElement elementEmail=driver.findElement(email);
        enterValueToInputField("email", elementEmail,existingUserEmail, false);
        
        
        _wait.until(ExpectedConditions.visibilityOfElementLocated(passwd));

        WebElement elementPassword=driver.findElement(passwd);
        enterValueToInputField("passwd", elementPassword,existingUserPassword, false);
        
        click(SubmitLogin);
        
        
     

       
	}






public void doLogOut() throws InterruptedException {
		
        _wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
        click(menuLocator);
        
        log.info("clicked avatar icon");
        
        _wait.until(ExpectedConditions.visibilityOfElementLocated(logout));

        
        driver.findElement(logout);
        
        click(logout);
        

       
	}




  
}












