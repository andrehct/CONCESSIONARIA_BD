<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguradoraVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Seguradora :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../SeguradoraController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>NOME: </label>
			<input type="text" name="nome">
		</td>
		</tr>
		<tr>
		<td>
			<label>ENDERE�O: </label>
			<input type="text" name="end">
		</td>
		</tr>
		<tr>
		<td>
			<label>TELEFONE: </label>
			<input type="text" name="tele">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR SEGURADORA"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>