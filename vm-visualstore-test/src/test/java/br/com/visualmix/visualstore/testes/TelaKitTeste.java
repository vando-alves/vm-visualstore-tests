package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaKit;

@SpringBootTest
public class TelaKitTeste extends TestesDAO{
	
	
	@Autowired
	TelaKit telakit;

	String produtoKit ="";
	String loja ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
      produtoKit = getLastRegistro("produtos","produtoId");
	  loja = getLastRegistro("lojas","codigo");
	}
	
	
	@Test
	public void ValidarCadastroDeKit() throws IOException, InterruptedException, JSONException {
		telakit.
		LogarNoSistema().
		CadastarKit(produtoKit,loja).
		fecharTela();
		
		Assert.assertEquals(produtoKit,getLastRegistro("kitCapas", "codigo"));
	}
	

}
