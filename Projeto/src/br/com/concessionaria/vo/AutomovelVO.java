package br.com.concessionaria.vo;

public class AutomovelVO {
	private int idTpAuto;
	private int idModelo;
	private int idMarca;
	private float preco;
	private int idCor;
	private String chassi;
	private String foto;
	public AutomovelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AutomovelVO(int idTpAuto, int idModelo, int idMarca, float preco, int idCor, String chassi) {
		super();
		this.idTpAuto = idTpAuto;
		this.idModelo = idModelo;
		this.idMarca = idMarca;
		this.preco = preco;
		this.idCor = idCor;
		this.chassi = chassi;
	}
	public int getIdTpAuto() {
		return idTpAuto;
	}
	public void setIdTpAuto(int idTpAuto) {
		this.idTpAuto = idTpAuto;
	}
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getIdCor() {
		return idCor;
	}
	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
