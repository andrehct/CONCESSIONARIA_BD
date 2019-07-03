<%@page import="br.com.concessionaria.vo.ModeloVO"%>
<%@page import="br.com.concessionaria.vo.MarcaVO"%>
<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%ModeloVO mode = (ModeloVO)session.getAttribute("modelo");%>
<%List<MarcaVO> listaMarca = DAOFactory.createMarcaDAO().listar();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Modelo :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	    <form class="col s8" action="../ModeloController" name="formEditar" method="post">
	      <input type="hidden" name="MarcaIni" value="<%=mode.getIdMarca()%>">
		  <input type="hidden" name="ModeloIni" value="<%=mode.getIdModelo()%>">
		  <input type="hidden" name="AnoIni" value="<%=mode.getAno()%>">
	      <div class="row">
	        <div class="input-field col s12">
	          <input type="text" name="modelo" value="<%=mode.getNomeModelo()%>">
	          <label>MODELO:</label>
	        </div>
		  </div>
	      <div class="row">
	        <div class="input-field col s6">
	        	<select class="browser-default" name="marca">
			      <option value="" disabled selected>MARCA...</option>
			      <%for(MarcaVO a : listaMarca){ %>
			      	<option value="<%=a.getIdMarca()%>"><%=a.getNomeMarca()%></option>
			      <%}%>
			    </select>
	        </div>
	        <div class="input-field col s6">
	          <input type="text" placeholder="YYYY" maxlength="4" pattern="[0-9]+$" name="ano" value="<%=mode.getAno()%>">
	          <label>ANO:</label>
	        </div>
	      </div>
	      <div style="margin-left: 40%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR MODELO">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
	      </div>
	    </form>
	</div>
</body>


</html>