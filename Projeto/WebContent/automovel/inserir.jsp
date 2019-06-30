<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Automóveis :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../AutomovelController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi">
		</td>
		</tr>
		<tr>
			<td>
				<label>TIPO: </label>
				<input type="text" name="tipo">
			</td>
		</tr>
		<tr>
			<td>
				<label>MODELO: </label>
				<input type="text" name="modelo">
			</td>
		</tr>
		<tr>
			<td>
				<label>ANO: </label>
				<input type="text" name="ano">
			</td>
		</tr>
		<tr>
			<td>
				<label>MARCA: </label>
				<input type="text" name="marca">
			</td>
		</tr>
		<tr>
			<td>
				<label>PREÇO: </label>
				<input type="text" name="preco">
			</td>
		</tr>
		<tr>
			<td>
				<label>COR: </label>
				<input type="text" name="cor">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR AUTOMOVEL"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>