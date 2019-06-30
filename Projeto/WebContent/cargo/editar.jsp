<%@page import="br.com.concessionaria.vo.CargoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%CargoVO car = (CargoVO)session.getAttribute("cargo");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Cargo :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../CargoController" name="formEditar" method="post">
	<input type="hidden" name="idIni" value="<%=car.getIdCargo()%>">
	<table>
		<tr>
		<td>
			<label>NOME DO CARGO: </label>
			<input type="text" name="nome" value="<%=car.getNomeCargo()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR CARGO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>