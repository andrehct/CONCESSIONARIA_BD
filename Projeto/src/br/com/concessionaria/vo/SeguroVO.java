package br.com.concessionaria.vo;

public class SeguroVO {
	private float preco;
	private String nome;
	private int idSeguradora;
	private int idSeguro;
	
	public SeguroVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeguroVO(String nome, float preco, int idSeguradora) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.idSeguradora = idSeguradora;
	}
	public SeguroVO(String nome, float preco, int idSeguradora, int idSeguro) {
		super();
		this.preco = preco;
		this.setNome(nome);
		this.idSeguradora = idSeguradora;
		this.idSeguro = idSeguro;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
