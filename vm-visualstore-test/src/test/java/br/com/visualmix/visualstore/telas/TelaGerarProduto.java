package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import lombok.Getter;


@Getter
@Component
public class TelaGerarProduto extends BaseTela{

	private String numeroProcesso;
	
	@Override
	public TelaGerarProduto LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaGerarProduto GerarProduto() {

		
		webdriver.webDriver().findElement(By.id("e0_151i")).click();
		webdriver.webDriver().findElement(By.id("e0_153i")).click();
		 webdriver.webDriver().switchTo().frame(0);
		 webdriver.webDriver().findElement(By.name("cmbOpcao")).click();
		 new Select(webdriver.webDriver().findElement(By.name("cmbOpcao"))).selectByVisibleText("Gerar Produtos para o Dia Atual");
		 webdriver.webDriver().findElement(By.name("chk11000")).click();
		 webdriver.webDriver().findElement(By.name("btnGerar")).click();
		
		return this;
	}

}
