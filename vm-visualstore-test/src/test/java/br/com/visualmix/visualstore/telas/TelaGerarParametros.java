package br.com.visualmix.visualstore.telas;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class TelaGerarParametros extends BaseTela{
	
	@Override
	public TelaGerarParametros LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	
	public TelaGerarParametros GerarParametro() {

	    webdriver.webDriver().findElement(By.id("e0_151i")).click();
	    webdriver.webDriver().findElement(By.id("e0_154i")).click();
	    webdriver.webDriver().switchTo().frame(0);
	    webdriver.webDriver().findElement(By.name("chk11000")).click();
	    webdriver.webDriver().findElement(By.name("cmbConverter")).click();
	    webdriver.webDriver().switchTo().alert().accept();

		return this;
	}

}
