package br.com.visualmix.visualstore.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

	@Value("${selenium.webdriver.chrome.driver-path}")
	private String chromeDriverPath;

	@Bean
	public WebDriver webDriver() {
		
		try {
	        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	        
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	    	System.setProperty("webdriver.chrome.whitelistedIps", "");
	        WebDriver webdriver = new ChromeDriver(options);
	        return webdriver;
	    } catch (Exception e) {
	        // Lida com exceções aqui
	        e.printStackTrace(); // Isso é apenas um exemplo, você pode lidar com a exceção de acordo com sua necessidade.
	        return null; // Ou pode retornar algum valor padrão ou lançar uma exceção personalizada.
	    }
	}

}