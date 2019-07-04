package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE CARGO SET ");
				sql.append("[NOM_CARGO] = ? ");
				sql.append("WHERE [ID_CARGO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, cargo.getNomeCargo());
				stmt.setString(2, chave[0]);
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
				sql.append("WHERE [ID_CARGO] = ?");
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
				sql.append("SELECT * FROM CARGO ");
				sql.append("WHERE [ID_CARGO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando cargo com os dados obtidos
				cargo.setNomeCargo(res.getString("NOM_CARGO"));
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
		List<CargoVO> cargo = new ArrayList<CargoVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM CARGO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					CargoVO el = new CargoVO();
					
					el.setIdCargo(res.getInt("ID_CARGO"));
					el.setNomeCargo(res.getString("NOM_CARGO"));
					
					cargo.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados dos cargos.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cargo;
	}

}
