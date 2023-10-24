package br.com.visualmix.visualstore.telas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import br.com.maxicode.util.Funcoes;

@Component
public class TelaProduto extends BaseTela{

	@Override
	public TelaProduto LogarNoSistema() {
		super.LogarNoSistema();
		return this;
	}

	
	public TelaProduto CadastarProduto(String codigo, String fornecedor,String mercadologico, String loja) {
		
		webdriver.webDriver().findElement(By.id("e0_5i")).click();
	    webdriver.webDriver().findElement(By.id("e0_6o")).click();
		webdriver.webDriver().findElement(By.id("e0_7i")).click();
		webdriver.webDriver().switchTo().frame(0).findElement(By.linkText("Incluir")).click();
		webdriver.webDriver().findElement(By.name("txtProdutoId")).clear();
		webdriver.webDriver().findElement(By.name("txtProdutoId")).sendKeys(codigo);
		webdriver.webDriver().findElement(By.name("txtDescricaoCompleta")).sendKeys("produto regresao seleniun");
		webdriver.webDriver().findElement(By.name("txtDescricaoReduzida")).sendKeys("produto regresao");
		webdriver.webDriver().findElement(By.name("txtFornecedor")).clear();
		webdriver.webDriver().findElement(By.name("txtFornecedor")).sendKeys(fornecedor);
		webdriver.webDriver().findElement(By.name("txtReferencia")).sendKeys("teste referncia");
		webdriver.webDriver().findElement(By.name("txtDescricaoBalanca")).sendKeys("teste desc balanca");
		webdriver.webDriver().findElement(By.name("cmbSituacao")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbSituacao"))).selectByVisibleText("Ativo");
		webdriver.webDriver().findElement(By.name("cbxFabricacaoPropria")).click();
		webdriver.webDriver().findElement(By.name("chkLocalProducao")).click();
		webdriver.webDriver().findElement(By.name("cbxEmiteEtiqueta")).click();
		webdriver.webDriver().findElement(By.name("cbxPesoVariavel")).click();
		webdriver.webDriver().findElement(By.name("cbxPrePesado")).click();
		webdriver.webDriver().findElement(By.name("cbxQtdDecimal")).click();

	
		// INCLUIR MERCADOLOGICO
		webdriver.webDriver().findElement(By.id("lnktabtabTela2")).click();
		// Crie um objeto Select a partir do elemento com o nome "cmbMercadoLogico1"
		Select select1 = new Select(webdriver.webDriver().findElement(By.name("cmbMercadoLogico1")));

		// Selecione o primeiro elemento do combobox por índice (0)
		select1.selectByIndex(2);
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
	
		// INCLUIR EMBALAGEM

		webdriver.webDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		webdriver.webDriver().findElement(By.id("lnktabtabTela3")).click();
		webdriver.webDriver().findElement(By.name("btnIncluirEmbalagens")).click();
		webdriver.webDriver().findElement(By.name("txtDescricao")).click();
		webdriver.webDriver().findElement(By.name("txtDescricao")).clear();
		webdriver.webDriver().findElement(By.name("txtDescricao")).sendKeys("UND");
		webdriver.webDriver().findElement(By.name("txtSequencia")).clear();
		webdriver.webDriver().findElement(By.name("txtSequencia")).sendKeys("1");
		webdriver.webDriver().findElement(By.name("cmbTipoValidade")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoValidade"))).selectByVisibleText("Dias");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		webdriver.webDriver().findElement(By.name("btnFechar")).click();
		
	
		// INCLUIR CODIGO AUTOMACAO

		webdriver.webDriver().findElement(By.name("btnIncluirAutomacao")).click();
		webdriver.webDriver().findElement(By.name("cmbSeqEmbalagem")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbSeqEmbalagem"))).selectByVisibleText("1 - UND / 0.0");
		webdriver.webDriver().findElement(By.name("cmbTipoCodigo")).click();
		new Select(webdriver.webDriver().findElement(By.name("cmbTipoCodigo"))).selectByVisibleText("Ean");
		webdriver.webDriver().findElement(By.name("txtCodAutomacao")).clear();
		webdriver.webDriver().findElement(By.name("txtCodAutomacao")).sendKeys(Funcoes.format(codigo, "000000000000")+"0");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
		webdriver.webDriver().findElement(By.name("btnFechar")).click();
		
	
		// EMBALAGEM LOJA

		webdriver.webDriver().findElement(By.id("lnktabtabTela4")).click();
		webdriver.webDriver().findElement(By.name("btnIncluirEmbLoja")).click();
		webdriver.webDriver().findElement(By.name("cmbSeqEmbalagem")).click();
		Select select3 = new Select(webdriver.webDriver().findElement(By.name("cmbSeqEmbalagem")));
		select3.selectByIndex(1);
		webdriver.webDriver().findElement(By.name("txtLoja")).clear();
		webdriver.webDriver().findElement(By.name("txtLoja")).sendKeys(String.valueOf(loja));
		webdriver.webDriver().findElement(By.name("txtPrecoVenda")).clear();
		webdriver.webDriver().findElement(By.name("txtPrecoVenda")).sendKeys("3,99");
		webdriver.webDriver().findElement(By.id("lnktabtabTela1")).click();
		webdriver.webDriver().findElement(By.name("txtSituacaoTributaria")).clear();
		webdriver.webDriver().findElement(By.name("txtSituacaoTributaria")).sendKeys("0");
		webdriver.webDriver().findElement(By.name("txtAliquota")).clear();
		webdriver.webDriver().findElement(By.name("txtAliquota")).sendKeys("11,00");
		webdriver.webDriver().findElement(By.name("btnSalvar")).click();
		webdriver.webDriver().switchTo().alert().accept();
		webdriver.webDriver().findElement(By.name("cmdOK")).click();
    
		return this;
	}

	
}
