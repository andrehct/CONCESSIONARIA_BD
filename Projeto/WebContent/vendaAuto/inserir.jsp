<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncVendaAutoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Venda Automóvel :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../FuncVendaAutoController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf">
		</td>
		</tr>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA: </label>
			<input type="text" name="dta">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>