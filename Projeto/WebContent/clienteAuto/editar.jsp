<%@page import="br.com.concessionaria.vo.ClienteAutomovelVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%ClienteAutomovelVO cliAuto = (ClienteAutomovelVO)session.getAttribute("cliAuto");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Automóvel do Cliente :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../ClienteAutomovelController" name="formEditar" method="post">
	<input type="hidden" name="chassiIni" value="<%=cliAuto.getChassi()%>">
	<input type="hidden" name="cpfIni" value="<%=cliAuto.getClienteCPF()%>">
	<input type="hidden" name="dtaIni" value="<%=cliAuto.getDataInicio()%>">
	<table>
		<tr>
		<td>
			<label>CLIENTE: </label>
			<input type="text" name="cpf" value="<%=cliAuto.getClienteCPF()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi" value="<%=cliAuto.getChassi()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>PLACA: </label>
			<input type="text" name="placa" value="<%=cliAuto.getPlaca()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA INICIAL: </label>
			<input type="text" name="dtaIni" value="<%=cliAuto.getDataInicio()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>