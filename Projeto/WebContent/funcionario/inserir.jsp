<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Funcionários :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../FuncionarioController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label><b>NOME:</b></label>
			<input type="text" name="nome">
		</td>
		</tr>
		<tr>
			<td>
				<label><b>CPF:</b></label>
				<input type="text" name="cpf">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>DATA DE NASCIMENTO:</b></label>
				<input type="text" name="nascimento">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>DATA DE CONTRATACAO:</b></label>
				<input type="text" name="contratacao">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>NIVEL:</b></label>
				<input type="text" name="nivel">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>RG:</b></label>
				<input type="text" name="rg">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>ENDERECO:</b></label>
				<input type="text" name="endereco">
			</td>
		</tr>
		<tr>
			<td>
				<label><b>CARGO:</b></label>
				<input type="text" name="cargo">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR FUNCIONARIO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>