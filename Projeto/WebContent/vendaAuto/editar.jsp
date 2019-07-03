<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncVendaAutoVO"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%FuncVendaAutoVO fav = (FuncVendaAutoVO)session.getAttribute("fva");%>
<%List<AutomovelVO> listaAuto = DAOFactory.createAutomovelDAO().listar(); %>
<%List<FuncionarioVO> listaFunc = DAOFactory.createFuncionarioDAO().listar(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Venda Automóvel :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	    <form class="col s8" action="../FuncVendaAutoController" name="formEditar" method="post">
	      <input type="hidden" name="cpfIni" value="<%=fav.getFuncCPF()%>">
		  <input type="hidden" name="dataIni" value="<%=fav.getDataVenda()%>">
		  <input type="hidden" name="chassiIni" value="<%=fav.getChassi()%>">
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
			          <input placeholder="YYYY-MM-DD" type="text" name="dta" value="<%=fav.getDataVenda().substring(0,10)%>">
			          <label>DATA DA REVISÃO:</label>
			        </div>
			    </div>
		      </div>
	      
	      <div style="margin-left: 40%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
	      </div>
	    </form>
	</div>
</body>



</html>