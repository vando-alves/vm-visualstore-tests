package br.com.visualmix.visualstore.testes;

import java.io.IOException;
import java.text.DecimalFormat;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.visualmix.visualstore.dao.TestesDAO;
import br.com.visualmix.visualstore.telas.TelaUsuario;

@SpringBootTest
public class TelaUsuarioTeste extends TestesDAO{
	
	@Autowired
    TelaUsuario telaUsuario;
	
	
	String usuario ="";
	String loja = "";
	String descLoja="";
	String niveisPDV="";

    @BeforeEach
	public void inicializar() throws IOException, InterruptedException, JSONException {
     usuario = getNextRegistro("acessoOperador","codigo");
     loja = getLastRegistro("lojas","codigo");
     descLoja =  getLastRegistro("lojas", "bairro") +"-" + getLastRegistro("lojas", "cidade") +"-" + getLastRegistro("lojas", "uf");
     niveisPDV = getLastRegistro("niveisOperadores", "codigo") +"-" + getLastRegistro("niveisOperadores", "descricao");
     
   
	}
	
	@Test
	public void ValidarCadastroDeUsuario() throws IOException, InterruptedException, JSONException {

	   DecimalFormat  formatador  = new DecimalFormat("0000");

		telaUsuario.
		LogarNoSistema().
		CadastarUsuario(usuario, formatador.format(Integer.valueOf(loja)),descLoja,niveisPDV).
		fecharTela();

		Assert.assertEquals(usuario,getLastRegistro("acessoOperador", "codigo"));
	}


}
