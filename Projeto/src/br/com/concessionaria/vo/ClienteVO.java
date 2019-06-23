package br.com.concessionaria.vo;

public class ClienteVO {
	private String cpf;
	private String nome;
	private String endereco;
	private String dataNascimento;
	private String foto;
	private String rg;
	
	public ClienteVO() {
		super();
	}
	
	public ClienteVO(String cpf, String nome, String endereco, String dataNascimento, String rg) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	

}
