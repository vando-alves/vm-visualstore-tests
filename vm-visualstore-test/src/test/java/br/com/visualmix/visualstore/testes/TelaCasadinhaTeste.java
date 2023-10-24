package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaCasadinha;

@SpringBootTest
public class TelaCasadinhaTeste extends TestesDAO{
	
	@Autowired
	TelaCasadinha telaCasadinha;
	
	String casadinha="";
	String loja="";
	String produto="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    casadinha= getNextRegistro("casadinhas","codigo");	
    produto = getLastRegistro("produtos","produtoId");
    loja = getLastRegistro("lojas","codigo");
	}
	
	
	@Test
	public void ValidarCadastroDeCasadinha() throws IOException, InterruptedException, JSONException {
		telaCasadinha.
		LogarNoSistema().
		CadastarCasadinha(casadinha,loja,produto).
		fecharTela();
		Assert.assertEquals(casadinha,getLastRegistro("casadinhas","codigo"));
	}
	

}
