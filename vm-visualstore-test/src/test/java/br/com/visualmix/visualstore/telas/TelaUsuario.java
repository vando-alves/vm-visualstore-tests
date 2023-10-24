package br.com.visualmix.visualstore.telas;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import br.com.maxicode.util.Funcoes;
	
@Component
public class TelaUsuario extends BaseTela{

	@Override
	public TelaUsuario LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	
	public TelaUsuario CadastarUsuario(String usuario, String loja,String descLoja,String niveisPDV) {
	
		webdriver.webDriver().findElement(By.id("e0_0o")).click();
		webdriver.webDriver().findElement(By.id("e0_2i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("cmbLoja")).click();
		System.out.println(loja  +"-"+ descLoja);
		new Select(webdriver.webDriver().findElement(By.name("cmbLoja"))).selectByVisibleText( loja +"-"+ descLoja);
		webdriver.webDriver().findElement(By.name("txtLogin")).sendKeys("usuario regresao seleniun " + usuario);
		webdriver.webDriver().findElement(By.name("txtIdentificacao")).sendKeys(usuario);
		webdriver.webDriver().findElement(By.name("txtNome")).sendKeys("usuario regresao seleniun");
		webdriver.webDriver().findElement(By.name("txtTelefone")).sendKeys("11968315270"); 
		webdriver.webDriver().findElement(By.name("cmbSituacao")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbSituacao"))).selectByVisibleText("0-Ativo");
		webdriver.webDriver().findElement(By.name("txtEmail1")).sendKeys("vando.Jesus29@gmail.com");
		webdriver.webDriver().findElement(By.name("txtEmail2")).sendKeys("vando.Jesus29@gmail.com");
		webdriver.webDriver().findElement(By.name("txtEmail3")).sendKeys("vando.Jesus29@gmail.com");
		webdriver.webDriver().findElement(By.name("txtSenha")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("txtSenhaConf")).sendKeys("1");

		webdriver.webDriver().findElement(By.name("txtSenhaPdv")).sendKeys("1");
	    webdriver.webDriver().findElement(By.name("txtSenhaPdvConf")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("cmbNivel")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbNivel"))).selectByVisibleText(niveisPDV.toUpperCase());
		webdriver.webDriver().findElement(By.name("txtCodigoIntegracao")).sendKeys(usuario);
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		// ABA PERMISSOES
		webdriver.webDriver().findElement(By.id("lnktabtabTela1")).click();
		webdriver.webDriver().findElement(By.name("dtgPermissao_header")).click();
		webdriver.webDriver().findElement(By.xpath("//div[@id='tabtabTela1']/table/tbody/tr[4]/td/input")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		// ABA LOJA
		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();
		webdriver.webDriver().findElement(By.name("dtgLojas_header")).click();
		webdriver.webDriver().findElement(By.xpath("//div[@id='tabtabTela2']/table/tbody/tr[4]/td/input")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();

		return this;
	}
	

}
