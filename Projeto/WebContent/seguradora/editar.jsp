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
<form action="../SeguradoraController" name="formEditar" method="post">
	<input type="hidden" name="idIni" value="<%=seg.getIdSeg()%>">
	<table>
		<tr>
		<td>
			<label>NOME DA SEGURADORA: </label>
			<input type="text" name="nome" value="<%=seg.getNomeSeguradora()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>ENDEREÇO: </label>
			<input type="text" name="end" value="<%=seg.getEndereco()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>TELEFONE: </label>
			<input type="text" name="tele" value="<%=seg.getTelefone()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR SEGURADORA"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>