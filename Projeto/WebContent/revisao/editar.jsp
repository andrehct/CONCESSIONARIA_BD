<%@page import="br.com.concessionaria.vo.RevisaoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%RevisaoVO rev = (RevisaoVO)session.getAttribute("revisao");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Revisão :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../RevisaoController" name="formEditar" method="post">
	<input type="hidden" name="cpfIni" value="<%=rev.getFuncCPF()%>">
	<input type="hidden" name="dataIni" value="<%=rev.getDataRev()%>">
	<input type="hidden" name="chassiIni" value="<%=rev.getChassi()%>">
	<table>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf" value="<%=rev.getFuncCPF()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi" value="<%=rev.getChassi()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA: </label>
			<input type="text" name="dta" value="<%=rev.getDataRev().substring(0,10)%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>ACEITE: </label>
			<input type="text" name="aceite" value="<%=rev.getAceite()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>PLACA: </label>
			<input type="text" name="placa" value="<%=rev.getPlaca()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>PREÇO: </label>
			<input type="text" name="preco" value="<%=rev.getPreco()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR REVISAO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>