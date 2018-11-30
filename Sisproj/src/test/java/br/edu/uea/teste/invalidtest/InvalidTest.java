package br.edu.uea.teste.invalidtest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidTest {
WebDriver driver;
	
	private static final String URL = "http://sisproj1.uea.edu.br/index.php?dest=roston";
	private static final int TIMEOUT = 25; // seconds
	
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	private static final String EXPECTED_MESSAGE = "Erro na autenticação.";
	private static final String EXPECTED_MESSAGE_LOGIN = "Preencha o campo LOGIN!";
	private static final String EXPECTED_MESSAGE_PASSWORD = "Preencha o campo SENHA!";
	
	@Before
	public void inicia() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	
	@After
    public void tearDownTest(){
		driver.close();
    }
	
	@Test
	public void testLoginGoodPasswordNoGood() {
		driver.findElement(By.id("user")).sendKeys(USERNAME);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("wrongpassword");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE);
	}
		
	@Test
	public void testLoginNoGoodPasswordGood() {
		driver.findElement(By.id("user")).sendKeys("err.eng");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys(PASSWORD);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE);
	}
	
	@Test
	public void testLoginNoGoodPasswordNoGood() {
		driver.findElement(By.id("user")).sendKeys("err.eng");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE);
	}
	
	//
	
	@Test
	public void testLoginGoodPasswordBlank() {
		driver.findElement(By.id("user")).sendKeys(USERNAME);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE_PASSWORD);
	}
	
	@Test
	public void testLoginNoGoodPasswordBlank() {
		driver.findElement(By.id("user")).sendKeys("939.eng");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE_PASSWORD);
	}
	
	@Test
	public void testLoginBlankPasswordGood() {
		driver.findElement(By.id("user")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys(PASSWORD);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE_LOGIN);
	}
	
	@Test
	public void testLoginBlankPasswordNoGood() {
		driver.findElement(By.id("user")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE_LOGIN);
	}
	
	@Test
	public void testLoginBlankPasswordBlank() {
		driver.findElement(By.id("user")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
	
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		
        assertEquals(alert.getText(), EXPECTED_MESSAGE_LOGIN);
	}
}
