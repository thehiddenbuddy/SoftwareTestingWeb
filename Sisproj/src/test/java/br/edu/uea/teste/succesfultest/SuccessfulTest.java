package br.edu.uea.teste.succesfultest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuccessfulTest {
	
	
	WebDriver driver;
	
	private static final String URL = "http://sisproj1.uea.edu.br/index.php?dest=roston";
	private static final int TIMEOUT = 25; // seconds
	
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	private static final String EXPECTED_USER = "1315208157";
	private static final String EXPECTED_NAME = "Rodrigo da Costa Moraes";
	private static final String EXPECTED_EMAIL = "rcm.eng@uea.edu.br";	
	
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
	public void testaConsultaCodigoValido() {
		driver.findElement(By.id("user")).sendKeys(USERNAME);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		driver.findElement(By.id("pwd")).sendKeys(PASSWORD);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		driver.findElement(By.id("imgSbmt")).click();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);		
		
		String user = driver.findElement(By.id("usuario")).getAttribute("value");
		assertEquals(user, EXPECTED_USER);
		
		String name = driver.findElement(By.id("nome")).getAttribute("value");
		assertEquals(name, EXPECTED_NAME);
		
		String email = driver.findElement(By.id("email")).getAttribute("value");
		assertEquals(email, EXPECTED_EMAIL);
	}
}
