package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.ModeloVO;

public class ModeloDAO implements InterfaceDAO<ModeloVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(ModeloVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO MODELO ");
				sql.append("([NOM_MODELO], [ID_MARCA], [NUM_ANO]) ");
				sql.append("VALUES (?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeModelo());
				stmt.setString(2, Integer.toString(t.getIdMarca()));
				stmt.setString(3, Integer.toString(t.getAno()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o modelo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(ModeloVO t, String... chave) {
		//chave [0] = idModelo
		//chave [1] = idMarca
		//chave [3] = ano
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE MODELO SET ");
				sql.append("[NOM_MODELO] = ?,");
				sql.append("[ID_MARCA] = ?,");
				sql.append("[NUM_ANO] = ? ");
				sql.append("WHERE [ID_MODELO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeModelo());
				stmt.setString(2, Integer.toString(t.getIdMarca()));
				stmt.setString(3, Integer.toString(t.getAno()));
				stmt.setString(4, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do modelo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void excluir(String... chave) {
		//chave [0] = idModelo
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM MODELO ");
				sql.append("WHERE [ID_MODELO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o modelo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public ModeloVO consultar(String... chave) {
		
		//chave [0] = idModelo
		
		ModeloVO modelo = new ModeloVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM MODELO ");
				sql.append("WHERE [ID_MODELO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//atualizando modelo com o id obtido
				modelo.setIdModelo(res.getInt("ID_MODELO"));
				modelo.setIdMarca(res.getInt("ID_MARCA"));
				modelo.setAno(res.getInt("NUM_ANO"));
				modelo.setNomeModelo(res.getString("NOM_MODELO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do modelo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return modelo;
	}

	@Override
	public List<ModeloVO> listar() {
		List<ModeloVO> modelo = new ArrayList<ModeloVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM MODELO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					ModeloVO el = new ModeloVO();
					
					el.setAno(res.getInt("NUM_ANO"));
					el.setIdMarca(res.getInt("ID_MARCA"));
					el.setIdModelo(res.getInt("ID_MODELO"));
					el.setNomeModelo(res.getString("NOM_MODELO"));
					
					modelo.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do modelo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return modelo;
	}

}
