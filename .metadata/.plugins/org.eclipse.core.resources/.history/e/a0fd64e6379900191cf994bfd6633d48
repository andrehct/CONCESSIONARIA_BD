package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				sql.append("[DES_CHASSI],[DTA_CONTRATO],[ID_SEGURADORA]) ");
				sql.append("VALUES (?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, Integer.toString(t.getIdSeguro()));
				stmt.setString(3, t.getChassi());
				stmt.setString(4, t.getDataContrato());
				stmt.setString(5, Integer.toString(t.getIdSeguradora()));
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
				sql.append("[NUM_CPF_FUNCIONARIO] = ? ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [DTA_CONTRATO] = ? ");
				sql.append("AND [ID_SEGURADORA] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, Integer.toString(t.getIdSeguro()));
				stmt.setString(3, t.getChassi());
				stmt.setString(4, t.getDataContrato());
				stmt.setString(5, Integer.toString(t.getIdSeguradora()));
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
				sql.append("AND [ID_SEGURADORA] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
				stmt.setString(4, chave[3]);
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
				sql.append("SELECT ");
				sql.append("[NUM_CPF_FUNCIONARIO],");
				sql.append("[ID_SEGURO],");
				sql.append("[DES_CHASSI],");
				sql.append("[DTA_CONTRATO],");
				sql.append("[ID_SEGURADORA] FROM SEGURO_AUTOMOVEL ");
				sql.append("WHERE [ID_SEGURO] = ? ");
				sql.append("AND [DES_CHASSI] = ? ");
				sql.append("AND [DTA_CONTRATO] = ? ");
				sql.append("AND [ID_SEGURADORA] = ? ");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
				stmt.setString(4, chave[3]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando seguro-automovel com os dados obtidos
				segAuto.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
				segAuto.setIdSeguro(res.getInt("ID_SEGURO"));
				segAuto.setIdSeguradora(res.getInt("ID_SEGURADORA"));
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
		// TODO Auto-generated method stub
		return null;
	}

}
