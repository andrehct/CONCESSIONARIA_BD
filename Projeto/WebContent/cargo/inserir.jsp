<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.CargoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Cargo :::</title>
<%@ include file="../menu.jsp" %>

<body>
<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../CargoController" name="formInserir" method="post">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome">
	          <label>NOME DO CARGO:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR CARGO">CADASTRAR
		   		 <i class="material-icons right">send</i>
		    </button>
	    </div>
	</form>
</div>

</body>


</html>