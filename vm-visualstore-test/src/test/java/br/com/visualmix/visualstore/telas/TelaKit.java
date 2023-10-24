package br.com.visualmix.visualstore.telas;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TelaKit extends BaseTela {

	@Override
	public TelaKit LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}
	
	public TelaKit CadastarKit(String produto,String loja) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_6i")).click();
		webdriver.webDriver().findElement(By.id("e0_10i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtCodigo")).clear();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(produto);
		webdriver.webDriver().findElement(By.name("txtLoja")).clear();
		webdriver.webDriver().findElement(By.name("txtLoja")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("txtProdutoId")).clear();
		webdriver.webDriver().findElement(By.name("txtProdutoId")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("cmbEmbalagem")).click();
		webdriver.webDriver().findElement(By.name("cmbTipoPreco")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoPreco"))).selectByVisibleText("Preço Kit");
		webdriver.webDriver().findElement(By.name("txtPrecoVenda")).clear();
		webdriver.webDriver().findElement(By.name("txtPrecoVenda")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("txtFatorVenda")).clear();
		webdriver.webDriver().findElement(By.name("txtFatorVenda")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
	
		return this;
	}
	
}
