<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.ModeloVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Modelos :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../ModeloController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>MODELO: </label>
			<input type="text" name="modelo">
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
				<label>ANO: </label>
				<input type="text" name="ano">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR MODELO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>