package br.com.concessionaria.vo;

public class CorVO {
	private String nomeCor;
	private int idCor;
	
	public CorVO() {
		super();
	}
	
	public CorVO(String nomeCor) {
		super();
		this.nomeCor = nomeCor;
	}
	
	public CorVO(String nomeCor, int idCor) {
		super();
		this.nomeCor = nomeCor;
		this.idCor = idCor;
	}

	public String getNomeCor() {
		return nomeCor;
	}

	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}

	public int getIdCor() {
		return idCor;
	}

	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}
}
