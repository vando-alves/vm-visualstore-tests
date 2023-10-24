package br.com.visualmix.visualstore.telas;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.springframework.stereotype.Component;

@Component
public class TelaComponente extends BaseTela {

	@Override
	public TelaComponente LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaComponente CadastarComponentePDV(String loja,String componente) {

		System.out.println(componente);
		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_28i")).click();
		webdriver.webDriver().findElement(By.id("e0_29i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtLoja")).clear();
		webdriver.webDriver().findElement(By.name("txtLoja")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("txtCodigo")).clear();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(componente);
		webdriver.webDriver().findElement(By.name("txtLocalizao")).sendKeys("PDV REGRESAO");
		webdriver.webDriver().findElement(By.name("cmbModelo")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbModelo"))).selectByVisibleText("0-NÃO INFORMADO");
		webdriver.webDriver().findElement(By.name("cbxNFCe")).click();
		webdriver.webDriver().findElement(By.name("cbxParametros")).click();
		webdriver.webDriver().findElement(By.name("cbxProdutos")).click();
		super.PrintarEvidencia("TelaComponente","Componente_PDV_Preenchido.png");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		super.PrintarEvidencia("TelaComponente","Componente_PDV_Salvo.png");
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}

	public TelaComponente CadastarComponenteTotem(String loja,String componente) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_28i")).click();
		webdriver.webDriver().findElement(By.id("e0_29i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtLoja")).clear();
		webdriver.webDriver().findElement(By.name("txtLoja")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("txtCodigo")).click();
		webdriver.webDriver().findElement(By.name("txtCodigo")).clear();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(componente);
		webdriver.webDriver().findElement(By.name("cmbTipo")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipo"))).selectByVisibleText("Totem");
		webdriver.webDriver().findElement(By.name("txtLocalizao")).sendKeys("totem regresao");
		super.PrintarEvidencia("TelaComponente","Componente_Totem_Preenchido.png");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		super.PrintarEvidencia("TelaComponente","Componente_Totem_Salvo.png");
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}
	
	public TelaComponente CadastarComponenteGateway(String loja,String componente) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_27i")).click();
		webdriver.webDriver().findElement(By.id("e0_28i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtLoja")).clear();
		webdriver.webDriver().findElement(By.name("txtLoja")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("txtCodigo")).clear();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(componente);
		webdriver.webDriver().findElement(By.name("cmbTipo")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipo"))).selectByVisibleText("Gateway");
		webdriver.webDriver().findElement(By.name("txtLocalizao")).clear();
		webdriver.webDriver().findElement(By.name("txtLocalizao")).sendKeys("gataway regresao");
		super.PrintarEvidencia("TelaComponente","Componente_Gateway_Preenchido.png");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		super.PrintarEvidencia("TelaComponente","Componente_Gateway_Salvo.png");
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}

}
