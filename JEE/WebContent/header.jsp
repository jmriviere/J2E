<%
	String nom = (String) request.getAttribute("nom");
	String pseudo = (String) request.getAttribute("pseudo");
	String sexe = (String) request.getAttribute("sexe");
	String equipe = (String) request.getAttribute("equipe");
	String[] jeux = (String[]) request.getAttribute("jeux");
	Boolean mine = false; //(Boolean) request.getAttribute("mine");
	Boolean logged = false; // (Boolean) request.getAttribute("logged")
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>JEEux</title>
    	<meta name="keywords" content="JEEux, jeux en ligne, compétition de jeux en ligne, plateforme de jeux, communauté de joueurs" />
    	<meta name="description" content="JEEux, site en ligne de jeux compétitifs" />
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
					<% if(!logged) { %>
          				<div id="logged_box">
            				<form action="/JEE/accueil" method="post">
             					<input name="login" type="text" id="login" placeholder="identifiant"/>
              					<input name="pass" type="password" id="pass" placeholder="***********"/>
              					<input type="hidden" name="action" value="login"/>
              					<input type="button" name="Connexion" value="" alt="Connexion" id="button" title="Connexion"/>
            				</form>
          				</div>
     				<% } else { %>
     					<div id="logged_box">
            				Connecté<br/>
    						Votre compte 
    						<!-- <a href="UserServlet?login=(java)truc.getAttribute("UserName")(/java)">(java)truc.getAttribute("UserName")(/java)</a> <br /> -->
    						<a href="/JEE/Logout"> Logout </a>
          				</div>
    				<% } %> 
        </div><!-- end of headder -->
        <div id="templatemo_menu_panel">
          <div id="templatemo_menu_section">
            <ul>
              <li><a href="/JEE/accueil"  class="current">Accueil</a></li>
              <li><a href="#">Liste des jeux</a></li>
              <li><a href="#">Liste des équipes</a></li>
              <% if (mine) {
		                	%><li><a href="ProfilJoueurPrive.jsp">Profil</a></li><% 
						} else {
							%><li><a href="ProfilJoueur.jsp">Profil</a></li><%
						}
		                %>                  
            </ul> 
          </div>
        </div> <!-- end of menu -->
      </div><!-- end of container-->
    </div><!-- end of templatemo_background_section_top-->
	</body>
</html>
	
			                