<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioSalarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Salário Funcionário :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../FuncionarioSalarioController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf">
		</td>
		</tr>
		<tr>
		<td>
			<label>SALÁRIO: </label>
			<input type="text" name="sal">
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
				<input type="submit" name="acao" value="INSERIR SALARIO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>