package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.FuncionarioSalarioVO;

public class FuncionarioSalarioDAO implements InterfaceDAO<FuncionarioSalarioVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	
	@Override
	public void inserir(FuncionarioSalarioVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO FUNCIONARIO_SALARIO ");
				sql.append("([NUM_CPF_FUNCIONARIO],[VAL_SALARIO],[DTA_INICIO]) ");
				sql.append("VALUES (?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getFuncCPF());
				stmt.setString(2, Float.toString(t.getSalario()));
				stmt.setString(3, t.getDataIni()+"T00:00:00.0");
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a rela��o funcion�rio-sal�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(FuncionarioSalarioVO t, String... chave) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE FUNCIONARIO_SALARIO SET ");
				sql.append("[VAL_SALARIO] = ?, ");
				sql.append("[NUM_CPF_FUNCIONARIO] = ?, ");
				sql.append("[DTA_INICIO] = ? ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DTA_INICIO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setFloat(1, t.getSalario());
				stmt.setString(2, t.getFuncCPF());
				stmt.setString(3, t.getDataIni()+"T00:00:00.0");
				stmt.setString(4, chave[0]);
				stmt.setString(5, chave[1]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados da rela��o funcion�rio-sal�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void excluir(String... chave) {
		
		//chave[0] = cpf
		//chave[1] = data
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM FUNCIONARIO_SALARIO ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DTA_INICIO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir a rela��o funcion�rio-sal�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public FuncionarioSalarioVO consultar(String... chave) {
		
		//chave[0] = cpf
		//chave[1] = data
		
		FuncionarioSalarioVO funcSal = new FuncionarioSalarioVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("[NUM_CPF_FUNCIONARIO],");
				sql.append("[VAL_SALARIO],");
				sql.append("[DTA_INICIO] FROM FUNCIONARIO_SALARIO ");
				sql.append("WHERE [NUM_CPF_FUNCIONARIO] = ? AND [DTA_INICIO] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando funcionario com os dados obtidos
				funcSal.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
				funcSal.setSalario(res.getFloat("VAL_SALARIO"));
				funcSal.setDataIni(res.getString("DTA_INICIO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados da rela��o funcion�rio-sal�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return funcSal;
	}

	@Override
	public List<FuncionarioSalarioVO> listar() {
		List<FuncionarioSalarioVO> funcSal = new ArrayList<FuncionarioSalarioVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM FUNCIONARIO_SALARIO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					FuncionarioSalarioVO el = new FuncionarioSalarioVO();
					
					el.setFuncCPF(res.getString("NUM_CPF_FUNCIONARIO"));
					el.setSalario(res.getFloat("VAL_SALARIO"));
					String abc = res.getString("DTA_INICIO").substring(0,10);
					String def = res.getString("DTA_INICIO").substring(10,res.getString("DTA_INICIO").length());
					el.setDataIni(abc.concat("T").concat(def).replace(" ", ""));
					
					funcSal.add(el);
					
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos os dados da rela��o funcion�rio-sal�rio.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return funcSal;
	}

}