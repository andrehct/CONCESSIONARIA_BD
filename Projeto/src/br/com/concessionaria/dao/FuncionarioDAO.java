package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.FuncionarioVO;

public class FuncionarioDAO implements InterfaceDAO<FuncionarioVO>{
	
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	
	@Override
	public void inserir(FuncionarioVO funcionarioVO) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO FUNCIONARIO ");
				sql.append("([NUM_CPF],[NOM_FUNCIONARIO],[DES_ENDERECO],");
				sql.append("[DTA_NASCIMENTO],[NUM_RG],");
				sql.append("[DTA_CONTRATACAO],[ID_CARGO],[NUM_NIVEL])");
				sql.append("VALUES (?,?,?,?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, funcionarioVO.getCPF());
				stmt.setString(2, funcionarioVO.getNome());
				stmt.setString(3, funcionarioVO.getEndereco());
				stmt.setString(4, funcionarioVO.getDataNascimento());
				stmt.setString(5, funcionarioVO.getRg());
				stmt.setString(6, funcionarioVO.getDataContratacao());
				stmt.setString(7, Integer.toString(funcionarioVO.getIdCargo()));
				stmt.setString(8, Integer.toString(funcionarioVO.getNivel()));
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o funcionário.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(FuncionarioVO funcionarioVO, String... CPF) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE FUNCIONARIO SET ");
				sql.append("[NUM_CPF] = ?,");
				sql.append("[NOM_FUNCIONARIO] = ?,");
				sql.append("[DES_ENDERECO] = ?,");
				sql.append("[DTA_NASCIMENTO] = ?,");
				sql.append("[NUM_RG] = ?,");
				sql.append("[DTA_CONTRATACAO] = ?,");
				sql.append("[ID_CARGO] = ?,");
				sql.append("[NUM_NIVEL] = ? ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, funcionarioVO.getCPF());
				stmt.setString(2, funcionarioVO.getNome());
				stmt.setString(3, funcionarioVO.getEndereco());
				stmt.setString(4, funcionarioVO.getDataNascimento());
				stmt.setString(5, funcionarioVO.getRg());
				stmt.setString(6, funcionarioVO.getDataContratacao());
				stmt.setString(7, Integer.toString(funcionarioVO.getIdCargo()));
				stmt.setString(8, Integer.toString(funcionarioVO.getNivel()));
				stmt.setString(9, CPF[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do funcionário.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void excluir(String... CPF) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM FUNCIONARIO ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, CPF[0]);
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
	public FuncionarioVO consultar(String... CPF) {
		FuncionarioVO func = new FuncionarioVO();
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * ");
				sql.append("FROM FUNCIONARIO ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, CPF[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando funcionario com os dados obtidos
				func.setCPF(res.getString("NUM_CPF"));
				func.setNome(res.getString("NOM_FUNCIONARIO"));
				func.setDataContratacao(res.getString("DTA_CONTRATACAO"));
				func.setDataNascimento(res.getString("DTA_NASCIMENTO"));
				func.setEndereco(res.getString("DES_ENDERECO"));
				func.setIdCargo(res.getInt("ID_CARGO"));
				func.setNivel(res.getInt("NUM_NIVEL"));
				func.setRg(res.getString("NUM_RG"));
				func.setFoto(res.getString("ARQ_FOTO"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do funcionário.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return func;
	}

	@Override
	public List<FuncionarioVO> listar() {
		List<FuncionarioVO> func = new ArrayList<FuncionarioVO>();
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM FUNCIONARIO");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					FuncionarioVO el = new FuncionarioVO();
					
					el.setCPF(res.getString("NUM_CPF"));
					el.setNome(res.getString("NOM_FUNCIONARIO"));
					el.setDataContratacao(res.getString("DTA_CONTRATACAO"));
					el.setDataNascimento(res.getString("DTA_NASCIMENTO"));
					el.setEndereco(res.getString("DES_ENDERECO"));
					el.setIdCargo(res.getInt("ID_CARGO"));
					el.setNivel(res.getInt("NUM_NIVEL"));
					el.setRg(res.getString("NUM_RG"));
					
					func.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do funcionário.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return func;
	}

}
