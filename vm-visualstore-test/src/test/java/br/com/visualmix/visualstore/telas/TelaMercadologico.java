package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import br.com.visualmix.visualstore.dao.TestesDAO;

@Component
public class TelaMercadologico extends BaseTela{
	
	@Override
	public TelaMercadologico LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	
	public TelaMercadologico CadastarMercadologico(String mercadologico) {

		
		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_6i")).click();
	    webdriver.webDriver().findElement(By.id("e0_9i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("cmbNiveis")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbNiveis"))).selectByVisibleText("01");
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("MERCADOLOGICO REGRESSÃO SELENIUN");
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(mercadologico);
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		return this;
	}

}
