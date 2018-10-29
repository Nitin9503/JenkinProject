package com.ItemAddmaster;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdditemMaster {
	

	public static void main(String[] args) throws InterruptedException {
		String OSname =System.getProperty("os.name");
				System.out.println("name" +OSname);
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\AppiumFile\\chromedriver.exe");	
		WebDriver driver;
		driver = new ChromeDriver(); 
		driver.get("http://192.168.1.140:8080/TorenzoPOS/item.jsp");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.findElement(By.id("usernm")).sendKeys("torenzocafe");
		driver.findElement(By.id("pwd")).sendKeys("1234");
		driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath(".//*[@id='sidebar']/nav/ul/li[6]/a/span")).click();
		driver.get("http://192.168.1.140:8080/TorenzoPOS/item.jsp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		String st=driver.findElement(By.id("addNew")).getText();
	    //String st=driver.findElement(By.xpath("//input[@id='NewCategory']")).getText();
		System.out.println(st);
		//driver.findElement(By.xpath(".//*[@id='sidebar']/nav/ul/li[6]/a/span")).click();
		//driver.findElement(By.xpath("//*[@onclick='addNewCategory()']")).click();
		//driver.findElement(By.cssSelector("input[type='button'][value='+ Add a new Item']")).click();
		//driver.findElement(By.cssSelector("input[@type='button'][@value='+ Add a new Item']")).click();
		//driver.findElement(By.xpath("//input[@id='NewCategory']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='fourth']/p/button']")).click();
		
		WebElement element = driver.findElement(By.className("main-menu"));
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(driver.findElement(By.xpath(".//*[@id='itemMainGrid']/div[3]/table/tbody/tr[7]/td[3]"))).click().build().perform();
		driver.findElement(By.name("Item Number")).sendKeys("fact1");;
		driver.findElement(By.name("BarcodeNumber")).sendKeys("fact1");;
		driver.findElement(By.name("Description")).sendKeys("Panipuri");
	}

}
