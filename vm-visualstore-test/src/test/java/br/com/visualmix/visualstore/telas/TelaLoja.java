package br.com.visualmix.visualstore.telas;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TelaLoja extends BaseTela {
	
	
	@Override
	public TelaLoja LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	public TelaLoja CadastarLoja(String loja) {

		webdriver.webDriver().findElement(By.id("e0_5i")).click();
	    webdriver.webDriver().findElement(By.id("e0_19i")).click();
	    webdriver.webDriver().findElement(By.id("e0_20i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtCodigo")).sendKeys(loja);
		webdriver.webDriver().findElement(By.name("txtRazaoSoc")).sendKeys("regresao seleniun " + loja);
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("regresao seleniun "  + loja);
		webdriver.webDriver().findElement(By.name("txtEndereco")).sendKeys("getulio vargas");
		webdriver.webDriver().findElement(By.name("txtNumero")).sendKeys("433");
		webdriver.webDriver().findElement(By.name("txtComplemento")).sendKeys("sem complemento");
		webdriver.webDriver().findElement(By.name("txtBairro")).sendKeys("Jardim Belval");
		webdriver.webDriver().findElement(By.name("txtCep")).sendKeys("06420190");

		webdriver.webDriver().findElement(By.name("psqCodMunic")).clear();
		webdriver.webDriver().findElement(By.name("psqCodMunic")).sendKeys("3505708");
		webdriver.webDriver().findElement(By.name("psqCodMunic")).sendKeys(Keys.TAB);
		webdriver.webDriver().findElement(By.name("txtCGC")).click();
		webdriver.webDriver().findElement(By.name("txtCGC")).clear();
		webdriver.webDriver().findElement(By.name("txtCGC")).sendKeys("01.548.637/0001-80");
		webdriver.webDriver().findElement(By.name("txtCnae")).sendKeys("0000000");
		webdriver.webDriver().findElement(By.name("txtCae")).sendKeys("0000000000");
		webdriver.webDriver().findElement(By.name("txtInscEstadual")).sendKeys("00000000000000000");
		webdriver.webDriver().findElement(By.name("txtInscMunicipal")).sendKeys("0000000000000000");
		webdriver.webDriver().findElement(By.name("txtFunc")).sendKeys("10");
		webdriver.webDriver().findElement(By.name("txtGerente")).sendKeys("Vando");
		webdriver.webDriver().findElement(By.name("txtTelefone")).sendKeys("199999996");
		webdriver.webDriver().findElement(By.name("txtArea")).sendKeys("1");

		webdriver.webDriver().findElement(By.name("cmbCrt")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbCrt"))).selectByVisibleText("3 - Regime Normal");
		webdriver.webDriver().findElement(By.name("chkAtivo")).click();
		webdriver.webDriver().findElement(By.name("usaNFCE")).click();
		super.PrintarEvidencia("TelaLoja","LojaPreenchida.png");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
        webdriver.webDriver().switchTo().alert().accept();
        super.PrintarEvidencia("TelaLoja","LojaSalva.png");
		String reposta =webdriver.webDriver().findElement(By.xpath("/html/body/div/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td")).getText();
		Assert.assertEquals(reposta, "Os dados foram salvos com sucesso");

		//TODO VERIFICAR SE LOJA CADASTROU COM SUCESSO
		//Thread.sleep(2500);
		//Assert.assertEquals(loja,String.valueOf(data.getUltimoId("LOJAS")));
		 
		 

		return this;
	}
	

}
