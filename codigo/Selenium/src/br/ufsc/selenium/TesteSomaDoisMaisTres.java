package br.ufsc.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSomaDoisMaisTres {

	private WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
		this.driver = new FirefoxDriver();
		this.driver.navigate().to("http://www.calculatoria.com/");
	}

	@Test
	public void testarIniciar() throws Exception {
		assertEquals("0", this.driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void somaDoisETres() throws Exception {
		this.driver.findElement(By.linkText("2")).click();
		this.driver.findElement(By.linkText("+")).click();
		this.driver.findElement(By.linkText("3")).click();
		this.driver.findElement(By.linkText("=")).click();
		assertEquals("5", this.driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void multiplicaVintePorQuatro() throws Exception {
		this.driver.findElement(By.linkText("2")).click();
		this.driver.findElement(By.linkText("0")).click();
		this.driver.findElement(By.linkText("×")).click();
		this.driver.findElement(By.linkText("4")).click();
		this.driver.findElement(By.linkText("=")).click();
		assertEquals("80", this.driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void divideCemPorTres() throws Exception {
		this.driver.findElement(By.linkText("1")).click();
		this.driver.findElement(By.linkText("0")).click();
		this.driver.findElement(By.linkText("0")).click();
		this.driver.findElement(By.linkText("÷")).click();
		this.driver.findElement(By.linkText("3")).click();
		this.driver.findElement(By.linkText("=")).click();
		assertEquals("33.333", this.driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@Test
	public void divideCincoPorDoisESomaQuatro() throws Exception {
		this.driver.findElement(By.linkText("5")).click();
		this.driver.findElement(By.linkText("÷")).click();
		this.driver.findElement(By.linkText("2")).click();
		this.driver.findElement(By.linkText("=")).click();
		this.driver.findElement(By.cssSelector("span.bdel")).click();
		this.driver.findElement(By.cssSelector("span.bdel")).click();
		this.driver.findElement(By.linkText("+")).click();
		this.driver.findElement(By.linkText("4")).click();
		this.driver.findElement(By.linkText("=")).click();
		assertEquals("6", this.driver.findElement(By.name("exprdisplay")).getAttribute("value"));
	}

	@After
	public void fecharNavegador() {
		this.driver.quit();
	}
}
