package br.com.concessionaria.vo;

public class SeguroVO {
	private String chassi;
	private float preco;
	private int idSeguradora;
	private int idSeguro;
	
	public SeguroVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeguroVO(String chassi, float preco, int idSeguradora) {
		super();
		this.chassi = chassi;
		this.preco = preco;
		this.idSeguradora = idSeguradora;
	}
	public SeguroVO(String chassi, float preco, int idSeguradora, int idSeguro) {
		super();
		this.chassi = chassi;
		this.preco = preco;
		this.idSeguradora = idSeguradora;
		this.idSeguro = idSeguro;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getIdSeguradora() {
		return idSeguradora;
	}
	public void setIdSeguradora(int idSeguradora) {
		this.idSeguradora = idSeguradora;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

}
