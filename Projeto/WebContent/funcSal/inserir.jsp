<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioSalarioVO"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncionarioVO> listaFunc = DAOFactory.createFuncionarioDAO().listar(); %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Salário Funcionário :::</title>
<%@ include file="../menu.jsp" %>

<body>
		<div class="row" style="margin-top: 50px; margin-left: 25%;">
		    <form class="col s8" action="../FuncionarioSalarioController" name="formInserir" method="post">
		    	<div class="input-field col s8">
		        	<select class="browser-default" name="cpf">
				      <option value="" disabled selected>FUNCIONARIO...</option>
				      <%for(FuncionarioVO a : listaFunc){ %>
				      	<option value="<%=a.getCPF()%>"><%=a.getNome()%></option>
				      <%}%>
				    </select>
		        </div>
		      <div class="row">
		        <div class="input-field col s6">
			          <input type="text" name="sal" placeholder="00.00">
			          <label>SALÁRIO:</label>
			    </div>
			    <div class="input-field col s6">
			          <input placeholder="YYYY-MM-DD" type="text" name="dtaIni">
			          <label>DATA INICIAL:</label>
			    </div>
		      </div>
		      
		      <div style="margin-left: 40%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR SALARIO">CADASTRAR
			   		 <i class="material-icons right">send</i>
			    </button>
		      </div>
		    </form>
		  </div>

</body>

</html>