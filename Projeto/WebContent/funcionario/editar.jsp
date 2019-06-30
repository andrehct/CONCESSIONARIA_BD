<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%FuncionarioVO func = (FuncionarioVO)session.getAttribute("funcionario");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Funcionários :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../FuncionarioController" name="formEditar" method="post">
	<input type="hidden" name="cpfIni" value="<%=func.getCPF()%>">
	<table>
		<tr>
			<td>
				<img src="c:/anexos/funcionario/f1.jpg" style="" height="120" width="80"/>
			</td>
		</tr>
		<tr>
		<td>
			<label>NOME: </label>
			<input type="text" name="nome" value="<%=func.getNome()%>">
		</td>
		</tr>
		<tr>
			<td>
				<label>CPF: </label>
				<input type="text" name="cpf" value="<%=func.getCPF()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>DATA DE NASCIMENTO: </label>
				<input type="text" name="nascimento" value="<%=func.getDataNascimento()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>DATA DE CONTRATACAO: </label>
				<input type="text" name="contratacao" value="<%=func.getDataContratacao()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>NIVEL: </label>
				<input type="text" name="nivel" value="<%=func.getNivel()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>RG: </label>
				<input type="text" name="rg" value="<%=func.getRg()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>ENDERECO: </label>
				<input type="text" name="endereco" value="<%=func.getEndereco()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>CARGO: </label>
				<input type="text" name="cargo" value="<%=func.getIdCargo()%>">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR FUNCIONARIO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>