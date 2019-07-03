<%@page import="br.com.concessionaria.vo.CargoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%CargoVO car = (CargoVO)session.getAttribute("cargo");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Cargo :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../CargoController" name="formEditar" method="post">
		<input type="hidden" name="idIni" value="<%=car.getIdCargo()%>">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome" value="<%=car.getNomeCargo()%>">
	          <label>NOME DO CARGO:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR CARGO">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
		</div>
		</form>
	</div>
</body>
</html>