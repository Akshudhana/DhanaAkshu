package com.APILinting;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Demo {

	@Test
	public void createLinting() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://acme-team-production.apiwiz.io/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Enter Username']"));
		username.sendKeys("apiwizItorix");
		
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		password.sendKeys("Apiwiz@123");
		
		WebElement logingButton=driver.findElement(By.xpath("//p[@class='text-white dfs-13px fw-500']"));
		logingButton.click();
		
		String expectedTitle="APIwiz";
		
		String actualtitle=driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualtitle);
		
		WebElement apiLinting=driver.findElement(By.xpath("(//*[name()='svg' and @class='color-text-regular'])[3]"));
		apiLinting.click();
		

		String ExpectedURL="https://acme-team-production.apiwiz.io/api-linting";
		
		String actualUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, ExpectedURL);
		
	WebElement addRulesetButton=driver.findElement(By.xpath("//div[@class='ripple-btn']/ancestor::div[@title='Add Ruleset']"));
	addRulesetButton.click();
	
	WebElement createRuleSetButton=driver.findElement(By.xpath("//input[@id='Create new ruleset']"));
	createRuleSetButton.click();
	
	
	
	String name="qa-testing";
	
	WebElement ruleSetNameTextField=driver.findElement(By.xpath("//input[@placeholder='Enter Ruleset Name']"));
	ruleSetNameTextField.sendKeys(name);
	
	WebElement ruleSetDescriptionTextField=driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
	ruleSetDescriptionTextField.sendKeys("qa-testing");
	
	WebElement ruleSetSaveButton=driver.findElement(By.xpath("//div[@class='btn-primary text-white fs-13px fw-600 cursor-pointer']"));
	
	ruleSetSaveButton.click();
	
	
	String ExpectedrulesetCreatedSuccesfulMsg="Ruleset created successfully";
	
	WebElement rulesetCreatedSuccesfulMsg=driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success Toastify__toast--close-on-click']"));
	String ActualrulesetCreatedSuccesfulMsg=rulesetCreatedSuccesfulMsg.getText();
	
	
	Assert.assertEquals(ActualrulesetCreatedSuccesfulMsg, ExpectedrulesetCreatedSuccesfulMsg);
	
	Thread.sleep(3000);
	
	
		 List<WebElement> AllTheRuleSetData = driver.findElements(By.xpath("//p[@class='color-text-subdued fs-12px fw-500 text-nowrap']/preceding-sibling::p"));
	
		 Boolean found=false;
			
			
		 for(WebElement w:AllTheRuleSetData) {
			String getText1=w.getText().trim();
			System.out.println(getText1);
			try {
				if(getText1.equals(name)) {

					JavascriptExecutor js=(JavascriptExecutor) driver;
					   js.executeScript("arguments[0].click()", w);
					

	                found = true;
	                break; 
					
				}
				
			} 
			
			catch (Exception e) {
				System.out.println("Element not clickable: " + e.getMessage());
			}
		}
	
	WebElement rulesButton = driver.findElement(By.xpath("//p[@class='fw-500 fs-14px color-text-heading' and text()='Rules']"));
	rulesButton.click();
	
	String ExpectedToValidatelintingText="qa-testing";
	
	WebElement ToValidatelintingText=driver.findElement(By.xpath("//p[@class='color-text-regular fs-13px fw-600 lh-16px' and text()='qa-testing']"));
	
	//System.out.println(lintingText.getText());
	
	Assert.assertEquals(ToValidatelintingText.getText(), ExpectedToValidatelintingText);
	
	Thread.sleep(3000);
	
	WebElement addRulesButton=driver.findElement(By.xpath("//p[@class='fw-600 fs-12px color-text-regular']"));
	addRulesButton.click();
	
	WebElement newRulesButton=driver.findElement(By.xpath("//p[@class='fs-12px fw-500 color-text-regular' and text()='New Rule']"));
	newRulesButton.click();
	
	WebElement nameOfRuleTextFiled=driver.findElement(By.xpath("//input[@placeholder='Name of Rule']"));
	nameOfRuleTextFiled.sendKeys("info-tittle");
	
	WebElement discriptionOfRuleTextFiled=driver.findElement(By.xpath("//textarea[@placeholder='description of Rule']"));
	discriptionOfRuleTextFiled.sendKeys("Ensure all the swaggers has tittle tags");
	

	
	WebElement objectPathTextField=driver.findElement(By.xpath("//input[@placeholder='Object path comes here']"));
	objectPathTextField.sendKeys("$.info.tittle");
	
	WebElement ruleSaveButton=driver.findElement(By.xpath("//p[text()='New Rule']/ancestor::div[@class='flex-row vt-center hz-space-between px-6px border-bottom-stroke-section-1px h-36px']/descendant::div[@class='flex-row vt-center gap-4px'][2]"));
	ruleSaveButton.click();
	
	String ExpextedRulesimportedsuccessfullyMsg="Rules imported successfully";
	
	WebElement RulesimportedsuccessfullyMsg=driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success Toastify__toast--close-on-click']"));
	String ActualRulesimportedsuccessfullyMsg=RulesimportedsuccessfullyMsg.getText();
	
	Assert.assertEquals(ActualRulesimportedsuccessfullyMsg,ExpextedRulesimportedsuccessfullyMsg);
			
			
	WebElement associationLink=driver.findElement(By.xpath("//div[@class='cursor-pointer flex-center bg-surface-ground']"));
	associationLink.click();
	
	WebElement uberApiCheckBox=driver.findElement(By.xpath("//div[@class='color-text-regular fs-13px fw-500']/ancestor::div[@class='flex-row vt-center cursor-pointer gap-8px pl-16px m-8px hover-surface-bg-underground']/descendant::div[@class='cursor-pointer']"));
	uberApiCheckBox.click();
	
	WebElement addSwaggerSaveButton=driver.findElement(By.xpath("//p[text()='Add Swaggers']/ancestor::div[@class='h-36px flex-row vt-center hz-space-between px-8px border-bottom-stroke-section-1px']/descendant::div[@data-tooltip-place='top'][2]"));
	addSwaggerSaveButton.click();
	
	Thread.sleep(3000);
	
	String ExpectedSwaggerisassignedsuccessfully="Swagger is assigned successfully";
	
	WebElement SwaggerisassignedsuccessfullyMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success Toastify__toast--close-on-click']"));
	String ActualSwaggerisassignedsuccessfully=SwaggerisassignedsuccessfullyMsg.getText();
	System.out.println("swagger--->"+" "+ActualSwaggerisassignedsuccessfully);
	Assert.assertEquals(ActualSwaggerisassignedsuccessfully, ExpectedSwaggerisassignedsuccessfully);
	
	
	
	WebElement runSwaggerButton = driver.findElement(By.xpath("(//*[name()='svg' and @class='color-text-subtle'])[7]"));
	runSwaggerButton.click();
	
	Thread.sleep(3000);
	
	WebElement uberApiCheckBoxInRunSwaggerButton = driver.findElement(By.xpath("//div[@class='color-text-regular fs-13px fw-500']/ancestor::div[@class='flex-row vt-center cursor-pointer gap-8px pl-16px m-8px hover-surface-bg-underground']/descendant::div[@class='cursor-pointer']"));
	uberApiCheckBoxInRunSwaggerButton.click();
	
	WebElement ExecuteButtonInrunSwagger = driver.findElement(By.xpath("//div[@class='flex-row vt-center border-stroke-section-1px bg-surface-l1 gap-4px br-6px px-8px py-5px cursor-pointer']"));
	ExecuteButtonInrunSwagger.click();
	
	String ExpectedlintingStratedSuccesMsg="Linting started successfully";
	
	WebElement lintingStratedSuccesMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success Toastify__toast--close-on-click']"));
	String ActuallintingStratedSuccesMsg=lintingStratedSuccesMsg.getText();
	
	Assert.assertEquals(ActuallintingStratedSuccesMsg, ExpectedlintingStratedSuccesMsg);
	}
}
