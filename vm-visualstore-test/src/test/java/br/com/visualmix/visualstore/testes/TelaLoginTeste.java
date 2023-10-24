package br.com.visualmix.visualstore.testes;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.visualmix.visualstore.telas.TelaLogin;

@SpringBootTest
public class TelaLoginTeste {

	@Autowired
	TelaLogin telaLogin;
	
	@AfterEach
	private void terminarExecucao() {
		telaLogin.fecharTela();
	}
	
	@Test
	public void DeveriaAcessarOVisualStore() {
		telaLogin.
		acessarTelaLogin()
		.PreencherCampos("visualmix", "1")
		.SubmeterFormulario()
		.ValidarSeLogouNoVisualStore()
		.PrintarEvidencia("TelaLogin","UsuarioLogado.png");
		
		Assert.assertEquals(telaLogin.usuarioLogado, true);
	}
	
	@Test
	public void NaoDeveriaAcessarOVisualStoreSenhaIncorreta() {
		telaLogin.
		acessarTelaLogin()
		.PreencherCampos("visualmix", "666")
		.SubmeterFormulario()
		.ValidarSeLogouNoVisualStore()
		.PrintarEvidencia("TelaLogin","SenhaIncorreta.png");
		
		Assert.assertEquals(telaLogin.usuarioLogado, false);
	}
	
	@Test
	public void NaoDeveriaAcessarOVisualStoreUsuarioInexistente() {
		telaLogin.
		acessarTelaLogin()
		.PreencherCampos("UsuarioInexistente", "1")
		.SubmeterFormulario()
		.ValidarSeLogouNoVisualStore()
		.PrintarEvidencia("TelaLogin","UsuarioNaoExiste.png");
		
		Assert.assertEquals(telaLogin.usuarioLogado, false);
	}

}
