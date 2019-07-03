<%@page import="br.com.concessionaria.vo.SeguradoraVO"%>
<%@page import="br.com.concessionaria.vo.SeguroVO"%>
<%@page import="br.com.concessionaria.factory.DAOFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%List<SeguradoraVO> listaSeg = DAOFactory.createSeguradoraDAO().listar();%>
<%SeguroVO seg = (SeguroVO)session.getAttribute("seguro");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::: Edição de Seguro :::</title>
<%@ include file="../menu.jsp" %>

</head>
<body>
	<div class="row" style="margin-top: 50px; margin-left: 25%;">
	    <form class="col s8" action="../SeguroController" name="formEditar" method="post">
	      <input type="hidden" name="idIni" value="<%=seg.getIdSeguro()%>">
	      <div class="row">
		        <div class="input-field col s12">
		          <input type="text" name="nome" value="<%=seg.getNome()%>">
		          <label>NOME DO SEGURO:</label>
		        </div>
		   </div>
	      <div class="row">
	        <div class="input-field col s6">
	        	<select class="browser-default" name="seguradora">
			      <option value="" disabled selected>SEGURADORA...</option>
			      <%for(SeguradoraVO a : listaSeg){ %>
			      	<option value="<%=a.getIdSeg()%>"><%=a.getNomeSeguradora()%></option>
			      <%}%>
			    </select>
	        </div>
	        <div class="row">
		        <div class="input-field col s6">
		          <input type="text" name="preco" placeholder="00.00" value="<%=seg.getPreco()%>">
		          <label>PREÇO:</label>
		        </div>
		    </div>
	       </div>
	      
	      <div style="margin-left: 40%">
	      	<button class="btn waves-effect waves-light" type="submit" name="acao" value="ALTERAR SEGURO">ALTERAR
		   		 <i class="material-icons right">send</i>
		    </button>
	      </div>
	    </form>
	</div>
</body>



</html>