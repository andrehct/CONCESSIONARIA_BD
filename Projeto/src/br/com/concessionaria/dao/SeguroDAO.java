package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.SeguroVO;

public class SeguroDAO implements InterfaceDAO<SeguroVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(SeguroVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO SEGURO ");
				sql.append("([DES_CHASSI],[VAL_PRECO],[ID_SEGURADORA]) ");
				sql.append("VALUES (?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getChassi());
				stmt.setString(2, Float.toString(t.getPreco()));
				stmt.setString(3, Integer.toString(t.getIdSeguradora()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o seguro.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(SeguroVO t, String... chave) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE SEGURO SET ");
				sql.append("[VAL_PRECO] = ? ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [ID_SEGURADORA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, Integer.toString(t.getIdSeguro()));
				stmt.setString(3, t.getChassi());
				stmt.setString(4, Integer.toString(t.getIdSeguradora()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do seguro.");
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
				sql.append("DELETE FROM SEGURO ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [ID_SEGURADORA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o funcion�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public SeguroVO consultar(String... chave) {
		SeguroVO seg = new SeguroVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("[VAL_PRECO] FROM SEGURO ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [ID_SEGURADORA] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando funcionario com os dados obtidos
				seg.setChassi(res.getString("DES_CHASSI"));
				seg.setIdSeguradora(res.getInt("ID_SEGURADORA"));
				seg.setIdSeguro(res.getInt("ID_SEGURO"));
				seg.setPreco(res.getFloat("VAL_PRECO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do seguro.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return seg;
	}

	@Override
	public List<SeguroVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}