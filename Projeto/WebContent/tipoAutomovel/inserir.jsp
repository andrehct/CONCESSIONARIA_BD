<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Tipos de Automóvel :::</title>
<%@ include file="../menu.jsp" %>

<body>
<form action="../TipoAutomovelController" name="formInserir" method="post">
	<table>
		<tr>
		<td>
			<label><b>NOME DO TIPO:</b></label>
			<input type="text" name="nome">
		</td>
		</tr>
		<tr>
			<td>
				<br/>
				<input type="submit" name="acao" value="INSERIR TIPO"  class="waves-effect waves-light btn-small">
			</td>
		</tr>
	</table>
</form>

</body>
</html>