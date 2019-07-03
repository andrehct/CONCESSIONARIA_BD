<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.CargoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<CargoVO> listaCargo = DAOFactory.createCargoDAO().listar();%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Funcionário :::</title>
<%@ include file="../menu.jsp" %>

<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
		<form class="col s8" action="../FuncionarioController" name="formInserir" method="post">
			<div class="row">
				<div class="input-field col s6">
		          <input type="text" name="nome">
		          <label>NOME:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" maxlength="11" placeholder="00000000000" pattern="[0-9]+$" name="cpf">
		          <label>CPF:</label>
		        </div>
	        </div>
	        <div class="row">
				<div class="input-field col s6">
		          <input type="text" name="rg">
		          <label>RG:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" name="nivel">
		          <label>NIVEL:</label>
		        </div>
	        </div>
	        <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="endereco">
		          <label>ENDEREÇO:</label>
		        </div>
		     </div>
		     <div class="row">
				<div class="input-field col s6">
		          <input type="text" placeholder="YYYY-MM-DD" maxlength="10" name="nascimento">
		          <label>DATA DE NASCIMENTO:</label>
		        </div>
				<div class="input-field col s6">
		          <input type="text" placeholder="YYYY-MM-DD" maxlength="10" name="contratacao">
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
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR FUNCIONARIO">CADASTRAR
			   		 <i class="material-icons right">send</i>
			    </button>
		    </div>
		</form>
	</div> 

</body>

</html>