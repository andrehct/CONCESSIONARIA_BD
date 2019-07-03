<%@page import="br.com.concessionaria.vo.MarcaVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%MarcaVO marca = (MarcaVO)session.getAttribute("marca");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Marca :::</title>
<%@ include file="../menu.jsp" %>

</head>

<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../MarcaController" name="formEditar" method="post">
		<input type="hidden" name="marcaIni" value="<%=marca.getIdMarca()%>">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome" value="<%=marca.getNomeMarca()%>">
	          <label>NOME DA MARCA:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR MARCA">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
		</div>
		</form>
	</div>
</body>


</html>