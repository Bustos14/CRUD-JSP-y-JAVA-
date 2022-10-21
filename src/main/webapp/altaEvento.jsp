<%@page import="modelo.javabeans.Tipo"%>
<%@page import="modelo.dao.TipoDaoImpl"%>
<%@page import="modelo.dao.IntTipoDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulario de alta de evento</h1>
	<% List<Tipo> lista = (List<Tipo>) request.getAttribute("tipo"); %>
	<form action="eventos?opcion=alta" method="post">
	<!-- <p>Id evento<inpu type="text" name="idEvento"></p> -->	
		<p>Nombre del evento:<input type="text" name="nombre"> </p>
		<p>Descripción:<input type="textarea" name="descripcion"> </p>
		<p>Duración: <input type="number" name="duracion"> </p>
		<p>Dirección: <input type="text" name="direccion"> </p>
		<p>Destacado: <input type="checkbox" name="estado"> </p>
		<p>Aforo máximo: <input type="number" name="aforoMax"> </p>
		<p>Asistentes mínimos: <input type="number" name="asisMin"> </p>
		<p>Precio: <input type="number" name="precio"> </p>
		<p>Tipo(1-Boda, 2-Bautizo, 3-Comunión, 4-Despedida, 5-Cumpleaños): <input type="number" name="idTipo"></p>
		<p><input type="submit" value="Enviar"></p>
	</form>
</body>
</html>