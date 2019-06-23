package br.com.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.concessionaria.factory.DAOFactory;
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
			//Checar se o chassi j� existe no banco e definir a data fim para o registro
				ClienteAutomovelVO aux = DAOFactory.createClienteAutomovelDAO().consultar(t.getChassi());
				if(aux != null) {
					//Vou passar o par�metro "att" para que a fun��o de alterar trate
					DAOFactory.createClienteAutomovelDAO().alterar(aux, aux.getChassi(), aux.getClienteCPF(), "att");
				}
			//Montando a query sql
				sql.setLength(0);
				sql.append("INSERT INTO CLIENTE_AUTOMOVEL ");
				sql.append("([DES_CHASSI],[NUM_CPF_CLIENTE],");
				sql.append("[DES_PLACA],[DTA_FIM])");
				sql.append("VALUES (?,?,?,?)");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, t.getChassi());
				stmt.setString(2, t.getClienteCPF());
				stmt.setString(3, t.getPlaca());
				stmt.setString(4, t.getDataFim());
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar inserir a rela�ao Cliente-Autom�vel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public void alterar(ClienteAutomovelVO cliAuto, String... chave) {
		
		//chave[0] = chassi
		//chave[1] = CPF cliente
		//Se houver chave[2] devemos definir a data final do registro. Por isso pode-se passar qualquer string
		if(chave.length == 2) {
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("UPDATE CLIENTE_AUTOMOVEL SET ");
					sql.append("[DES_CHASSI] = ?,");
					sql.append("[NUM_CPF_CLIENTE] = ?,");
					sql.append("[DES_PLACA] = ?,");
					sql.append("[DTA_FIM] = ? ");
					sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ?");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, cliAuto.getChassi());
					stmt.setString(2, cliAuto.getClienteCPF());
					stmt.setString(3, cliAuto.getPlaca());
					stmt.setString(4, cliAuto.getDataFim());
					stmt.setString(5, chave[0]);
					stmt.setString(6, chave[1]);
					
				//Executando a query no banco
					stmt.executeUpdate();
				
			}catch(Exception ex) {
				System.out.println("Erro ao tentar alterar os dados da rela��o Cliente-Autom�vel.");
				ex.printStackTrace();
				
			}finally {
				ConexaoDAO.liberaConexao(conn, stmt, res);
			}
		}
		else {
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("UPDATE CLIENTE_AUTOMOVEL SET ");
					sql.append("[DES_CHASSI] = ?,");
					sql.append("[NUM_CPF_CLIENTE] = ?,");
					sql.append("[DES_PLACA] = ?,");
					sql.append("[DTA_FIM] = GETDATE() ");
					sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ?");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, cliAuto.getChassi());
					stmt.setString(2, cliAuto.getClienteCPF());
					stmt.setString(3, cliAuto.getPlaca());
					stmt.setString(4, chave[0]);
					stmt.setString(5, chave[1]);
					
				//Executando a query no banco
					stmt.executeUpdate();
				
			}catch(Exception ex) {
				System.out.println("Erro ao tentar alterar os dados da rela��o Cliente-Autom�vel.");
				ex.printStackTrace();
				
			}finally {
				ConexaoDAO.liberaConexao(conn, stmt, res);
			}
		}
		
	}

	@Override
	public void excluir(String... chave) {
		
		//chave[0] = chassi
		//chave[1] = CPF cliente
		try {
			//Montando a query sql
				sql.setLength(0);
				sql.append("DELETE FROM CLIENTE_AUTOMOVEL ");
				sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ?");
			//Montando o statement para o banco
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, chave[0]);
				stmt.setString(2, chave[1]);
			//Executando a query no banco
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println("Erro ao tentar excluir dados da rela��o Cliente-Autom�vel.");
			ex.printStackTrace();
			
		}finally {
			ConexaoDAO.liberaConexao(conn, stmt, res);
		}
		
	}

	@Override
	public ClienteAutomovelVO consultar(String... chave) {
		
		//chave[0] = chassi
		//chave[1] = CPF cliente
		ClienteAutomovelVO cliAuto = new ClienteAutomovelVO();
		
		if(chave.length == 2) {
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("SELECT ");
					sql.append("[DES_CHASSI],");
					sql.append("[NUM_CPF_CLIENTE],");
					sql.append("[DES_PLACA],");
					sql.append("[DTA_FIM] ");
					sql.append("FROM  [CLIENTE_AUTOMOVEL]");
					sql.append("WHERE DES_CHASSI = ? AND NUM_CPF_CLIENTE = ?");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, chave[0]);
					stmt.setString(2, chave[1]);
				//Executando a query no banco
					res = stmt.executeQuery();
				//Pegando a linha de resultado com o next
					res.next();
				//criando funcionario com os dados obtidos
					cliAuto.setChassi(res.getString("DES_CHASSI"));
					cliAuto.setClienteCPF(res.getString("NUM_CPF_CLIENTE"));
					cliAuto.setPlaca(res.getString("DES_PLACA"));
					cliAuto.setDataFim(res.getString("DTA_FIM"));
			}catch(Exception ex) {
				System.out.println("Erro ao tentar selecionar dados da rela��o Cliente-Autom�vel.");
				ex.printStackTrace();
				
			}finally {
				ConexaoDAO.liberaConexao(conn, stmt, res);
			}
		}
		else {
			try {
				//Montando a query sql
					sql.setLength(0);
					sql.append("SELECT ");
					sql.append("[DES_CHASSI],");
					sql.append("[NUM_CPF_CLIENTE],");
					sql.append("[DES_PLACA],");
					sql.append("[DTA_FIM] ");
					sql.append("FROM  [CLIENTE_AUTOMOVEL]");
					sql.append("WHERE DES_CHASSI = ? AND DTA_FIM IS NULL");
				//Montando o statement para o banco
					stmt = conn.prepareStatement(sql.toString());
					stmt.setString(1, chave[0]);
				//Executando a query no banco
					res = stmt.executeQuery();
				//Pegando a linha de resultado com o next
					res.next();
				//criando funcionario com os dados obtidos
					cliAuto.setChassi(res.getString("DES_CHASSI"));
					cliAuto.setClienteCPF(res.getString("NUM_CPF_CLIENTE"));
					cliAuto.setPlaca(res.getString("DES_PLACA"));
					cliAuto.setDataFim(res.getString("DTA_FIM"));
			}catch(Exception ex) {
				System.out.println("Erro ao tentar selecionar dados da rela��o Cliente-Autom�vel.");
				ex.printStackTrace();
				
			}finally {
				ConexaoDAO.liberaConexao(conn, stmt, res);
			}
		}
		
		return cliAuto;
	}

	@Override
	public List<ClienteAutomovelVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
