package br.com.concessionaria.vo;

public class MarcaVO {
	private String nomeMarca;
	private int idMarca;
	
	public MarcaVO() {
		super();
	}

	public MarcaVO(String nomeMarca) {
		super();
		this.nomeMarca = nomeMarca;
	}
	
	public MarcaVO(String nomeMarca, int idMarca) {
		super();
		this.nomeMarca = nomeMarca;
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	

}
