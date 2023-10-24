package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class TelaCuponagem extends BaseTela{

	@Override
	public TelaCuponagem LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaCuponagem CadastarCuponagem(String cuponagem,String loja) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
		webdriver.webDriver().findElement(By.id("e0_46i")).click();
		webdriver.webDriver().findElement(By.id("e0_52i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(cuponagem);
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("cuponagem regresao");
		webdriver.webDriver().findElement(By.name("txtPdv")).sendKeys("0");
		webdriver.webDriver().findElement(By.id("lnktabtabTela1")).click();
		webdriver.webDriver().findElement(By.name("txtMinimo")).sendKeys("1");
		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();
		webdriver.webDriver().findElement(By.name("txtQtdeMax")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("txtPercDesc")).sendKeys("2");
		webdriver.webDriver().findElement(By.name("txtVlrDesc")).sendKeys("3");
		webdriver.webDriver().findElement(By.name("txtVlrMax")).sendKeys("4");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		String reposta =webdriver.webDriver().findElement(By.xpath("/html/body/div/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td")).getText();
		Assert.assertTrue(reposta.contains("Salvo com sucesso"));
		
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		
		webdriver.webDriver().findElement(By.id("lnktabtabTela3")).click();
		webdriver.webDriver().findElement(By.name("txtLojas")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("btnSalvarLojas")).click();
		
		return this;
	}
	
	
}
