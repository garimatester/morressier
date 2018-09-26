package com.morressier.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.morressier.data.TestDataGson;
import com.morressier.selenium.base.BaseSeleniumWebPageAction;




public class QAAccountPage extends BaseSeleniumWebPageAction{
	
	
	private By accountName=By.xpath("//span[contains(text(),'QA Account')]");
	private By settings=By.xpath("//a[contains(text(),'Settings')]");

	private By search_discovery=By.id("HINT_SEARCH");
	private By menuLocator=By.xpath("//div[@class='style__AvatarContent-sc-1e2w3yk-2 hhWOPP']");

	
	private By searchResultHeading=By.xpath("//h2[@class='Headline-s1d4gxwj-0 hmgodJ Text__InnerTextComponent-ccn3q8-0 ymsli']");

	private By straccountInfo=By.cssSelector("h2");
	protected  WebDriverWait wait;
	protected WebDriver driver;

	public QAAccountPage(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		this.wait = wait;
	}
	
	
	
	
	

	/**
	 * Close browser.
	 * @param testData 
	 * @param registrationData 
	 * @throws InterruptedException 
	 *
	 * @throws Exception the exception
	 */
	/*protected void closeBrowser() throws Exception {
		log.info("Close browser");
		driver.close();
	}

*/
	
	
	public void validateElements(TestDataGson testData) throws InterruptedException {
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(accountName));
        Assert.assertEquals(heading.getText(), "QA Account");
      
	}
	
	
 public void validateElementsSettings(TestDataGson testData) throws InterruptedException {
	 Thread.sleep(5000);
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(accountName));
		
        Assert.assertEquals(heading.getText(), "QA Account");
        Assert.assertEquals(driver.findElement(accountName).getText(), "QA Account");
        Assert.assertTrue(driver.findElements(straccountInfo).get(0).getText().contains("Account details"));
        Assert.assertTrue(driver.findElements(straccountInfo).get(1).getText().contains("Notification settings"));

       
	}
 
 
 
 public void validateSearch(TestDataGson testData) throws InterruptedException {
	 Thread.sleep(5000);
		
		WebElement searchbox = driver.findElement(search_discovery);
		searchbox.sendKeys("medicine");
		searchbox.sendKeys(Keys.RETURN);
	    _wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultHeading));
	    Assert.assertEquals(driver.findElement(searchResultHeading).isDisplayed(), true);
	    
	   //scrollToBottom();
       
	}
 
 
 
 public void navSettings() throws InterruptedException {
		
	    _wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
	    click(menuLocator);
	    
	    log.info("clicked avatar icon");
	    
	    //_wait.until(ExpectedConditions.visibilityOfElementLocated(settings));

	    
	    WebElement elementEmail=driver.findElement(settings);

	    
	    click(settings);
	    
	    log.info("clicked settings icon");

	    

	   
	}






public void markSearch(TestDataGson testData) throws InterruptedException {
	 _wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='style__Info-sc-1668q89-2 jpMRDh']")));
	    
	   WebElement firstArticle=driver.findElements(By.xpath("//div[@class='style__Info-sc-1668q89-2 jpMRDh']")).get(0);

	 firstArticle.click();
	    
	   
	 log.info("clicked search result");
	 
	List<WebElement> elements= driver.findElements(By.xpath("//button[contains(text(),'Add to Library')]"));
	
	List<WebElement> bookmarkIcon= driver.findElements(By.xpath("//button[@class='ignore-react-onclickoutside Button-s15s5s6s-0 icsnPk']"));

	
	
	if(elements.size()==0) {
		if(bookmarkIcon.size()!=0) {
			bookmarkIcon.get(0).click();
			driver.findElement(By.xpath("//h5[contains(text(),'My collection')]")).click();
			
		}
	}
		
	
	    
	    _wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to Library')]")));

	    
	   WebElement bookMark=driver.findElements(By.xpath("//button[contains(text(),'Add to Library')]")).get(0);

	   
	   bookMark.click();
	    
	   

}


		
		
	
	
	

}












