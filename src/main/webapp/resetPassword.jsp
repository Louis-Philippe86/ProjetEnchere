<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jspf"%>
<link rel="stylesheet" href="style/style.css">
<title>Page de connexion</title>
</head>
<body>
	<%@ include file="header.jspf"%>
	<main>
		<form method="POST" action="ServletPasswordReset">
			<label for="pseudoUser">Identifiant</label>
			<input  type="text" name="pseudoUser" id="pseudoUser" >
			<label for="passwordUser">Nouveau mot de passe</label>
			<input  type="password" name="passwordUser" id="passwordUser" >
			<button type="submit" class="btn btn-primary">Reset</button>
		</form>
		<c:if test="${!empty erreur }">
		
			<p class="text-center text-danger">${erreur}</p>
		
		</c:if>
	</main>

</body>
</html>