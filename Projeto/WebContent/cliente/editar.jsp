<%@page import="br.com.concessionaria.vo.ClienteVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%ClienteVO cli = (ClienteVO)session.getAttribute("cliente");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Clientes :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
		<form class="col s8" action="../ClienteController" name="formEditar" method="post">
			<input type="hidden" name="cpfIni" value="<%=cli.getCpf()%>">
			<div class="row">
				<div class="input-field col s6">
		          <input type="text" name="nome" value="<%=cli.getNome()%>">
		          <label>NOME:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" name="cpf" maxlength="11" value="<%=cli.getCpf()%>">
		          <label>CPF:</label>
		        </div>
	        </div>
	        <div class="row">
				<div class="input-field col s6">
		          <input type="text" name="rg" value="<%=cli.getRg()%>">
		          <label>RG:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" placeholder="YYYY-MM-DD" maxlength="10" name="nascimento" value="<%=cli.getDataNascimento().substring(0,10)%>">
		          <label>DATA DE NASCIMENTO:</label>
		        </div>
	        </div>
	        <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="endereco" value="<%=cli.getEndereco()%>">
		          <label>ENDEREÇO:</label>
		        </div>
		     </div>
			<div style="margin-left: 40%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR CLIENTE">ALTERAR
			   		 <i class="material-icons right">send</i>
			    </button>
		    </div>
		</form>
	</div> 
</body>
</html>