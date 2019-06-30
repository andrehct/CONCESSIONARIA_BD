package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.SeguroAutomovelVO;

public class SeguroAutomovelDAO implements InterfaceDAO<SeguroAutomovelVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(SeguroAutomovelVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO SEGURO_AUTOMOVEL ");
				sql.append("([NUM_CPF_FUNCIONARIO],[ID_SEGURO],");
				sql.append("[DES_CHASSI],[DTA_CONTRATO]) ");
				sql.append("VALUES (?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, Integer.toString(t.getIdSeguro()));
				stmt.setString(3, t.getChassi());
				stmt.setString(4, t.getDataContrato());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a relaçao Seguro-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(SeguroAutomovelVO t, String... chave) {
		//chave[0] vai ter o cpf do funcionário correto
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE SEGURO_AUTOMOVEL SET ");
				sql.append("[NUM_CPF_FUNCIONARIO] = ?, ");
				sql.append("[DES_CHASSI] = ?, ");
				sql.append("[ID_SEGURO] = ?, ");
				sql.append("[DTA_CONTRATO] = ? ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [DTA_CONTRATO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, t.getChassi());
				stmt.setString(3, Integer.toString(t.getIdSeguro()));
				stmt.setString(4, t.getDataContrato());
				stmt.setString(5, chave[0]);
				stmt.setString(6, chave[1]);
				stmt.setString(7, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da relação Seguro-Automóvel.");
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
				sql.append("DELETE FROM SEGURO_AUTOMOVEL ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [DTA_CONTRATO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir a relação Seguro-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public SeguroAutomovelVO consultar(String... chave) {
		SeguroAutomovelVO segAuto = new SeguroAutomovelVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM SEGURO_AUTOMOVEL ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [DTA_CONTRATO] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando seguro-automovel com os dados obtidos
				segAuto.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
				segAuto.setIdSeguro(res.getInt("ID_SEGURO"));
				segAuto.setChassi(res.getString("DES_CHASSI"));
				segAuto.setDataContrato(res.getString("DTA_CONTRATO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados da relação Seguro-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return segAuto;
	}

	@Override
	public List<SeguroAutomovelVO> listar() {

		List<SeguroAutomovelVO> aux = new ArrayList<SeguroAutomovelVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM SEGURO_AUTOMOVEL");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					SeguroAutomovelVO el = new SeguroAutomovelVO();
					
					el.setChassi(res.getString("DES_CHASSI"));
					el.setIdSeguro(res.getInt("ID_SEGURO"));
					el.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
					el.setDataContrato(res.getDate("DTA_CONTRATO").toString());
					//System.out.println("data " + el.getDataContrato());
					aux.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos dados do seguro automovel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return aux;
	}

}
