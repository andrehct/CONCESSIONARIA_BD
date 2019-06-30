<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%AutomovelVO auto = (AutomovelVO)session.getAttribute("automovel");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Automóveis :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../AutomovelController" name="formEditar" method="post">
	<input type="hidden" name="chassiIni" value="<%=auto.getChassi()%>">
	<table>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi" value="<%=auto.getChassi()%>">
		</td>
		</tr>
		<tr>
			<td>
				<label>TIPO: </label>
				<input type="text" name="tipo" value="<%=auto.getIdTpAuto()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>MODELO: </label>
				<input type="text" name="modelo" value="<%=auto.getIdModelo()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>PREÇO: </label>
				<input type="text" name="preco" value="<%=auto.getPreco()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>COR: </label>
				<input type="text" name="cor" value="<%=auto.getIdCor()%>">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR AUTOMOVEL"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>