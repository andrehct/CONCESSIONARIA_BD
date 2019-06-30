<%@page import="br.com.concessionaria.vo.TipoAutomovelVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%TipoAutomovelVO tpauto = (TipoAutomovelVO)session.getAttribute("tpauto");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Tipos de Automóveis :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
<form action="../TipoAutomovelController" name="formEditar" method="post">
	<input type="hidden" name="tpautoIni" value="<%=tpauto.getIdTPAuto()%>">
	<table>
		<tr>
		<td>
			<label>TIPO DE AUTOMÓVEL: </label>
			<input type="text" name="nome" value="<%=tpauto.getNome()%>">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="ALTERAR TIPO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>
</body>
</html>