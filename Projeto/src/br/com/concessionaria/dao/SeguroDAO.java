package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
				sql.append("([NOM_SEGURO],[VAL_PRECO],[ID_SEGURADORA]) ");
				sql.append("VALUES (?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getNome());
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
				sql.append("[VAL_PRECO] = ?, ");
				sql.append("[NOM_SEGURO] = ?, ");
				sql.append("[ID_SEGURADORA] = ? ");
				sql.append("WHERE [ID_SEGURO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, Float.toString(t.getPreco()));
				stmt.setString(2, t.getNome());
				stmt.setString(3, Integer.toString(t.getIdSeguradora()));
				stmt.setString(4, chave[0]);
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
	public SeguroVO consultar(String... chave) {
		SeguroVO seg = new SeguroVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM SEGURO ");
				sql.append("WHERE [ID_SEGURO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando funcionario com os dados obtidos
				seg.setIdSeguradora(res.getInt("ID_SEGURADORA"));
				seg.setNome(res.getString("NOM_SEGURO"));
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
		
		List<SeguroVO> aux = new ArrayList<SeguroVO>();

		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM SEGURO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					SeguroVO seg = new SeguroVO();
					
					seg.setIdSeguradora(res.getInt("ID_SEGURADORA"));
					seg.setIdSeguro(res.getInt("ID_SEGURO"));
					seg.setNome(res.getString("NOM_SEGURO"));
					seg.setPreco(res.getFloat("VAL_PRECO"));
					
					aux.add(seg);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos dados do seguro.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return aux;
	}

}
