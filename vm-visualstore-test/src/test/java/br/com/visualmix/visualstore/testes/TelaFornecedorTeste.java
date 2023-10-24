package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaFornecedor;

@SpringBootTest
public class TelaFornecedorTeste extends TestesDAO{

	@Autowired
	TelaFornecedor telaFornecedor;

	String fornecedor = "";

	@BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
		//fornecedor = getProximoId("FORNECEDORES", "CODIGO");
		fornecedor = getNextRegistro("fornecedor","codigo");
	}

	@Test
	public void ValidarCadastroDeLoja() throws IOException, InterruptedException, JSONException {
		telaFornecedor.
		LogarNoSistema().
		CadastarFornecedor(fornecedor).
		fecharTela();
		Assert.assertEquals(fornecedor, getLastRegistro("fornecedor", "codigo"));
	}

}
