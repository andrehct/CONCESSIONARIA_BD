package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.factory.DAOFactory;
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
		
		//chave[0] vai ter o novo nome da marca
		
		MarcaVO aux = DAOFactory.createMarcaDAO().consultar(t.getNomeMarca());
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE MARCA SET ");
				sql.append("[NOM_MARCA] = ? ");
				sql.append("WHERE [ID_MARCA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, Integer.toString(aux.getIdMarca()));
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
				sql.append("WHERE [NOM_MARCA] = ?");
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
				sql.append("[ID_MARCA] FROM COR ");
				sql.append("WHERE NOM_MARCA = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//atualizando marca com o id obtido
				marca.setIdMarca(res.getInt("ID_MARCA"));
				marca.setNomeMarca(chave[0]);
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
		// TODO Auto-generated method stub
		return null;
	}

}