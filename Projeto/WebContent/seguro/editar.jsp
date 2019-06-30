<%@page import="br.com.concessionaria.vo.SeguroVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%SeguroVO seg = (SeguroVO)session.getAttribute("seguro");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Seguro :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../SeguroController" name="formEditar" method="post">
	<input type="hidden" name="idIni" value="<%=seg.getIdSeguro()%>">
	<table>
		<tr>
		<td>
			<label>NOME DO SEGURO: </label>
			<input type="text" name="nome" value="<%=seg.getNome()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>SEGURADORA: </label>
			<input type="text" name="seguradora" value="<%=seg.getIdSeguradora()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>PREÇO: </label>
			<input type="text" name="preco" value="<%=seg.getPreco()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR SEGURO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>