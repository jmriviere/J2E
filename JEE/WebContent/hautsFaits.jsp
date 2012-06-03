<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/javascript">
		function clearText(field){
    		if (field.defaultValue == field.value) field.value = '';
		}
	</script>
	<title>Hauts Faits</title>
</head>
<body>

	<%
	String nom = (String) request.getAttribute("nom");
	String pseudo = (String) request.getAttribute("pseudo");
	String sexe = (String) request.getAttribute("sexe");
	String equipe = (String) request.getAttribute("equipe");
	String[] jeux = (String[]) request.getAttribute("jeux");
	Boolean mine = true;//(Boolean) request.getAttribute("mine");
	%>

	<div id="templatemo_background_section_top">
    	<div class="templatemo_container">
        	<div id="templatemo_header">
        		<div id="templatemo_logo_section">
        			<h1>JEEux</h1>            
					<h2>Hauts Faits</h2>
        		</div>
        		<div id="templatemo_recherche_box">
	                <form action="ServJeux" method="post">
	                	<input type="hidden" name="act" value="recherche">
    	            	<input type="text" name="recherche" id="rech" value="Chercher un joueur" onfocus="clearText(this)"/>
        	            <input type="button" name="Recherche" value="" alt="Recherche" id="button"/>
					</form>
                </div>
       		</div><!-- end of headder -->
       		<div id="templatemo_menu_panel">
            	<div id="templatemo_menu_section">
					<ul>
						<li><a href="accueil.jsp">Accueil</a></li>
						<% if (mine) {
		                	%><li><a href="ProfilJoueurPrive.jsp">Profil</a></li><% 
						} else {
							%><li><a href="ProfilJoueur.jsp">Profil</a></li><%
						}
		                %>
        		        <li><a href="hautsFaits.jsp" class="current">Hauts faits</a></li>
		                <li><a href="replaysRecents.jsp">Replays récents</a></li>
		                <% if (mine) {
		                	%><li><a href="configuration.jsp">Configuration</a></li><% 
						}
		                %>                       
		            </ul> 
				</div>
			</div> <!-- end of menu -->
		</div><!-- end of container-->
    </div><!-- end of templatemo_background_section_top-->
    <div id="templatemo_background_section_middle">
    	<div class="templatemo_container">
    		<div id="templatemo_left_section">
            </div><!-- end of left section-->
            <div id="templatemo_right_section">
            </div><!-- end of right Section -->
    	</div><!-- end of container-->
    </div><!-- end of background middle-->
	<div id="templatemo_bottom_panel">
    	<div id="templatemo_bottom_section">
	 		<div id="templatemo_footer_section">
        		Copyright © 2012 DreamTeam
        	</div>
        </div>
    </div>
</body>
</html>