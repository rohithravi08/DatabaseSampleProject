package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			//String str = System.getProperty("C://Users//rohit//eclipse-workspace//FreeCRMTest//src//main//java//com//qa//config//config.properties");
			String str = "C://Users//rohit//eclipse-workspace//FreeCRMTest//src//main//java//com//qa//config//config.properties";
			FileInputStream ip = new FileInputStream(str);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
				
	}
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C://Users//rohit//Downloads//chromedriver_win32//chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
//			else if(browserName.equals("FF")){
//				System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
//				driver = new FirefoxDriver(); 
//			}
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
