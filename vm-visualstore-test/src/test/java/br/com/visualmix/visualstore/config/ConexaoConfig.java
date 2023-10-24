package br.com.visualmix.visualstore.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.maxicode.core.Conexao;
import br.com.visualmix.generico.conexao.Application;


public  class ConexaoConfig {

	Connection conn;
	
    public DataSource getDataSource( ) throws PropertyVetoException, SQLException {
    	Application.ArquivoConf = "VM_VisualStore_Adm.conf";
		Application.initialize();
		Application application =  Application.getInstance();
		
	
        Conexao conexao = application.getNovaConexao("DEFAULT");
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setDriverClass(conexao.getDatabase().getClass().getName());
        pool.setJdbcUrl(conexao.getDatabase().getMetaData().getURL());
        pool.setUser(conexao.getLogin());
        pool.setPassword(conexao.getSenha());
       return pool;
     
    }

	
    public JdbcTemplate getJdbcTemplate()  {
        try {
			return new JdbcTemplate(getDataSource());
		} catch (PropertyVetoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	

}
