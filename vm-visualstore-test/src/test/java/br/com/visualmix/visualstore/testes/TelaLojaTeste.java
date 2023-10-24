package br.com.visualmix.visualstore.testes;

import java.io.IOException;
import java.time.Duration;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaLoja;

@SpringBootTest
public class TelaLojaTeste extends TestesDAO{

	@Autowired
    TelaLoja telaLoja;

	String loja ="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
	 loja = getNextRegistro("lojas","codigo");
	}

	@Test
	public void ValidarCadastroDeLoja() throws IOException, InterruptedException, JSONException {
		telaLoja.
		LogarNoSistema().
		CadastarLoja(loja).
		fecharTela();
		Assert.assertEquals(loja,getLastRegistro("lojas","codigo"));
	
	}
	
}
