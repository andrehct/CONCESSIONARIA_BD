package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.FuncVendaAutoVO;

public class FuncVendaAutoDAO implements InterfaceDAO<FuncVendaAutoVO>{

	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	
	@Override
	public void inserir(FuncVendaAutoVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO FUNCIONARIO_VENDA_AUTO ");
				sql.append("([NUM_CPF_FUNCIONARIO],[DES_CHASSI],[DTA_VENDA]) ");
				sql.append("VALUES (?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, t.getChassi());
				stmt.setString(3, t.getDataVenda());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a relação de venda de automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(FuncVendaAutoVO t, String... chave) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE FUNCIONARIO_VENDA_AUTO SET ");
				sql.append("[NUM_CPF_FUNCIONARIO] = ?,");
				sql.append("[DES_CHASSI] = ?,");
				sql.append("[DTA_VENDA] = ? ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DES_CHASSI] = ? AND [DTA_VENDA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, t.getChassi());
				stmt.setString(3, t.getDataVenda());
				stmt.setString(4, chave[0]);
				stmt.setString(5, chave[1]);
				stmt.setString(6, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da venda do automóvel.");
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
				sql.append("DELETE FROM FUNCIONARIO_VENDA_AUTO ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DES_CHASSI] = ? AND [DTA_VENDA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir a venda do automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public FuncVendaAutoVO consultar(String... chave) {
		//Não há necessidade de consulta
		return null;
	}

	@Override
	public List<FuncVendaAutoVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
