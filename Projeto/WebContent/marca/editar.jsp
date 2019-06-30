<%@page import="br.com.concessionaria.vo.MarcaVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%MarcaVO marca = (MarcaVO)session.getAttribute("marca");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Marcas :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../MarcaController" name="formEditar" method="post">
	<input type="hidden" name="marcaIni" value="<%=marca.getIdMarca()%>">
	<table>
		<tr>
		<td>
			<label>MARCA: </label>
			<input type="text" name="nome" value="<%=marca.getNomeMarca()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR MARCA"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>