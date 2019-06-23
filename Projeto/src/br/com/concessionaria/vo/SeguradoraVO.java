package br.com.concessionaria.vo;

public class SeguradoraVO {
	private String nomeSeguradora;
	private String endereco;
	private String telefone;
	private int idSeg;
	
	public SeguradoraVO() {
		super();
	}
	
	public SeguradoraVO(String nomeSeguradora, String endereco, String telefone) {
		super();
		this.nomeSeguradora = nomeSeguradora;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public SeguradoraVO(String nomeSeguradora, String endereco, String telefone, int idSeg) {
		super();
		this.nomeSeguradora = nomeSeguradora;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idSeg = idSeg;
	}
	
	public String getNomeSeguradora() {
		return nomeSeguradora;
	}
	public void setNomeSeguradora(String nomeSeguradora) {
		this.nomeSeguradora = nomeSeguradora;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdSeg() {
		return idSeg;
	}

	public void setIdSeg(int idSeg) {
		this.idSeg = idSeg;
	}
	
	

}
