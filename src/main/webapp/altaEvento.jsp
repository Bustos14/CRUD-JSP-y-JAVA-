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
		<p>Descripci�n:<input type="textarea" name="descripcion"> </p>
		<p>Duraci�n: <input type="number" name="duracion"> </p>
		<p>Direcci�n: <input type="text" name="direccion"> </p>
		<p>Destacado: <input type="checkbox" name="estado"> </p>
		<p>Aforo m�ximo: <input type="number" name="aforoMax"> </p>
		<p>Asistentes m�nimos: <input type="number" name="asisMin"> </p>
		<p>Precio: <input type="number" name="precio"> </p>
		<p>Tipo(1-Boda, 2-Bautizo, 3-Comuni�n, 4-Despedida, 5-Cumplea�os): <input type="number" name="idTipo"></p>
		<p><input type="submit" value="Enviar"></p>
	</form>
</body>
</html>