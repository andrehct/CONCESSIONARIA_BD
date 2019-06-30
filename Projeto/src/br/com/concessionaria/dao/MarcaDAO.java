package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.MarcaVO;

public class MarcaDAO implements InterfaceDAO<MarcaVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(MarcaVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO MARCA ");
				sql.append("([NOM_MARCA]) ");
				sql.append("VALUES (?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeMarca());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a marca.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(MarcaVO t, String... chave) {
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE MARCA SET ");
				sql.append("[NOM_MARCA] = ? ");
				sql.append("WHERE [ID_MARCA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeMarca());
				stmt.setString(2, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da marca.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void excluir(String... chave) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM MARCA ");
				sql.append("WHERE [ID_MARCA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir a marca.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public MarcaVO consultar(String... chave) {
		MarcaVO marca = new MarcaVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("* FROM MARCA ");
				sql.append("WHERE ID_MARCA = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//atualizando marca com o id obtido
				marca.setIdMarca(res.getInt("ID_MARCA"));
				marca.setNomeMarca(res.getString("NOM_MARCA"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados da marca.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return marca;
	}

	@Override
	public List<MarcaVO> listar() {
		List<MarcaVO> marca = new ArrayList<MarcaVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM MARCA");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					MarcaVO el = new MarcaVO();
					
					el.setIdMarca(res.getInt("ID_MARCA"));
					el.setNomeMarca(res.getString("NOM_MARCA"));
					
					marca.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos os dados da marca.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return marca;
	}

}
