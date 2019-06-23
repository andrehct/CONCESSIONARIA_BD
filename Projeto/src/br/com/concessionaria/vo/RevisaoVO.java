package br.com.concessionaria.vo;

public class RevisaoVO {
	private String chassi;
	private String funcCPF;
	private String dataRev;
	private boolean aceite;
	private String placa;
	private float preco;
	public RevisaoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RevisaoVO(String chassi, String funcCPF, String dataRev, boolean aceite, String placa, float preco) {
		super();
		this.chassi = chassi;
		this.funcCPF = funcCPF;
		this.dataRev = dataRev;
		this.aceite = aceite;
		this.placa = placa;
		this.preco = preco;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getFuncCPF() {
		return funcCPF;
	}
	public void setFuncCPF(String funcCPF) {
		this.funcCPF = funcCPF;
	}
	public String getDataRev() {
		return dataRev;
	}
	public void setDataRev(String dataRev) {
		this.dataRev = dataRev;
	}
	public boolean getAceite() {
		return aceite;
	}
	public void setAceite(boolean aceite) {
		this.aceite = aceite;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	

}
