package br.com.concessionaria.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexaoDAO {


	public static Connection getConn() {
		return DBConexao.getInstance().getConnection();
	}

	public static void liberaConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conexao != null)
				conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		getConn();
	}
}
