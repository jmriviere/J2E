<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
	<title>Votre Profil</title>
</head>
<body>

	<%
	Infos infos = (Infos) request.getAttribute("infos");
	%>

	Informations du joueur 
	Nom et prénom : <%out.print(infos.getNomEtPrenom);%><br /> 
	Pseudo : <%out.print(infos.getPseudo);%><br /> 
	Jeux joués : <%out.print(infos.getJeux);%><br />

	<form action="ServJeux" method="post">
		<input type="hidden" name="act" value="profJoueurPri">
		<input type="hidden" name="joueurCible" value=<%=infos.getPseudo%>>
		<input type="submit" name="page" value="Hauts faits"><br />
		<input type="submit" name="page" value="Replays récents"><br />
		<input type="submit" name="page" value="Equipe"><br />
		<input type="submit" name="page" value="Configuration"><br /> //moyen de sécuriser un peu le truc.
	</form>

</body>
</html>