<%@page import="br.com.concessionaria.vo.CorVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%CorVO cor = (CorVO)session.getAttribute("cor");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Cor :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../CorController" name="formEditar" method="post">
	<input type="hidden" name="idIni" value="<%=cor.getIdCor()%>">
	<table>
		<tr>
		<td>
			<label>NOME DA COR: </label>
			<input type="text" name="nome" value="<%=cor.getNomeCor()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR COR"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>