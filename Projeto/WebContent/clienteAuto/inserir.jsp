<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ClienteAutomovelVO"%>
<%@page import="br.com.concessionaria.vo.ClienteVO"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<AutomovelVO> listaAuto = DAOFactory.createAutomovelDAO().listar();%>
<%List<ClienteVO> listaCliente = DAOFactory.createClienteDAO().listar(); %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Automóvel Cliente :::</title>
<%@ include file="../menu.jsp" %>

<body>
		<div class="row" style="margin-top: 50px; margin-left: 25%;">
		    <form class="col s8" action="../ClienteAutomovelController" name="formInserir" method="post">
		      <div class="row">
		        <div class="input-field col s6">
		        	<select class="browser-default" name="chassi">
				      <option value="" disabled selected>CHASSI...</option>
				      <%for(AutomovelVO a : listaAuto){ %>
				      	<option value="<%=a.getChassi()%>"><%=a.getChassi()%></option>
				      <%}%>
				    </select>
		        </div>
		        <div class="input-field col s6">
		        	<select class="browser-default" name="cpf">
				      <option value="" disabled selected>CLIENTE...</option>
				      <%for(ClienteVO cli : listaCliente){ %>
				      	<option value="<%=cli.getCpf()%>"><%=cli.getNome()%></option>
				      <%}%>
				    </select>
		        </div>
		      </div>
		      <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="placa">
		          <label>PLACA:</label>
		        </div>
		      </div>
		      <div class="row">
		        <div class="input-field col s12">
		          <input placeholder="YYYY-MM-DD" type="text" name="dtaIni">
		          <label>DATA INICIAL:</label>
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