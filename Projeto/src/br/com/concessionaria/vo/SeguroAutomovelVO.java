package br.com.concessionaria.vo;

public class SeguroAutomovelVO {
	private String chassi;
	private int idSeguro;
	private String dataContrato;
	private String funcCPF;
	public SeguroAutomovelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeguroAutomovelVO(String chassi, int idSeguro, String dataContrato, String funcCPF) {
		super();
		this.chassi = chassi;
		this.idSeguro = idSeguro;
		this.dataContrato = dataContrato;
		this.funcCPF = funcCPF;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(String dataContrato) {
		this.dataContrato = dataContrato;
	}
	public String getFuncCPF() {
		return funcCPF;
	}
	public void setFuncCPF(String funcCPF) {
		this.funcCPF = funcCPF;
	}
	

}
