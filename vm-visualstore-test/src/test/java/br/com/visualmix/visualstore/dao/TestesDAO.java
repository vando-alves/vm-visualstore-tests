package br.com.visualmix.visualstore.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;



@Component
public class TestesDAO  {

	public String getNextRegistro(String tabela,String campo) throws IOException, InterruptedException, JSONException {
		
		  try {
	            HttpClient httpClient = HttpClient.newHttpClient();
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create("http://localhost:8080/api/"+ tabela +"/listLast"))
	                    .build();

	            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

	            int statusCode = response.statusCode();
	            String responseBody = response.body();

	            JSONObject json = new JSONObject(responseBody);

   	           return String.valueOf(json.getInt(campo) +1) ;
	  
	            
	        } catch (IOException e) {
	            // Lidar com exceções de IO (IOException) ou interrupção (InterruptedException) aqui
	            e.printStackTrace();
	            return "0";	
	        }
		
	}	
	
	public String getLastRegistro(String tabela,String campo) throws IOException, InterruptedException, JSONException {
		
		  try {
	            HttpClient httpClient = HttpClient.newHttpClient();
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create("http://localhost:8080/api/"+ tabela +"/listLast"))
	                    .build();

	            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

	            int statusCode = response.statusCode();
	            String responseBody = response.body();

	            JSONObject json = new JSONObject(responseBody);

	           if(campo == "codigo" || campo == "mercadologico1" || campo == "produtoId" || campo == "numero") {
	        	   
	        	   return String.valueOf(json.getInt(campo)) ;
	           }
	            
	           return json.getString(campo) ;
	            
	        } catch (IOException e) {
	            // Lidar com exceções de IO (IOException) ou interrupção (InterruptedException) aqui
	            e.printStackTrace();
	            return "0";	
	        }
		
	}

	

}
