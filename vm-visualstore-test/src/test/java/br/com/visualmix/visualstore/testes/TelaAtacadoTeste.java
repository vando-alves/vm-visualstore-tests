package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaAtacado;

@SpringBootTest
public class TelaAtacadoTeste extends TestesDAO{

	@Autowired
	TelaAtacado telaAtacado;

	String atacado  ="";
	String codigo ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    	atacado = getNextRegistro("precoAtacado", "codigoOperacao");
    	codigo = getLastRegistro("produtos","produtoId");
	}
	
	
	@Test
	public void ValidarCadastroDeAtacado() throws IOException, InterruptedException, JSONException {
		telaAtacado.
		LogarNoSistema().
		CadastarAtacado(codigo).
		fecharTela();
		Assert.assertEquals(atacado,getLastRegistro("precoAtacado", "codigoOperacao"));
	}
	
	
}
