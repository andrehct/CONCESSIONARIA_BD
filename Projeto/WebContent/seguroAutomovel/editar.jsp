<%@page import="br.com.concessionaria.vo.SeguroAutomovelVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%SeguroAutomovelVO seg = (SeguroAutomovelVO)session.getAttribute("seguroAuto");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Automóvel Segurado :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../SeguroAutomovelController" name="formEditar" method="post">
	<input type="hidden" name="idSegIni" value="<%=seg.getIdSeguro()%>">
	<input type="hidden" name="chassiIni" value="<%=seg.getChassi()%>">
	<input type="hidden" name="dataIni" value="<%=seg.getDataContrato()%>">
	<table>
		<tr>
		<td>
			<label>CHASSI: </label>
			<input type="text" name="chassi" value="<%=seg.getChassi()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>SEGURO: </label>
			<input type="text" name="seguro" value="<%=seg.getIdSeguro()%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>DATA DA VENDA: </label>
			<input type="text" name="dta" value="<%=seg.getDataContrato().substring(0,10)%>">
		</td>
		</tr>
		<tr>
		<td>
			<label>FUNCIONÁRIO: </label>
			<input type="text" name="cpf" value="<%=seg.getFuncCPF()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR SEGURO AUTOMOVEL"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>