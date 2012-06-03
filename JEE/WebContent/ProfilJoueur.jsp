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
	<title>Profil de joueur</title>
</head>
<body>

	<%
	String nom = (String) request.getAttribute("nom");
	String pseudo = (String) request.getAttribute("pseudo");
	String sexe = (String) request.getAttribute("sexe");
	String equipe = (String) request.getAttribute("equipe");
	String[] jeux = (String[]) request.getAttribute("jeux");
	%>
	<div id="templatemo_background_section_top">
    	<div class="templatemo_container">
        	<div id="templatemo_header">
        		<div id="templatemo_logo_section">
        			<h1>JEEux</h1>            
					<h2>Profil de joueur</h2>
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
		                <li><a href="ProfilJoueur.jsp"  class="current">Profil</a></li>
        		        <li><a href="hautFaits.jsp">Hauts faits</a></li>
		                <li><a href="replaysRecents.jsp">Replays récents</a></li>
		                <li><a href="equipes.jsp">Equipes</a></li>                       
		            </ul> 
				</div>
			</div> <!-- end of menu -->
		</div><!-- end of container-->
    </div><!-- end of templatemo_background_section_top-->
    <div id="templatemo_background_section_middle">
    	<div class="templatemo_container">
    		<div id="templatemo_left_section">
    			<div class="templatemo_section_box">
                	<div class="templatemo_section_box_top">
                    	<h1>Informations du joueur</h1>
                    </div>
                    <div class="templatemo_section_box_mid">
                    	<ul>
                    		<li> Nom et prénom : <% if (equipe==null) {
									out.print(" - ");
								} else {
									out.print(nom);
								}%></li> 
							<li> Pseudo : <%out.print(pseudo);%></li>
							<li> Sexe : <% if (equipe==null) {
									out.print(" - ");
								} else {
									out.print(sexe);
								}%></li>
							<li> Equipe : <% if (equipe==null) {
									out.print("Sans equipe");
								} else {
									out.print(equipe);
								}%></li>
							<li> Jeux joués : <% if (equipe==null) {
									out.print(" - ");
								} else {
									out.print(jeux);
								}%></li>
						</ul>
                    </div>
                </div><!-- end of section box -->
                <div class="templatemo_section_box">
                	<div class="templatemo_section_box_mid">
                		<form action="Servjeux" >
							<input type="hidden" name="act" value="profJoueurPub">
							<input type="hidden" name="joueurCible" value=<%=pseudo%>>
							<input type="button" name="page" value="" alt="Rajouter en amis" id="button"><br />
							<input type="button" name="page" value="" alt="Inviter à discuter" id="button"><br />
						</form>
					</div>
                </div><!-- end of section box -->
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