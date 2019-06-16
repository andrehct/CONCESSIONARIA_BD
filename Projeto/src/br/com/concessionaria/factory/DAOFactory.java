package br.com.concessionaria.factory;

import br.com.concessionaria.dao.FuncionarioDAO;

public class DAOFactory {
	
	public static FuncionarioDAO createFuncionarioDAO() {
		return new FuncionarioDAO();
	}

}
