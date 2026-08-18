package br.com.y3llowhusky.taskmanager.util;

import java.util.Properties;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
	
	// método estático para criar conexão com banco
	public static Connection getConnection() {	
		
		// instanciando conexão vazia
		Connection con = null;
		
		// precisa envolver em try catch pois tem muita margem para erro
		try {
			
			// inputstream le dados do arquivo properties em bytes 
			InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties");
			
			// properties interpreta dados de arquivo .properties no padrão variável - valor
			// exemplo: usuario = "adm", senha = 123
			Properties props = new Properties();
			
			// método para interpretar os dados
			props.load(input);
			
			// atribuindo valores do arquivo .properties à variáveis equivalentes (credenciais)
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");
			
			// drivermanager cria a conexão com o banco usando as credenciais informadas
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// retorna objeto de conexão configurado a ser utilizado pelo repository
		return con;
	}
	
}
