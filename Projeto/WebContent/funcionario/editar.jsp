<%@page import="br.com.concessionaria.vo.FuncionarioVO"%>
<%@page import="br.com.concessionaria.vo.CargoVO"%>
<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%FuncionarioVO func = (FuncionarioVO)session.getAttribute("funcionario");%>
<%List<CargoVO> listaCargo = DAOFactory.createCargoDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Funcionários :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
		<form class="col s8" action="../FuncionarioController" name="formEditar" method="post">
			<input type="hidden" name="cpfIni" value="<%=func.getCPF()%>">
			<div class="row">
				<div class="input-field col s6">
		          <input type="text" name="nome" value="<%=func.getNome()%>">
		          <label>NOME:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" name="cpf" maxlength="11" value="<%=func.getCPF()%>">
		          <label>CPF:</label>
		        </div>
	        </div>
	        <div class="row">
				<div class="input-field col s6">
		          <input type="text" name="rg" value="<%=func.getRg()%>">
		          <label>RG:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" name="nivel" value="<%=func.getNivel()%>">
		          <label>NIVEL:</label>
		        </div>
	        </div>
	        <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="endereco" value="<%=func.getEndereco()%>">
		          <label>ENDEREÇO:</label>
		        </div>
		     </div>
		     <div class="row">
				<div class="input-field col s6">
		          <input type="text" placeholder="YYYY-MM-DD" maxlength="10" name="nascimento" value="<%=func.getDataNascimento().substring(0,10)%>">
		          <label>DATA DE NASCIMENTO:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" placeholder="YYYY-MM-DD" maxlength="10" name="contratacao" value="<%=func.getDataContratacao().substring(0,10)%>">
		          <label>DATA DE CONTRATAÇÃO:</label>
		        </div>
	        </div>
	        <div class="row">
			  <div class="input-field col s6">
			    <select class="browser-default" name="cargo">
			      <option value="" disabled selected>Cargo...</option>
			      <%for(CargoVO c : listaCargo){ %>
			      	<option value="<%=c.getIdCargo()%>"><%=c.getNomeCargo()%></option>
			      <%}%>
			    </select>
			  </div>
		  	</div>	
			<div style="margin-left: 40%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR FUNCIONARIO">ALTERAR
			   		 <i class="material-icons right">send</i>
			    </button>
		    </div>
		</form>
	</div> 
</body>
</html>