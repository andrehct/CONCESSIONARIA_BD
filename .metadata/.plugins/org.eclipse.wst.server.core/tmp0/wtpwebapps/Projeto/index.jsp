<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>TESTE</h1>

<form action="FuncionarioController" name="form1" method="post">
	<table>
		<tr>
		<td>
			<label>NOME: </label>
			<input type="text" name="nome">
		</td>
		</tr>
		<tr>
			<td>
				<label>CPF: </label>
				<input type="text" name="cpf">
			</td>
		</tr>
		<tr>
			<td>
				<label>DATA DE NASCIMENTO: </label>
				<input type="text" name="nascimento">
			</td>
		</tr>
		<tr>
			<td>
				<label>DATA DE CONTRATACAO: </label>
				<input type="text" name="contratacao">
			</td>
		</tr>
		<tr>
			<td>
				<label>NIVEL: </label>
				<input type="text" name="nivel">
			</td>
		</tr>
		<tr>
			<td>
				<label>RG: </label>
				<input type="text" name="rg">
			</td>
		</tr>
		<tr>
			<td>
				<label>ENDERECO: </label>
				<input type="text" name="endereco">
			</td>
		</tr>
		<tr>
			<td>
				<label>CARGO: </label>
				<input type="text" name="cargo">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="botao" value="Enviar">
			</td>
		</tr>
	</table>
</form>

</body>
</html>