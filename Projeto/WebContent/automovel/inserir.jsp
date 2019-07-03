<%@page import="br.com.concessionaria.vo.TipoAutomovelVO"%>
<%@page import="br.com.concessionaria.vo.ModeloVO"%>
<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="br.com.concessionaria.vo.AutomovelVO"%>
<%@page import="br.com.concessionaria.vo.CorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<ModeloVO> listaModelo = DAOFactory.createModeloDAO().listar();%>
<%List<TipoAutomovelVO> listaTipoAuto = DAOFactory.createTipoAutomovelDAO().listar(); %>
<%List<CorVO> listaCor = DAOFactory.createCorDAO().listar();%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>::: Inserir Automóvel :::</title>
<%@ include file="../menu.jsp" %>

<body>
		<div class="row" style="margin-top: 50px; margin-left: 25%;">
		    <form class="col s8" action="../AutomovelController" name="formInserir" method="post">
		      <div class="row">
		        <div class="input-field col s6">
		          <input type="text" name="chassi">
		          <label>CHASSI</label>
		        </div>
		        <div class="input-field col s6">
		        	<select class="browser-default" name="tipo">
				      <option value="" disabled selected>TIPO...</option>
				      <%for(TipoAutomovelVO t : listaTipoAuto){ %>
				      	<option value="<%=t.getIdTPAuto()%>"><%=t.getNome()%></option>
				      <%}%>
				    </select>
		        </div>
		      </div>
		      <div class="row">
		      	<label>MODELO:</label>
				  <div class="input-field col s12">
				    <select class="browser-default" name="modelo">
				      <option value="" disabled selected>Selecione...</option>
				      <%for(ModeloVO m : listaModelo){ %>
				      	<option value="<%=m.getIdModelo()%>"><%=m.getNomeModelo()%> - <%=m.getAno()%></option>
				      <%}%>
				    </select>
				  </div>
			  </div>
		      <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="preco">
		          <label>PREÇO:</label>
		        </div>
		      </div>
		      <div class="row">
		      	<label>COR:</label>
		        <div class="input-field col s12">
		        	<div class="input-field col s12">
				    <select class="browser-default" name="cor">
				      <option value="" disabled selected>Selecione...</option>
				      <%for(CorVO c : listaCor){ %>
				      	<option value="<%=c.getIdCor()%>"><%=c.getNomeCor()%></option>
				      <%}%>
				    </select>
				  </div>
		        </div>
		      </div>
		      <div style="margin-left: 40%">
		      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="INSERIR AUTOMOVEL">CADASTRAR
			   		 <i class="material-icons right">send</i>
			    </button>
		      </div>
		    </form>
		  </div>

</body>
</html>