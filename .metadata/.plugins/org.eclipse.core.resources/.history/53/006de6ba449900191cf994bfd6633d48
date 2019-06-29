package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.ClienteVO;

public class ClienteDAO implements InterfaceDAO<ClienteVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();

	@Override
	public void inserir(ClienteVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO CLIENTE ");
				sql.append("([NUM_CPF],[NOM_CLIENTE],[DES_ENDERECO],");
				sql.append("[DTA_NASCIMENTO],[NUM_RG]) ");
				sql.append("VALUES (?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getCpf());
				stmt.setString(2, t.getNome());
				stmt.setString(3, t.getEndereco());
				stmt.setString(4, t.getDataNascimento());
				stmt.setString(5, t.getRg());
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir o cliente.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(ClienteVO t, String... CPF) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("UPDATE CLIENTE SET ");
				sql.append("[NUM_CPF] = ?,");
				sql.append("[NOM_CLIENTE] = ?,");
				sql.append("[DES_ENDERECO] = ?,");
				sql.append("[DTA_NASCIMENTO] = ?,");
				sql.append("[NUM_RG] = ? ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getCpf());
				stmt.setString(2, t.getNome());
				stmt.setString(3, t.getEndereco());
				stmt.setString(4, t.getDataNascimento());
				stmt.setString(5, t.getRg());
				stmt.setString(9, CPF[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar alterar os dados do cliente.");
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
				sql.append("DELETE FROM CLIENTE ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, CPF[0]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir o cliente.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public ClienteVO consultar(String... CPF) {
		ClienteVO cli = new ClienteVO();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT ");
				sql.append("[NUM_CPF],");
				sql.append("[NOM_CLIENTE],");
				sql.append("[DES_ENDERECO],");
				sql.append("[DTA_NASCIMENTO],");
				sql.append("[NUM_RG] FROM FUNCIONARIO ");
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, CPF[0]);
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				res.next();
			//criando cliente com os dados obtidos
				cli.setCpf(res.getString("NUM_CPF"));
				cli.setNome(res.getString("NOM_CLIENTE"));
				cli.setDataNascimento(res.getString("DTA_NASCIMENTO"));
				cli.setEndereco(res.getString("DES_ENDERECO"));
				cli.setRg(res.getString("NUM_RG"));
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados do cliente.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cli;
	}

	@Override
	public List<ClienteVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
