package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaCuponagem;

@SpringBootTest
public class TelaCuponagemTeste extends TestesDAO{

	@Autowired
	TelaCuponagem telaCuponagem;

	String loja ="";
	String cuponagem ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    	cuponagem =  getNextRegistro("cupom","codigo");
    	loja = getLastRegistro("lojas","codigo");
	}
	
	
	@Test
	public void ValidarCadastroDeCuponagem() throws IOException, InterruptedException, JSONException {
		telaCuponagem.
		LogarNoSistema().
		CadastarCuponagem(cuponagem,loja).
		fecharTela();
		Assert.assertEquals(cuponagem,getLastRegistro("cupom","codigo"));
	}
	
	
}
