package br.com.concessionaria.infra;

import java.util.List;

public interface InterfaceDAO<T> {
	
	void inserir(T t);
	
	void alterar(T t);
	
	void excluir(int id);
	
	T consultar(int id);
	
	List<T> listar();

}
