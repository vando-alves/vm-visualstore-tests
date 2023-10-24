package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TelaFornecedor  extends BaseTela{
	
	@Override
	public TelaFornecedor LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaFornecedor CadastarFornecedor(String fornecedor) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
	    webdriver.webDriver().findElement(By.id("e0_6i")).click();
	    webdriver.webDriver().findElement(By.id("e0_8i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(fornecedor);
		webdriver.webDriver().findElement(By.name("txtRazaoSoc")).sendKeys("AMBEV SELENIUN");
		webdriver.webDriver().findElement(By.name("txtNomeFant")).sendKeys("AMBEV SELENIUN");
		webdriver.webDriver().findElement(By.name("txtEndereco")).sendKeys("R GETULIO VARGAS");
		webdriver.webDriver().findElement(By.name("txtEstado")).sendKeys("SP");
		webdriver.webDriver().findElement(By.name("txtCidade")).sendKeys("BARUERI");
		webdriver.webDriver().findElement(By.name("txtBairro")).sendKeys("JARDIM BELVAL");
		webdriver.webDriver().findElement(By.name("txtcep")).sendKeys("06420-190");
		webdriver.webDriver().findElement(By.name("txtCxaPostal")).clear();
		webdriver.webDriver().findElement(By.name("txtCxaPostal")).sendKeys("0");
		webdriver.webDriver().findElement(By.name("txtFone")).sendKeys("11968315270");
		webdriver.webDriver().findElement(By.name("cmbFrete")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbFrete"))).selectByVisibleText("C - CIF");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		String reposta =webdriver.webDriver().findElement(By.xpath("/html/body/div/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td")).getText();
		Assert.assertEquals(reposta, "Os dados foram salvos com sucesso");
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		return this;
	}
	
}
