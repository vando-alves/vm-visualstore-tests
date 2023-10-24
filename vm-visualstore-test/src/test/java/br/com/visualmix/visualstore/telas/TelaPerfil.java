package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class TelaPerfil  extends BaseTela{
	
	@Override
	public TelaPerfil LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}
	
	public TelaPerfil CadastarPerfil() {

		webdriver.webDriver().findElement(By.id("e0_0i")).click();
	    webdriver.webDriver().findElement(By.id("e0_1o")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("Regressao selenium");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		
		String reposta =webdriver.webDriver().findElement(By.xpath("/html/body/div/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td")).getText();
		Assert.assertTrue(reposta.contains("com sucesso"));
		
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		webdriver.webDriver().findElement(By.id("lnktabtabTela1")).click();
		webdriver.webDriver().findElement(By.name("dtgPermissao_header")).click();
		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();

		webdriver.webDriver().findElement(By.xpath("//div[@id='tabtabTela2']/table/tbody/tr/td/div/table/tbody/tr/td")).click();
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();


		return this;
	}
	
	

}
