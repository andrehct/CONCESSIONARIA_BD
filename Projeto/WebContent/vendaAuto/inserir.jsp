<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncVendaAutoVO"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<AutomovelVO> listaAuto = DAOFactory.createAutomovelDAO().listar(); %>
<%List<FuncionarioVO> listaFunc = DAOFactory.createFuncionarioDAO().listar(); %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Venda Automóvel :::</title>
<%@ include file="../menu.jsp" %>

<body>
		<div class="row" style="margin-top: 50px; margin-left: 25%;">
		    <form class="col s8" action="../FuncVendaAutoController" name="formInserir" method="post">
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
		        	<select class="browser-default" name="chassi">
				      <option value="" disabled selected>CHASSI...</option>
				      <%for(AutomovelVO a : listaAuto){ %>
				      	<option value="<%=a.getChassi()%>"><%=a.getChassi()%></option>
				      <%}%>
				    </select>
		        </div>
		        <div class="row">
		        	<div class="input-field col s6">
			          <input placeholder="YYYY-MM-DD" type="text" name="dta">
			          <label>DATA DA REVISÃO:</label>
			        </div>
			    </div>
		      </div>

		      
		      <div style="margin-left: 40%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR">CADASTRAR
			   		 <i class="material-icons right">send</i>
			    </button>
		      </div>
		    </form>
		  </div>

</body>




</html>