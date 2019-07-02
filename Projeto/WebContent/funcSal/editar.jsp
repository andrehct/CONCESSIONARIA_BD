<%@page import="br.com.concessionaria.vo.FuncionarioSalarioVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%FuncionarioSalarioVO funcSal = (FuncionarioSalarioVO)session.getAttribute("funcSal");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Salário :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../FuncionarioSalarioController" name="formEditar" method="post">
	<input type="hidden" name="cpfIni" value="<%=funcSal.getFuncCPF()%>">
	<input type="hidden" name="dataIni" value="<%=funcSal.getDataIni()%>">
	<table>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf" value="<%=funcSal.getFuncCPF()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>SALÁRIO: </label>
			<input type="text" name="sal" value="<%=funcSal.getSalario()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA INICIAL: </label>
			<input type="text" name="dtaIni" value="<%=funcSal.getDataIni().substring(0,10)%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR SALARIO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>