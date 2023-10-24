package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TelaCasadinha extends BaseTela {
	
	@Override
	public TelaCasadinha LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaCasadinha CadastarCasadinha(String casadinha,String loja,String produto) {
		webdriver.webDriver().findElement(By.id("e0_5i")).click();
	    webdriver.webDriver().findElement(By.id("e0_46i")).click();
	    webdriver.webDriver().findElement(By.id("e0_47i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("Casadinha regresao seleniun " + casadinha);
		webdriver.webDriver().findElement(By.name("txtCuponagem")).sendKeys("0");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		webdriver.webDriver().findElement(By.id("lnktabtabTela1")).click();
		webdriver.webDriver().findElement(By.name("pesProdutoOrigem0000000000")).sendKeys(produto);
		webdriver.webDriver().findElement(By.name("pesProdutoOrigem0000000000")).sendKeys(Keys.TAB);
		webdriver.webDriver().findElement(By.name("cmbEmabalagemOrigem1")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbEmabalagemOrigem1"))).selectByVisibleText("1 - UND/0000");
		webdriver.webDriver().findElement(By.name("quantidadeOrigem2")).clear();
		webdriver.webDriver().findElement(By.name("quantidadeOrigem2")).click();
		webdriver.webDriver().findElement(By.name("quantidadeOrigem2")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("btnAdd6")).click();
		webdriver.webDriver().findElement(By.name("btnSalvarOrigem")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();
		webdriver.webDriver().findElement(By.name("cmbTipoDescontoPromovido")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoDescontoPromovido"))).selectByVisibleText("Valor de desconto");
		webdriver.webDriver().findElement(By.name("txtValorPromovido")).click();
		webdriver.webDriver().findElement(By.name("txtValorPromovido")).clear();
		webdriver.webDriver().findElement(By.name("txtValorPromovido")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("txtQuantidadePromovido")).click();
		webdriver.webDriver().findElement(By.name("txtQuantidadePromovido")).clear();
		webdriver.webDriver().findElement(By.name("txtQuantidadePromovido")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("pesProduto0000000000")).sendKeys(produto);
		webdriver.webDriver().findElement(By.name("pesProduto0000000000")).sendKeys(Keys.TAB);
		webdriver.webDriver().findElement(By.name("cmbEmbalegmPromovido1")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbEmbalegmPromovido1"))).selectByVisibleText("1 - UND/0000");
		webdriver.webDriver().findElement(By.name("cmbTipoDescontoProvido2")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoDescontoProvido2"))).selectByVisibleText("Valor de desconto");

		webdriver.webDriver().findElement(By.name("txtValorPromovido3")).click();

		webdriver.webDriver().findElement(By.name("txtValorPromovido3")).clear();
		webdriver.webDriver().findElement(By.name("txtValorPromovido3")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("btnAdd5")).click();
		webdriver.webDriver().findElement(By.name("btnSalvarPromovido")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		
		webdriver.webDriver().findElement(By.id("lnktabtabTela3")).click();
		webdriver.webDriver().findElement(By.name("txtCodigoBin")).click();
		webdriver.webDriver().findElement(By.name("txtCodigoBin")).clear();
		webdriver.webDriver().findElement(By.name("txtCodigoBin")).sendKeys("1234");
		webdriver.webDriver().findElement(By.xpath("//div[@id='tabtabTela3']/table/tbody/tr[6]/td/input")).click();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		webdriver.webDriver().findElement(By.id("lnktabtabTela7")).click();
		webdriver.webDriver().findElement(By.name("dtgLojas_header")).click();
		webdriver.webDriver().findElement(By.xpath("//div[@id='tabtabTela7']/table/tbody/tr[4]/td/input")).click();
		webdriver.webDriver().switchTo().alert().accept();

		String reposta =webdriver.webDriver().findElement(By.xpath("/html/body/div/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td")).getText();
		Assert.assertTrue(reposta.contains("salvos com sucesso"));
		
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}
	

}
