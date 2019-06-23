package br.com.concessionaria.infra;

import java.util.List;

public interface InterfaceDAO<T> {
	
	void inserir(T t);
	
	void alterar(T t, String... chave);
	
	void excluir(String... chave);
	
	T consultar(String... chave);
	
	List<T> listar();

}
