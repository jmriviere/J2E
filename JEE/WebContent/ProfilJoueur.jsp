<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
	<title>Profil de joueur</title>
</head>
<body>
	<%
	Infos infos = (Infos) request.getAttribute("infos");
	%>

	<div id="templatemo_background_section_top">
		Informations du joueur 
		Nom et prénom : <%out.print(infos.getNomEtPrenom);%><br /> 
		Pseudo : <%out.print(infos.getPseudo);%><br /> 
		Jeux joués : <%out.print(infos.getJeux);%><br />
	</div><!-- end of templatemo_background_section_top-->

	<form action="Servjeux" >
		<input type="hidden" name="act" value="profJoueurPub">
		<input type="hidden" name="joueurCible" value=<%=infos.getPseudo%>>
		<input type="submit" name="page" value="Hauts faits"><br />
		<input type="submit" name="page" value="Replays récents"><br />
		<input type="submit" name="page" value="Equipe"><br />
		<input type="submit" name="page" value="Rajouter en amis"><br />
		<input type="submit" name="page" value="Inviter à discuter"><br />
	</form>

</body>
</html>