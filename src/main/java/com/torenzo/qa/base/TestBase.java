package com.torenzo.qa.base;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.torenzo.qa.util.TestUtil;

public class TestBase {
       
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream Fis = new FileInputStream("E://Appium1//TorenzoAppiumTest//src//main//java//com//torenzo//qa//config//config.properties");
		    prop.load(Fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
	 }
	}	
	public static void initialization(){
			String browserName = prop.getProperty("Browser");
			
				if(browserName.equals("Chrome")){
					System.out.println("launch chrome brouser");
					System.setProperty("webdriver.chrome.driver", "E:\\AppiumFile\\chromedriver.exe");	
					driver = new ChromeDriver(); 
				}
				else if(browserName.equals("FF")){
					System.setProperty("webdriver.gecko.driver", "E:\\AppiumFile\\geckodriver.exe");	
					driver = new FirefoxDriver(); 
				}
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				
	}
	
	}
	
	
	
	
	
	

