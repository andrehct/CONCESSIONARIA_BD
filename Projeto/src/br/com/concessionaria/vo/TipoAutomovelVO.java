package br.com.concessionaria.vo;

public class TipoAutomovelVO {
	private String nome;
	private int idTPAuto;
	
	public TipoAutomovelVO() {
		super();
	}

	public TipoAutomovelVO(String nome) {
		super();
		this.nome = nome;
	}
	
	public TipoAutomovelVO(String nome, int idTPAuto) {
		super();
		this.nome = nome;
		this.idTPAuto = idTPAuto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdTPAuto() {
		return idTPAuto;
	}

	public void setIdTPAuto(int idTPAuto) {
		this.idTPAuto = idTPAuto;
	}

}
