package br.com.concessionaria.vo;

public class CargoVO {
	private String nomeCargo;
	private int idCargo;
	
	public CargoVO() {
		super();
	}
	
	public CargoVO(String cargo) {
		this.nomeCargo = cargo;
	}
	
	public CargoVO(String cargo, int idCargo) {
		this.nomeCargo = cargo;
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
}
