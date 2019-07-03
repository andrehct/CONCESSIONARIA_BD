<%@page import="br.com.concessionaria.vo.CorVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%CorVO cor = (CorVO)session.getAttribute("cor");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Cor :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../CorController" name="formEditar" method="post">
		<input type="hidden" name="idIni" value="<%=cor.getIdCor()%>">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome" value="<%=cor.getNomeCor()%>">
	          <label>NOME DA COR:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR COR">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
		</div>
		</form>
	</div>
</body>
</html>