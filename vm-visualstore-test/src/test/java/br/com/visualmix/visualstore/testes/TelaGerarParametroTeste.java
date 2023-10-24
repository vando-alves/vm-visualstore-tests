package br.com.visualmix.visualstore.testes;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaGerarParametros;
import org.junit.Assert;

@SpringBootTest
public class TelaGerarParametroTeste extends TestesDAO{
	
	@Autowired
	TelaGerarParametros telaGerarParametros;

	String numeroProcessoNext  ="";
	String descricao = "";
    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
    	numeroProcessoNext = getNextRegistro("processosResultados", "numero");
	}
	
	
	@Test
	public void ValidarGeraParametros() throws IOException, InterruptedException, JSONException {
		telaGerarParametros.
		LogarNoSistema().
		GerarParametro().
		fecharTela();
		// Esperar 1 minuto
        Thread.sleep(30000);
        
        String numeroProcessoLast = getLastRegistro("processosResultados", "numero");
        
        if(numeroProcessoNext.equals(numeroProcessoLast)) {
        	
        	 System.out.println("ENtrou no IF");
           descricao = getLastRegistro("processosResultados", "descricao");
             
           System.out.println(descricao);
     		while( descricao == "") {
     			  Thread.sleep(60000);
     		}
     		
        	
        }
 
        System.out.println(descricao);
		Assert.assertTrue(descricao.contains("com Sucesso"));
		
	}
	

}
