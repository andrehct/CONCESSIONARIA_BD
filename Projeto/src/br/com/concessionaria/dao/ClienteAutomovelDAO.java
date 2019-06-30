package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.infra.ConexaoDAO;
import br.com.concessionaria.infra.InterfaceDAO;
import br.com.concessionaria.vo.ClienteAutomovelVO;

public class ClienteAutomovelDAO implements InterfaceDAO<ClienteAutomovelVO>{
	
	private PreparedStatement stmt = null;
	private ResultSet res = null;
	private Connection conn = ConexaoDAO.getConn();
	StringBuilder sql = new StringBuilder();
	

	@Override
	public void inserir(ClienteAutomovelVO t) {
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO CLIENTE_AUTOMOVEL ");
				sql.append("([DES_CHASSI],[NUM_CPF_CLIENTE],");
				sql.append("[DES_PLACA],[DTA_INICIO])");
				sql.append("VALUES (?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getChassi());
				stmt.setString(2, t.getClienteCPF());
				stmt.setString(3, t.getPlaca());
				stmt.setString(4, t.getDataInicio());
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a relaçao Cliente-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(ClienteAutomovelVO cliAuto, String... chave) {
	
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("UPDATE CLIENTE_AUTOMOVEL SET ");
					sql.append("[DES_CHASSI] = ?,");
					sql.append("[NUM_CPF_CLIENTE] = ?,");
					sql.append("[DES_PLACA] = ?,");
					sql.append("[DTA_INICIO] = ? ");
					sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ? AND DTA_INICIO = ?");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, cliAuto.getChassi());
					stmt.setString(2, cliAuto.getClienteCPF());
					stmt.setString(3, cliAuto.getPlaca());
					stmt.setString(4, cliAuto.getDataInicio());
					stmt.setString(5, chave[0]);
					stmt.setString(6, chave[1]);
					stmt.setString(7, chave[2]);
					
				//Executando a query no banco
					stmt.executeUpdate();
				
			}catch(Exception ex) {
				System.out.println("Erro ao tentar alterar os dados da relação Cliente-Automóvel.");
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
				sql.append("DELETE FROM CLIENTE_AUTOMOVEL ");
				sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ? AND DTA_INICIO = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
				stmt.setString(3, chave[2]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir dados da relação Cliente-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public ClienteAutomovelVO consultar(String... chave) {
		ClienteAutomovelVO cliAuto = new ClienteAutomovelVO();
		
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("SELECT * FROM  [CLIENTE_AUTOMOVEL]");
					sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ? AND DTA_INICIO = ?");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, chave[0]);
					stmt.setString(2, chave[1]);
					stmt.setString(3, chave[2]);
				//Executando a query no banco
					res = stmt.executeQuery();
				//Pegando a linha de resultado com o next
					res.next();
				//criando funcionario com os dados obtidos
					cliAuto.setChassi(res.getString("DES_CHASSI"));
					cliAuto.setClienteCPF(res.getString("NUM_CPF_CLIENTE"));
					cliAuto.setPlaca(res.getString("DES_PLACA"));
					cliAuto.setDataInicio(res.getString("DTA_INICIO"));
			}catch(Exception ex) {
				System.out.println("Erro ao tentar selecionar dados da relação Cliente-Automóvel.");
				ex.printStackTrace();
				
			}finally {
				ConexaoDAO.liberaConexao(conn, stmt, res);
			}
		
		
		return cliAuto;
	}

	@Override
	public List<ClienteAutomovelVO> listar() {
		List<ClienteAutomovelVO> aux = new ArrayList<ClienteAutomovelVO>();
		
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("SELECT * FROM CLIENTE_AUTOMOVEL");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
			//Executando a query no banco
				res = stmt.executeQuery();
			//Pegando a linha de resultado com o next
				while(res.next()) {
					ClienteAutomovelVO el = new ClienteAutomovelVO();
					
					el.setChassi(res.getString("DES_CHASSI"));
					el.setClienteCPF(res.getString("NUM_CPF_CLIENTE"));
					el.setPlaca(res.getString("DES_PLACA"));
					el.setDataInicio(res.getString("DTA_INICIO"));
					
					aux.add(el);
					
				}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar selecionar todos dados da relação Cliente-Automóvel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
		
		return aux;
	}

}
