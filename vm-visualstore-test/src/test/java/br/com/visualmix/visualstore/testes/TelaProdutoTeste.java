package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaProduto;

@SpringBootTest
public class TelaProdutoTeste  extends TestesDAO {

	@Autowired
	TelaProduto telaProduto;

	String codigo ="";
	String codigofornecedor ="";
	String mercadologico ="";
	String loja ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    	
    	 codigo = getNextRegistro("produtos","produtoId");
    	 codigofornecedor = getLastRegistro("fornecedor","codigo");
    	 loja = getLastRegistro("lojas","codigo");
    	 mercadologico = getLastRegistro("mercadologico","mercadologico1");

	}
	
	
	@Test
	public void ValidarCadastroDeProduto() throws IOException, InterruptedException, JSONException {
		telaProduto.
		LogarNoSistema().
		CadastarProduto(codigo,codigofornecedor,mercadologico, loja);
		Assert.assertEquals(codigo,getLastRegistro("produtos", "produtoId"));
	}
	
	
}
