package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.util.EventListener;


public class TestBase 
{
	public FileInputStream file;
	public static Properties p;
	public static WebDriver driver;
	public static EventListener el;
	public static EventFiringWebDriver efw;
	
	
	public TestBase() {
		
		
		 p = new Properties();
		
		try {
			
			 file= new FileInputStream("./src/main/java/com/config/Props");
			
		
		}
		catch(FileNotFoundException e){
			
			e.printStackTrace();
			
		}
		try {
			
			p.load(file);
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void Setup() {
		
		
		String browsername = p.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver.exe");
		 driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver.exe");
	       driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\geckodriver.exe");
			 driver = new EdgeDriver();
		}
		el= new EventListener();
		efw= new EventFiringWebDriver(driver);
		efw.register(el);
		driver= efw;
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
		
	
	
	
}

