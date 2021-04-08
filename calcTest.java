package calculationDriver;

import java.util.regex.Pattern;

import org.junit.*;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class calcTest {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	
	@Before
	public void seUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\delve\\Desktop\\464\\Assignment7\\chromeDriver\\chromedriver");
		baseUrl = "http://webstrar100.fulton.asu.edu/";
		driver = new ChromeDriver();
		driver.manage().timeouts.implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void addTest() throws Exception
	{
		driver.get(baseUrl + "/page1/default.aspx");
		driver.findElement(By.name("number1")).clear();
		driver.findElemnent(By.name("number1")).sendkeys("2");
		driver.findElement(By.name("number2")).clear();
		driver.findElement(By.name("number2")).sendkeys("3");
		
		webElement ope = driver.findElement(By.id("add"));
		
		//the radio button is selected
		ope.click();
		
		assertEquals("5", driver.findElement(By.name("result")).getAttribute("value"));
	}
	
	@Test
	public void subtractionTest() throws exception
	{
		driver.get(baseUrl + "/page1/default.aspx");
		driver.findElement(By.name("number1")).clear();
		driver.findElemnent(By.name("number1")).sendkeys("2");
		driver.findElement(By.name("number2")).clear();
		driver.findElement(By.name("number2")).sendkeys("2");
		
		webElement ope = driver.findElement(By.id("sub"));
		
		//the radio button is selected
		ope.click();
		
		driver.findElement(By.name("calc")).click();
		assertEquals("0", driver.findElement(By.name("result")).getAttribute("value"));
	}
	
	@Test
	public void multiplicationTest() throws exception
	{
		driver.get(baseUrl + "/page1/default.aspx");
		driver.findElement(By.name("number1")).clear();
		driver.findElemnent(By.name("number1")).sendkeys("2");
		driver.findElement(By.name("number2")).clear();
		driver.findElement(By.name("number2")).sendkeys("2");
		
		webElement ope = driver.findElement(By.id("mul"));
		
		//the radio button is selected
		ope.click();
		
		driver.findElement(By.name("calc")).click();
		assertEquals("4", driver.findElement(By.name("result")).getAttribute("value"));
	}
	
	@Test
	public void divisionTest() throws exception
	{
		driver.get(baseUrl + "/page1/default.aspx");
		driver.findElement(By.name("number1")).clear();
		driver.findElemnent(By.name("number1")).sendkeys("2");
		driver.findElement(By.name("number2")).clear();
		driver.findElement(By.name("number2")).sendkeys("2");
		
		webElement ope = driver.findElement(By.id("div"));
		
		//the radio button is selected
		ope.click();
		
		driver.findElement(By.name("calc")).click();
		assertEquals("1", driver.findElement(By.name("result")).getAttribute("value"));
	}
	
	@After
	public void tearDown() throws Exception
	{
		driver.quit();
		
		String errorVerifStr = errorVerifStr.toString();
		if(!"".equals(errorVerifStr))
		{
			fail(errorVerifStr);
		}
	}
	
	private boolean alertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (noAlertException ex)
		{
			return false;
		}
	}
	
	private boolean elementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(noElementException ex)
		{
			return false;
		}
	}
	
	
	private String getText_closeAlert()
	{
		try 
		{
			Alert alert = driver.switchTo().alert();
			
			String textPresent = alert.getText();
			
			if(acceptNextAlert)
			{
				alert.accept();
			}
			else
			{
				alert.dismiss();
			}
			
			
		return textPresent;
		
		}
		finally
		{
			acceptNextAlert = true;
		}
	}

//References used: mathTeat.java, lecture of 11/17/2020 from week 11 and 12: Web application Testing
}

