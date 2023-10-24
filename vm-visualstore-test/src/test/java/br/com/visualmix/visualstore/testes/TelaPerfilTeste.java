package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaPerfil;

@SpringBootTest
public class TelaPerfilTeste extends TestesDAO{
	
	
	@Autowired
    TelaPerfil telaPerfil;
	
	String perfil ="";

	 @BeforeEach
		public void inicializar() throws IOException, InterruptedException, JSONException {
	    	perfil = getNextRegistro("acessoPerfil","codigo");
		}

	@Test
	public void ValidarCadastroDePerfil() throws IOException, InterruptedException, JSONException {
		telaPerfil.
		LogarNoSistema().
		CadastarPerfil().
		fecharTela();
		Assert.assertEquals(perfil,getLastRegistro("acessoPerfil","codigo"));
	}
	

}
