<%@page import="br.com.concessionaria.vo.ClienteVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%ClienteVO cli = (ClienteVO)session.getAttribute("cliente");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Clientes :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../ClienteController" name="formEditar" method="post">
	<input type="hidden" name="cpfIni" value="<%=cli.getCpf()%>">
	<table>
		<tr>
		<td>
			<label>NOME: </label>
			<input type="text" name="nome" value="<%=cli.getNome()%>">
		</td>
		</tr>
		<tr>
			<td>
				<label>CPF: </label>
				<input type="text" name="cpf" value="<%=cli.getCpf()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>DATA DE NASCIMENTO: </label>
				<input type="text" name="nascimento" value="<%=cli.getDataNascimento()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>RG: </label>
				<input type="text" name="rg" value="<%=cli.getRg()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>ENDERECO: </label>
				<input type="text" name="endereco" value="<%=cli.getEndereco()%>">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR CLIENTE"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>