<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguroVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Seguro :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../SeguroController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>NOME: </label>
			<input type="text" name="nome">
		</td>
		</tr>
		<tr>
		<td>
			<label>SEGURADORA: </label>
			<input type="text" name="seguradora">
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
				<br/>
				<input type="submit" name="acao" value="INSERIR SEGURO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>