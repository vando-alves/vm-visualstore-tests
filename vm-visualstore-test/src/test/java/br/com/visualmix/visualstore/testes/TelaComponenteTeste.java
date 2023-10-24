package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.databsp.md.dtos.ComponentesDTO;
import br.com.visualmix.visualstore.telas.TelaComponente;

@SpringBootTest
public class TelaComponenteTeste extends TestesDAO {
	
	@Autowired
	TelaComponente telaComponente;
	
	String componente;
	String loja = "1";
	
	@BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
	     componente = "200";
		 loja = getLastRegistro("lojas","codigo");
	}
	
	
	@Test
	public void ValidarCadastroDeComponentePDV() throws IOException, InterruptedException, JSONException {
		telaComponente.
		LogarNoSistema().
		CadastarComponentePDV(loja,componente);
        Assert.assertEquals(componente,getLastRegistro("componentes", "codigo"));
	}
	
	
	@Test
	public void ValidarCadastroDeComponenteTotem() {
		telaComponente.
		LogarNoSistema().
		CadastarComponenteTotem(loja,componente);
	
		
	//	Assert.assertEquals(loja, getLastComponente(loja,componente));
	}
	
	@Test
	public void ValidarCadastroDeComponenteGateway() {
		telaComponente.
		LogarNoSistema().
		CadastarComponenteGateway(loja,componente);
		
		Assert.assertTrue(true);
	}
	

   public void ValidarDeleteComponente() {
		
	}
   
   public void ValidarAtualizacaoComponente() {
		
	}
}
