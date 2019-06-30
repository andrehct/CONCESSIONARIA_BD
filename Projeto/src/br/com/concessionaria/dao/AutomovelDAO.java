package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.vo.AutomovelVO;

public class AutomovelDAO implements InterfaceDAO<AutomovelVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(AutomovelVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO AUTOMOVEL ");
				sql.append("([DES_CHASSI],[VAL_PRECO],[ID_TPAUTO],");
				sql.append("[ID_MODELO],[ID_COR]) ");
				sql.append("VALUES (?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getChassi());
				stmt.setString(2, Float.toString(t.getPreco()));
				stmt.setString(3, Integer.toString(t.getIdTpAuto()));
				stmt.setString(4, Integer.toString(t.getIdModelo()));
				stmt.setString(5, Integer.toString(t.getIdCor()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(AutomovelVO t, String... chave) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE AUTOMOVEL SET ");
				sql.append("[DES_CHASSI] = ?,");
				sql.append("[VAL_PRECO] = ?,");
				sql.append("[ID_TPAUTO] = ?,");
				sql.append("[ID_MODELO] = ?,");
				sql.append("[ID_COR] = ? ");
				sql.append("WHERE [DES_CHASSI] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getChassi());
				stmt.setString(2, Float.toString(t.getPreco()));
				stmt.setString(3, Integer.toString(t.getIdTpAuto()));
				stmt.setString(4, Integer.toString(t.getIdModelo()));
				stmt.setString(5, Integer.toString(t.getIdCor()));
				stmt.setString(6, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do automóvel.");
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
				sql.append("DELETE FROM AUTOMOVEL ");
				sql.append("WHERE [DES_CHASSI] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public AutomovelVO consultar(String... chave) {
		AutomovelVO auto = new AutomovelVO();
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM AUTOMOVEL ");
				sql.append("WHERE [DES_CHASSI] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando automóvel com os dados obtidos
				auto.setChassi(res.getString("DES_CHASSI"));
				auto.setPreco(res.getFloat("VAL_PRECO"));
				auto.setIdCor(res.getInt("ID_COR"));
				auto.setIdModelo(res.getInt("ID_MODELO"));
				auto.setIdTpAuto(res.getInt("ID_TPAUTO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		return auto;
	}

	@Override
	public List<AutomovelVO> listar() {
		List<AutomovelVO> auto = new ArrayList<AutomovelVO>();
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM AUTOMOVEL");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					AutomovelVO el = new AutomovelVO();
					
					el.setChassi(res.getString("DES_CHASSI"));
					el.setPreco(res.getFloat("VAL_PRECO"));
					el.setIdCor(res.getInt("ID_COR"));
					el.setIdModelo(res.getInt("ID_MODELO"));
					el.setIdTpAuto(res.getInt("ID_TPAUTO"));
					
					auto.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados dos automóveis.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		return auto;
	}

}
