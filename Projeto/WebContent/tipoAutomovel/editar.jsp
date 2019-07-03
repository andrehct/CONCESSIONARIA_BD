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
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	<form class="col s8" action="../TipoAutomovelController" name="formEditar" method="post">
		<input type="hidden" name="tpautoIni" value="<%=tpauto.getIdTPAuto()%>">
		<div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="nome" value="<%=tpauto.getNome()%>">
	          <label>NOME DO TIPO:</label>
	      	</div>
		</div>
		<div style="margin-left: 35%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR TIPO">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
		</div>
		</form>
	</div>
</body>


</html>