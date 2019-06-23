package br.com.concessionaria.factory;

import br.com.concessionaria.dao.AutomovelDAO;
import br.com.concessionaria.dao.CargoDAO;
import br.com.concessionaria.dao.ClienteAutomovelDAO;
import br.com.concessionaria.dao.ClienteDAO;
import br.com.concessionaria.dao.CorDAO;
import br.com.concessionaria.dao.FuncVendaAutoDAO;
import br.com.concessionaria.dao.FuncionarioDAO;
import br.com.concessionaria.dao.FuncionarioSalarioDAO;
import br.com.concessionaria.dao.MarcaDAO;
import br.com.concessionaria.dao.ModeloDAO;
import br.com.concessionaria.dao.RevisaoDAO;
import br.com.concessionaria.dao.SeguradoraDAO;
import br.com.concessionaria.dao.SeguroAutomovelDAO;
import br.com.concessionaria.dao.SeguroDAO;
import br.com.concessionaria.dao.TipoAutomovelDAO;

public class DAOFactory {
	
	public static FuncionarioDAO createFuncionarioDAO() {
		return new FuncionarioDAO();
	}
	
	public static AutomovelDAO createAutomovelDAO() {
		return new AutomovelDAO();
	}
	
	public static CargoDAO createCargoDAO() {
		return new CargoDAO();
	}
	
	public static ClienteAutomovelDAO createClienteAutomovelDAO() {
		return new ClienteAutomovelDAO();
	}
	
	public static ClienteDAO createClienteDAO() {
		return new ClienteDAO();
	}
	
	public static CorDAO createCorDAO() {
		return new CorDAO();
	}
	
	public static FuncionarioSalarioDAO createFuncionarioSalarioDAO() {
		return new FuncionarioSalarioDAO();
	}
	
	public static FuncVendaAutoDAO createFuncVendaAutoDAO() {
		return new FuncVendaAutoDAO();
	}
	
	public static MarcaDAO createMarcaDAO() {
		return new MarcaDAO();
	}
	
	public static ModeloDAO createModeloDAO() {
		return new ModeloDAO();
	}
	
	public static RevisaoDAO createRevisaoDAO() {
		return new RevisaoDAO();
	}
	
	public static SeguradoraDAO createSeguradoraDAO() {
		return new SeguradoraDAO();
	}
	
	public static SeguroAutomovelDAO createSeguroAutomovelDAO() {
		return new SeguroAutomovelDAO();
	}
	
	public static SeguroDAO createSeguroDAO() {
		return new SeguroDAO();
	}
	
	public static TipoAutomovelDAO createTipoAutomovelDAO() {
		return new TipoAutomovelDAO();
	}
}
