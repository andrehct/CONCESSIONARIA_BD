<%@page import="br.com.concessionaria.vo.SeguradoraVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%SeguradoraVO seg = (SeguradoraVO)session.getAttribute("seguradora");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Seguradora :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../SeguradoraController" name="formEditar" method="post">
		<input type="hidden" name="idIni" value="<%=seg.getIdSeg()%>">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome" value="<%=seg.getNomeSeguradora()%>">
	          <label>NOME DA SEGURADORA:</label>
	      	</div>
		</div>
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="end" value="<%=seg.getEndereco()%>">
	          <label>ENDEREÇO:</label>
	      	</div>
		</div>
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="tele" value="<%=seg.getTelefone()%>">
	          <label>TELEFONE:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR SEGURADORA">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
		</div>
		</form>
	</div>
</body>
</html>