<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguroAutomovelVO"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="br.com.concessionaria.vo.SeguroVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<FuncionarioVO> listaFunc = DAOFactory.createFuncionarioDAO().listar();%>
<%List<AutomovelVO> listaAuto = DAOFactory.createAutomovelDAO().listar();%>
<%List<SeguroVO> listaSeg = DAOFactory.createSeguroDAO().listar();%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Seguro para Automóvel:::</title>
<%@ include file="../menu.jsp" %>

<body>
		<div class="row" style="margin-top: 50px; margin-left: 25%;">
		    <form class="col s8" action="../SeguroAutomovelController" name="formInserir" method="post">
		      <div class="row">
		        <div class="input-field col s6">
		        	<select class="browser-default" name="cpf">
				      <option value="" disabled selected>FUNCIONARIO...</option>
				      <%for(FuncionarioVO t : listaFunc){ %>
				      	<option value="<%=t.getCPF()%>"><%=t.getNome()%></option>
				      <%}%>
				    </select>
		        </div>
		        <div class="input-field col s6">
		        	<select class="browser-default" name="chassi">
				      <option value="" disabled selected>CHASSI...</option>
				      <%for(AutomovelVO t : listaAuto){ %>
				      	<option value="<%=t.getChassi()%>"><%=t.getChassi()%></option>
				      <%}%>
				    </select>
		        </div>
		      </div>
		      <div class="row">
		      		<div class="input-field col s6">
			        	<select class="browser-default" name="seguro">
					      <option value="" disabled selected>SEGURO...</option>
					      <%for(SeguroVO t : listaSeg){ %>
					      	<option value="<%=t.getIdSeguro()%>"><%=t.getNome()%></option>
					      <%}%>
					    </select>
			        </div>
			        <div class="input-field col s6">
			          <input type="text" placeholder="YYYY-MM-DD" name="dta">
			          <label>DATA DE CONTRATAÇÃO:</label>
			        </div>
			    </div>
		      </div>
		      
		      
		      <div style="margin-left: 45%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR SEGURO AUTOMOVEL">CADASTRAR
			   		 <i class="material-icons right">send</i>
			    </button>
		      </div>
		    </form>
		  </div>

</body>

</html>