package br.com.visualmix.visualstore.telas;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import br.com.visualmix.visualstore.config.WebDriverConfig;

public abstract  class BaseTela {
	
	@Autowired
	WebDriverConfig webdriver;
	
	static final String URL = "http://localhost:8091/vm_visualstore_adm";
	public boolean usuarioLogado;
	
	public BaseTela LogarNoSistema() {
		webdriver.webDriver().get(URL);
		webdriver.webDriver().findElement(By.id("usuarios")).sendKeys("visualmix");
		webdriver.webDriver().findElement(By.id("senha")).clear();
		webdriver.webDriver().findElement(By.id("senha")).sendKeys("1");
		webdriver.webDriver().findElement(By.id("btnEnviar")).click();
		
		return this;
	}
	

	public BaseTela PrintarEvidencia(String Tela ,String NomeImagem) {
		try {
			File scrFile = ((TakesScreenshot)webdriver.webDriver()).getScreenshotAs(OutputType.FILE);
			FileCopyUtils.copy(scrFile, new File("D:\\evidencias\\" + Tela + NomeImagem));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return this;
	} 
	
	
	public void fecharTela() {
		webdriver.webDriver().close();
	}
	
	
	

}
