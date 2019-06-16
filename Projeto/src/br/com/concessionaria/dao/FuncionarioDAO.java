package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.FuncionarioVO;

public class FuncionarioDAO implements InterfaceDAO<FuncionarioVO>{
	
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = null;
	
	@Override
	public void inserir(FuncionarioVO funcionarioVO) {
		try {
			StringBuilder sql = new StringBuilder();
			//Montando a query sql
				sql.append("INSERT INTO FUNCIONARIO ");
				sql.append("([NUM_CPF],[NOM_FUNCIONARIO],[DES_ENDERECO],");
				sql.append("[DTA_NASCIMENTO],[NUM_RG],");
				sql.append("[DTA_CONTRATACAO],[ID_CARGO],[NUM_NIVEL])");
				sql.append("VALUES (?,?,?,?,?,?,?,?)");
			//Abrindo conexão com o banco
				conn = ConexaoDAO.getConn();
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, funcionarioVO.getCPF());
				stmt.setString(2, funcionarioVO.getNome());
				stmt.setString(3, funcionarioVO.getEndereco());
				stmt.setString(4, funcionarioVO.getDataNascimento());
				//stmt.setString(5, funcionarioVO.getFoto());
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
	public void alterar(FuncionarioVO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuncionarioVO consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
