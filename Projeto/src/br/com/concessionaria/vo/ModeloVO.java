package br.com.concessionaria.vo;

public class ModeloVO {
	private String nomeModelo;
	private int ano;
	private int idMarca;
	private int idModelo;
	
	public ModeloVO() {
		super();
	}
	
	public ModeloVO(String nomeModelo, int ano, int idMarca) {
		super();
		this.nomeModelo = nomeModelo;
		this.ano = ano;
		this.idMarca = idMarca;
	}
	
	public ModeloVO(String nomeModelo, int ano, int idMarca, int idModelo) {
		super();
		this.nomeModelo = nomeModelo;
		this.ano = ano;
		this.idMarca = idMarca;
		this.idModelo = idModelo;
	}
	
	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
	

}
