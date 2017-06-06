package br.ufsc.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesCalculadora {

	private static WebDriver driver;

	@BeforeClass
	public static void before() {
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.calculatoria.com/");
	}

	@Test
	public void somaDoisETres() throws Exception {
		driver.findElement(By.linkText("C")).click();
		driver.findElement(By.linkText("2")).click();
		driver.findElement(By.linkText("+")).click();
		driver.findElement(By.linkText("3")).click();
		driver.findElement(By.linkText("=")).click();
		assertEquals("5", driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void multiplicaVintePorQuatro() throws Exception {
		driver.findElement(By.linkText("C")).click();
		driver.findElement(By.linkText("2")).click();
		driver.findElement(By.linkText("0")).click();
		driver.findElement(By.linkText("×")).click();
		driver.findElement(By.linkText("4")).click();
		driver.findElement(By.linkText("=")).click();
		assertEquals("80", driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void divideCemPorTres() throws Exception {
		driver.findElement(By.linkText("C")).click();
		driver.findElement(By.linkText("1")).click();
		driver.findElement(By.linkText("0")).click();
		driver.findElement(By.linkText("0")).click();
		driver.findElement(By.linkText("÷")).click();
		driver.findElement(By.linkText("3")).click();
		driver.findElement(By.linkText("=")).click();
		assertEquals("33.333", driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void divideCincoPorDoisESomaQuatro() throws Exception {
		driver.findElement(By.linkText("C")).click();
		driver.findElement(By.linkText("5")).click();
		driver.findElement(By.linkText("÷")).click();
		driver.findElement(By.linkText("2")).click();
		driver.findElement(By.linkText("=")).click();
		driver.findElement(By.cssSelector("span.bdel")).click();
		driver.findElement(By.cssSelector("span.bdel")).click();
		driver.findElement(By.linkText("+")).click();
		driver.findElement(By.linkText("4")).click();
		driver.findElement(By.linkText("=")).click();
		assertEquals("6", driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@AfterClass
	public static void fecharNavegador() {
		driver.quit();
	}
}
