package br.com.visualmix.visualstore.telas;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class TelaLogin extends BaseTela {

	public TelaLogin acessarTelaLogin() {
		webdriver.webDriver().get(URL);
		return this;
	}

	public TelaLogin PreencherCampos(String usuario, String senha) {
		webdriver.webDriver().findElement(By.id("usuarios")).sendKeys(usuario);
		webdriver.webDriver().findElement(By.id("senha")).clear();
		webdriver.webDriver().findElement(By.id("senha")).sendKeys(senha);
		return this;
	}

	public TelaLogin SubmeterFormulario() {
		webdriver.webDriver().findElement(By.id("btnEnviar")).click();
		return this;
	}

	public TelaLogin ValidarSeLogouNoVisualStore() {
		usuarioLogado = webdriver.webDriver().getPageSource().contains("Visual Mix Framework");
		return this;
	}

	@Override
	public TelaLogin PrintarEvidencia(String nomeTela ,String nomeImagem) {
		super.PrintarEvidencia(nomeTela,nomeImagem);
		return this;
	}

}
