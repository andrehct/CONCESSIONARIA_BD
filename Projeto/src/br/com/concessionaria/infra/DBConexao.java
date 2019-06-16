package br.com.concessionaria.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConexao {

	private Connection connection = null;

	protected DataSource dataSource = null;
	private static DBConexao instance = new DBConexao();

	public DBConexao(){

	}


	public Connection getConnection() {
		return datasourceConnection();

	}

	private Connection datasourceConnection(){
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CONCESSIONARIA;","javaUsu","123456");
			System.out.println("conectado!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar montar o lookup de conexão com o database.");
		}

		return connection;
	}



	public static DBConexao getInstance() {
		return instance;
	}

	public static void setInstance(DBConexao instance) {
		DBConexao.instance = instance;
	}

	

}
