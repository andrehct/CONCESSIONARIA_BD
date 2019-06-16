package br.com.concessionaria.vo;

public class FuncionarioVO {
	private String cpf;
	private String nome;
	private String endereco;
	private String dataNascimento;
	private String foto;
	private String rg;
	private String dataContratacao;
	private int idCargo;
	private int nivel;
	
	public FuncionarioVO() {
		super();
	}


	public FuncionarioVO(String CPF, String name, String endereco, String dta_nasc, String RG, String dta_contr, int id_cargo, int nivel) {
		super();
		this.cpf = CPF;
		this.nome = name;
		this.endereco = endereco;
		this.dataNascimento = dta_nasc;
		this.rg = RG;
		this.dataContratacao = dta_contr;
		this.idCargo = id_cargo;
		this.nivel = nivel;
	}


	public String getCPF() {
		return cpf;
	}


	public void setCPF(String CPF) {
		this.cpf = CPF;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String name) {
		this.nome = name;
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


	public String getDataContratacao() {
		return dataContratacao;
	}


	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}


	public int getIdCargo() {
		return idCargo;
	}


	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	
	
}
