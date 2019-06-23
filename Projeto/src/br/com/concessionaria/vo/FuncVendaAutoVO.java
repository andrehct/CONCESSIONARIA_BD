package br.com.concessionaria.vo;

public class FuncVendaAutoVO {
	private String funcCPF;
	private String chassi;
	private String dataVenda;
	public FuncVendaAutoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FuncVendaAutoVO(String funcCPF, String chassi, String dataVenda) {
		super();
		this.funcCPF = funcCPF;
		this.chassi = chassi;
		this.dataVenda = dataVenda;
	}
	public String getFuncCPF() {
		return funcCPF;
	}
	public void setFuncCPF(String funcCPF) {
		this.funcCPF = funcCPF;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	

}
