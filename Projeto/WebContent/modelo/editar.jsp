<%@page import="br.com.concessionaria.vo.ModeloVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%ModeloVO mode = (ModeloVO)session.getAttribute("modelo");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Modelos :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../ModeloController" name="formEditar" method="post">
	<input type="hidden" name="MarcaIni" value="<%=mode.getIdMarca()%>">
	<input type="hidden" name="ModeloIni" value="<%=mode.getIdModelo()%>">
	<input type="hidden" name="AnoIni" value="<%=mode.getAno()%>">
	<table>
		<tr>
		<td>
			<label>MODELO: </label>
			<input type="text" name="modelo" value="<%=mode.getNomeModelo()%>">
		</td>
		</tr>
		<tr>
			<td>
				<label>MARCA: </label>
				<input type="text" name="marca" value="<%=mode.getIdMarca()%>">
			</td>
		</tr>
		<tr>
			<td>
				<label>ANO: </label>
				<input type="text" name="ano" value="<%=mode.getAno()%>">
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR MODELO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>