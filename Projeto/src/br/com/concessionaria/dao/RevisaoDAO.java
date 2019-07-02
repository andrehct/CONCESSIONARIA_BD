package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.RevisaoVO;

public class RevisaoDAO implements InterfaceDAO<RevisaoVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(RevisaoVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO REVISAO ");
				sql.append("([NUM_CPF_FUNCIONARIO],[DES_CHASSI],[DTA_REVISAO],");
				sql.append("[B_ACEITE],[DES_PLACA],[VAL_PRECO]) ");
				sql.append("VALUES (?,?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, t.getChassi());
				stmt.setString(3, t.getDataRev()+"T00:00:00.0");
				stmt.setString(4, Boolean.toString(t.getAceite()));
				stmt.setString(5, t.getPlaca());
				stmt.setString(6, Float.toString(t.getPreco()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir os dados da revisão.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(RevisaoVO t, String... chave) {
		
		//chave[0] = cpf
		//chave[1] = chassi
		//chave[2] = data revisão
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE REVISAO SET ");
				sql.append("[NUM_CPF_FUNCIONARIO] = ?,");
				sql.append("[DES_CHASSI] = ?,");
				sql.append("[DTA_REVISAO] = ?,");
				sql.append("[B_ACEITE] = ?,");
				sql.append("[DES_PLACA] = ?,");
				sql.append("[VAL_PRECO] = ? ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DES_CHASSI] = ? AND [DTA_REVISAO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, t.getChassi());
				stmt.setString(3, t.getDataRev()+"T00:00:00.0");
				stmt.setString(4, Boolean.toString(t.getAceite()));
				stmt.setString(5, t.getPlaca());
				stmt.setString(6, Float.toString(t.getPreco()));
				stmt.setString(7, chave[0]);
				stmt.setString(8, chave[1]);
				stmt.setString(9, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da revisão.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void excluir(String... chave) {
		
		//chave[0] = cpf
		//chave[1] = chassi
		//chave[2] = data revisão
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM REVISAO ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DES_CHASSI] = ? AND [DTA_REVISAO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir os dados da revisão.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public RevisaoVO consultar(String... chave) {
		
		//chave[0] = cpf
		//chave[1] = chassi
		//chave[2] = data revisão
		
		RevisaoVO revisao = new RevisaoVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM REVISAO ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DES_CHASSI] = ? AND [DTA_REVISAO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando revisão com os dados obtidos
				revisao.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
				revisao.setChassi(res.getString("DES_CHASSI"));
				revisao.setAceite(res.getBoolean("B_ACEITE"));
				revisao.setDataRev(res.getString("DTA_REVISAO"));
				revisao.setPlaca(res.getString("DES_PLACA"));
				revisao.setPreco(res.getFloat("VAL_PRECO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados da revisão.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return revisao;
	}

	@Override
	public List<RevisaoVO> listar() {
		List<RevisaoVO> revisao = new ArrayList<RevisaoVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM REVISAO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					RevisaoVO el = new RevisaoVO();
					
					el.setAceite(res.getBoolean("B_ACEITE"));
					el.setChassi(res.getString("DES_CHASSI"));
					el.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
					el.setPlaca(res.getString("DES_PLACA"));
					el.setPreco(res.getFloat("VAL_PRECO"));
					String abc = res.getString("DTA_REVISAO").substring(0,10);
					String def = res.getString("DTA_REVISAO").substring(10,res.getString("DTA_REVISAO").length());
					el.setDataRev(abc.concat("T").concat(def).replace(" ", ""));
					
					revisao.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos dados da revisão.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return revisao;
	}

}
