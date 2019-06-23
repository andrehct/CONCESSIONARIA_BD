package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.factory.DAOFactory;
import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.CargoVO;

public class CargoDAO implements InterfaceDAO<CargoVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	
	@Override
	public void inserir(CargoVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO CARGO ");
				sql.append("([NOM_CARGO]) ");
				sql.append("VALUES (?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNomeCargo());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o cargo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(CargoVO cargo, String... chave) {
		
		//chave[0] vai ter o novo nome do cargo
		
		CargoVO aux = DAOFactory.createCargoDAO().consultar(cargo.getNomeCargo());
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE CARGO SET ");
				sql.append("[NOM_CARGO] = ? ");
				sql.append("WHERE [ID_CARGO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, Integer.toString(aux.getIdCargo()));
			//Executando a query no banco
				stmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do cargo.");
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
				sql.append("DELETE FROM CARGO ");
				sql.append("WHERE [NOM_CARGO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o cargo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public CargoVO consultar(String... chave) {
		CargoVO cargo = new CargoVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("[ID_CARGO] ");
				sql.append("FROM CARGO ");
				sql.append("WHERE [NOM_CARGO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando cargo com os dados obtidos
				cargo.setNomeCargo(chave[0]);
				cargo.setIdCargo(res.getInt("ID_CARGO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do cargo.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cargo;
	}

	@Override
	public List<CargoVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
