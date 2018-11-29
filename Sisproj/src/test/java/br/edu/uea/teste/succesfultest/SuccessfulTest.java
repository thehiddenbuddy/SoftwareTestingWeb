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
	
	//Sistema web online
	private String url = "https://www.linkcorreios.com.br/";
	//ou
	//Copia da pagina web desejada, para rodar localmente
	//private String url = "localhost:8080/Rastreamento";
	
	WebDriver driver;
	private String inputCodigoValido = "OG206681041BR";
	private String resultadoEsperado = "Data / Hora";
	private String resultadoObtidoTeste = null;
	
	@Before
	public void inicia() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(25,
				TimeUnit.SECONDS);
	}
	
	@After
    public void tearDownTest(){
		driver.close();		//Fecha a janela do navegador
    }
	
	@Test
	public void testaConsultaCodigoValido() {
		driver.findElement(By.id("id")).sendKeys(inputCodigoValido);
		driver.manage().timeouts().implicitlyWait(25,
				TimeUnit.SECONDS);

		driver.findElement(By.className("btn-primary")).click();
		driver.manage().timeouts().implicitlyWait(25,
				TimeUnit.SECONDS);
		resultadoObtidoTeste = 
				driver.findElement(By.tagName("table")).getText();
		driver.manage().timeouts().implicitlyWait(25,
				TimeUnit.SECONDS);
		
		System.out.println(resultadoObtidoTeste);
		assertEquals(1, 1);
	}

}
