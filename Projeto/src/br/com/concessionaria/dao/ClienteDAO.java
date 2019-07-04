package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
				sql.append("[DTA_NASCIMENTO],[NUM_RG],[ARQ_FOTO]) ");
				sql.append("VALUES (?,?,?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getCpf());
				stmt.setString(2, t.getNome());
				stmt.setString(3, t.getEndereco());
				stmt.setString(4, t.getDataNascimento()+"T00:00:00.0");
				stmt.setString(5, t.getRg());
				stmt.setBytes(6, t.getFoto());
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
				if(t.getFoto() != null)
				{
					sql.append(",[ARQ_FOTO] = ? ");
				}
				sql.append("WHERE [NUM_CPF] = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getCpf());
				stmt.setString(2, t.getNome());
				stmt.setString(3, t.getEndereco());
				stmt.setString(4, t.getDataNascimento()+"T00:00:00.0");
				stmt.setString(5, t.getRg());
				if(t.getFoto() != null)
				{
					stmt.setBytes(6, t.getFoto());
					stmt.setString(7, CPF[0]);
				}
				else
				{
					stmt.setString(6, CPF[0]);
				}
				
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
				sql.append("[NUM_RG], [ARQ_FOTO] FROM CLIENTE ");
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
				cli.setFoto(res.getBytes("ARQ_FOTO"));
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
		List<ClienteVO> cli = new ArrayList<ClienteVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM CLIENTE");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					ClienteVO el = new ClienteVO();
					
					el.setCpf(res.getString("NUM_CPF"));
					el.setNome(res.getString("NOM_CLIENTE"));
					el.setEndereco(res.getString("DES_ENDERECO"));
					el.setRg(res.getString("NUM_RG"));
					String abc = res.getString("DTA_NASCIMENTO").substring(0,10);
					String def = res.getString("DTA_NASCIMENTO").substring(10,res.getString("DTA_NASCIMENTO").length());
					el.setDataNascimento(abc.concat("T").concat(def).replace(" ", ""));
					el.setFoto(res.getBytes("ARQ_FOTO")); 
					
					cli.add(el);
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar dados dos clientes.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		return cli;
	}

}
