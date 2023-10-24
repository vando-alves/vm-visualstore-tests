package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaMercadologico;

@SpringBootTest
public class TelaMercadologicoTeste  extends TestesDAO{

	@Autowired
	TelaMercadologico telaMercadologico;

	String mercadologico ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    	mercadologico = getNextRegistro("mercadologico","mercadologico1");
	}
	
	@Test
	public void ValidarCadastroDeMercadologico() throws IOException, InterruptedException, JSONException {
		telaMercadologico.
		LogarNoSistema().
		CadastarMercadologico(mercadologico).
		fecharTela();
		Assert.assertEquals(mercadologico,getLastRegistro("mercadologico", "mercadologico1"));
	}
	
	
}
