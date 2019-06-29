package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.CorVO;

public class CorDAO implements InterfaceDAO<CorVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	
	@Override
	public void inserir(CorVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO COR ");
				sql.append("([NOM_COR]) ");
				sql.append("VALUES (?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeCor());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a cor.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(CorVO t, String... chave) {
		
		//chave[0] vai ter o novo nome da cor
		
		CorVO aux = DAOFactory.createCorDAO().consultar(t.getNomeCor());
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE COR SET ");
				sql.append("[NOM_COR] = ?,");
				sql.append("WHERE [ID_COR] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, Integer.toString(aux.getIdCor()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da cor.");
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
				sql.append("DELETE FROM COR ");
				sql.append("WHERE [NOM_COR] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o funcionário.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public CorVO consultar(String... chave) {
		CorVO cor = new CorVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("[ID_COR] FROM COR ");
				sql.append("WHERE NOM_COR = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//atualizando cor com o id obtido
				cor.setIdCor(res.getInt("ID_COR"));
				cor.setNomeCor(chave[0]);
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados da cor.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cor;
	}

	@Override
	public List<CorVO> listar() {
		List<CorVO> cor = new ArrayList<CorVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM COR");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					CorVO el = new CorVO();
					
					el.setIdCor(res.getInt("ID_COR"));
					el.setNomeCor(res.getString("NOM_COR"));
					
					cor.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos os dados das cores.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cor;
	}

}
