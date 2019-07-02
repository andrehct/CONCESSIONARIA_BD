package br.com.concessionaria.vo;

import java.io.Serializable;

public class FuncionarioSalarioVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String funcCPF = "";
	private float salario = 0;
	private String dataIni;
	
	public FuncionarioSalarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FuncionarioSalarioVO(String funcCPF, float salario, String dataIni) {
		super();
		this.funcCPF = funcCPF;
		this.salario = salario;
		this.dataIni = dataIni;
	}
	public String getFuncCPF() {
		return funcCPF;
	}
	public void setFuncCPF(String funcCPF) {
		this.funcCPF = funcCPF;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getDataIni() {
		return dataIni;
	}
	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}
	
	

}
