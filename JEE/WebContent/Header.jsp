<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.Joueur"%>
<%
	Joueur j_act = (Joueur)request.getSession().getAttribute("JoueurActuel");
	String current = (String)request.getAttribute("page");
	current = ((current==null) ? "Accueil.jsp" : current);
    String error_message = (String)request.getSession().getAttribute("ErrorMessage");
    if(error_message!=null) {
   		request.getSession().removeAttribute("ErrorMessage");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JEEux></title>
<meta name="keywords"
	content="JEEux, jeux en ligne, compétition de jeux en ligne, plateforme de jeux, communauté de joueurs" />
<meta name="description"
	content="JEEux, site en ligne de jeux compétitifs" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="templatemo_background_section_top">
		<div class="templatemo_container">
			<div id="templatemo_header">
				<div id="templatemo_logo_section">
					<h1>JEEux</h1>
					<h2>Site de jeux en lignes compétitifs</h2>
				</div>
				<% if(j_act==null) { %>
				<div id="not_logged">
					<form action="LoginServlet" method="post">
						<input name="login" type="text" id="login" placeholder="identifiant" /> 
						<input name="pass" type="password" id="pass" placeholder="***********" /> 
						<input type="hidden" name="action" value="login" /> 
						<input type="submit" name="Connexion" value="" alt="Connexion" id="button" title="Connexion" />
					</form>
					<% if(error_message!=null) { %>
					<p id="error"><%= error_message %></p>
					<% } else { %>
					<p id="register"><a href="NavigationServlet?action=creationCompte">Inscription</a></p> 	
					<% } %>
				</div>
				<% } else { %>
				<div id="logged">
					<form action="LoginServlet" method="post">
						<a
							href="UserServlet?action=profil&amp;login=<%= j_act.getLogin() %>"
							id="lien_compte"><%= j_act.getLogin()%></a> <input type="hidden"
							name="action" value="logout" /> <input type="submit"
							name="Logout" value="" alt="Logout" id="button"
							title="Deconnexion" />
					</form>
				</div>
				<% } %>
			</div>
			<!-- end of headder -->
			<div id="templatemo_menu_panel">
				<div id="templatemo_menu_section">
				<% if(j_act==null) { %>
					<ul>
               			<li><a href="NavigationServlet?action=accueil" <% if(current.equals("Accueil.jsp")) {%> class="current"<% } %>> Accueil</a></li>
						<li><a href="NavigationServlet?action=listeJeux" <% if(current.equals("ListJeux.jsp")) {%> class="current"<% } %>> Liste des jeux </a></li>
						<li><a href="NavigationServlet?action=listeEquipes" <% if(current.equals("ListEquipes.jsp")) {%> class="current"<% } %>> Liste des équipe </a></li>
             		</ul>
             	<% } else { %>
					<ul>
              			<li><a href="NavigationServlet?action=accueil" <% if(current.equals("Accueil.jsp")) {%> class="current"<% } %>> Accueil </a></li>
              			<li><a href="NavigationServlet?action=listeJeux" <% if(current.equals("ListJeux.jsp")) {%> class="current"<% } %>> Liste des jeux </a></li>
						<li><a href="NavigationServlet?action=listeSalons" <% if(current.equals("ListSalons.jsp")) {%> class="current"<% } %>> Salon </a></li>
						<li><a href="NavigationServlet?action=listeReplays" <% if(current.equals("ListReplays.jsp")) {%> class="current"<% } %>> Replays </a></li>
						<li><a href="NavigationServlet?action=listeTournois" <% if(current.equals("ListTournois.jsp")) {%> class="current"<% } %>> Tournois </a></li>
						<li><a href="NavigationServlet?action=listeEquipes" <% if(current.equals("ListEquipes.jsp")) {%> class="current"<% } %>> Liste des équipes </a></li>
						<li><a href="NavigationServlet?action=listeJoueurs" <% if(current.equals("ListJoueurs.jsp")) {%> class="current"<% } %>> Liste des joueurs </a></li>						
            		</ul>
				<% } %>
				</div>
			</div>
			<!-- end of menu -->
			<div></div>
			<!-- end of container-->
			<div></div>
		</div>
	</div>
