package br.com.visualmix.visualstore.testes;

import java.io.IOException;
import java.sql.ResultSet;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.visualmix.visualstore.dao.TestesDAO;

public class TesteConexao extends TestesDAO {

	int a;

	@Test
	public void testConexao() throws IOException, InterruptedException, JSONException {
		
		System.out.println(getNextRegistro("lojas","codigo"));
		System.out.println("Teste");
		Assert.assertTrue(true);
	}

}
