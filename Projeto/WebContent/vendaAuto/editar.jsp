<%@page import="br.com.concessionaria.vo.FuncVendaAutoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%FuncVendaAutoVO fav = (FuncVendaAutoVO)session.getAttribute("fav");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Venda Automóvel :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../FuncVendaAutoController" name="formEditar" method="post">
	<input type="hidden" name="cpfIni" value="<%=fav.getFuncCPF()%>">
	<input type="hidden" name="dataIni" value="<%=fav.getDataVenda()%>">
	<input type="hidden" name="chassiIni" value="<%=fav.getChassi()%>">
	<table>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf" value="<%=fav.getFuncCPF()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi" value="<%=fav.getChassi()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA: </label>
			<input type="text" name="dta" value="<%=fav.getDataVenda()%>">
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