package br.com.concessionaria.vo;

public class ClienteAutomovelVO {
	private String chassi;
	private String clienteCPF;
	private String placa;
	private String dataFim;
	public ClienteAutomovelVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteAutomovelVO(String chassi, String clienteCPF, String placa) {
		super();
		this.chassi = chassi;
		this.clienteCPF = clienteCPF;
		this.placa = placa;
	}
	public ClienteAutomovelVO(String chassi, String clienteCPF) {
		super();
		this.chassi = chassi;
		this.clienteCPF = clienteCPF;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getClienteCPF() {
		return clienteCPF;
	}
	public void setDataFim(String dtFim) {
		this.dataFim = dtFim;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
