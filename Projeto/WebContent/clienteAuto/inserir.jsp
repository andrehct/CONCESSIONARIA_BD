<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ClienteAutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Autom�vel Cliente :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../ClienteAutomovelController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>CLIENTE: </label>
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
			<label>PLACA: </label>
			<input type="text" name="placa">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA INICIAL: </label>
			<input type="text" name="dtaIni">
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