package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TelaAtacado  extends BaseTela{

	
	@Override
	public TelaAtacado LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaAtacado CadastarAtacado(String produto) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
	    webdriver.webDriver().findElement(By.id("e0_46i")).click();
	    webdriver.webDriver().findElement(By.id("e0_53i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtProdutoId")).sendKeys(produto);
		webdriver.webDriver().findElement(By.name("cmbSeqEmbalagem")).click();
		webdriver.webDriver().findElement(By.name("cmbTipo")).click();
	    Select select1 = new Select(webdriver.webDriver().findElement(By.name("cmbTipo")));
		select1.selectByIndex(1);
		//arrummar  aquuidsnfldksnfldsk~çl
		//new Select(webdriver.webDriver().findElement(By.name("cmbTipo"))).selectByVisibleText(data.getTipoVendas());
		webdriver.webDriver().findElement(By.name("txtQtdeMaxima")).clear();
		webdriver.webDriver().findElement(By.name("txtQtdeMaxima")).sendKeys("10");
		webdriver.webDriver().findElement(By.name("txtQtd1")).clear();
		webdriver.webDriver().findElement(By.name("txtQtd1")).sendKeys("2");
		webdriver.webDriver().findElement(By.name("cmbTipoDesconto1")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoDesconto1"))).selectByVisibleText("Preço de Venda");
		
		webdriver.webDriver().findElement(By.name("txtValor1")).clear();
		webdriver.webDriver().findElement(By.name("txtValor1")).sendKeys("3,50");
		webdriver.webDriver().findElement(By.name("txtQtd2")).clear();
		webdriver.webDriver().findElement(By.name("txtQtd2")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("cmbTipoDesconto2")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoDesconto2"))).selectByVisibleText("Percentual Desconto");
		webdriver.webDriver().findElement(By.name("txtValor2")).clear();
		webdriver.webDriver().findElement(By.name("txtValor2")).sendKeys("3,00");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		
		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();
		webdriver.webDriver().findElement(By.name("dtgLojas_header")).click();
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		
		 String reposta = webdriver.webDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cadastro de Atacado'])[1]/following::td[4]")).getText();
		 Assert.assertTrue(reposta.contains("com sucesso"));
		
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}
	
}
