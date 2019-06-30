<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.SeguroAutomovelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Seguro para Automóvel:::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../SeguroAutomovelController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi">
		</td>
		</tr>
		<tr>
		<td>
			<label>SEGURO: </label>
			<input type="text" name="seguro">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA DA VENDA: </label>
			<input type="text" name="dta">
		</td>
		</tr>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR SEGURO AUTOMOVEL"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>