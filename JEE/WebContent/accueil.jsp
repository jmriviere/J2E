<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>JEEux, accueil</title>
		<meta name="keywords" content="JEEux, jeux en ligne, compétition de jeux en ligne, plateforme de jeux, communauté de joueurs" />
		<meta name="description" content="JEEux, site en ligne de jeux compétitifs" />
		<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript">
			function clearText(field){
    			if (field.defaultValue == field.value) field.value = '';
			}
		</script>	
	</head>
	<body>
		<div id="templatemo_background_section_top">
    		<div class="templatemo_container">
        		<div id="templatemo_header">
					<div id="templatemo_logo_section">            
		        		<h1>JEEux</h1>            
						<h2>Site de jeux en lignes compétitifs</h2>
					</div>		
					<div id="templatemo_search_box">
	                	<form action="/JEE/Login" method="post">
    	            		<input name="login" type="text" id="login" value="identifiant" onfocus="clearText(this)"/>
							<input name="pass" type="password" id="pass" value="mot de passe" onfocus="clearText(this)"/>
        	            	<input type="button" name="Connexion" value="Connexion" alt="Connexion" id="button" title="Connexion" onclick="checkLogin()"/>
						</form>
                	</div>
				</div><!-- end of headder -->
    			<div id="templatemo_menu_panel">
            		<div id="templatemo_menu_section">
							<ul>
		                		<li><a href="/JEE/acceuil"  class="current">Accueil</a></li>
        		        		<li><a href="#">Liste des jeux</a></li>
		                		<li><a href="#">Liste des équipes</a></li>
		                		<li><a href="#">Compte</a></li>                       
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
					<div class="templatemo_section_box">
                		<div class="templatemo_section_box_top">
                    		<h1>Jeux disponibles</h1>
                    	</div>
						<div class="templatemo_section_box_mid">
                   			<div class="templatemo_section_box_mid"> <!-- TODO rajouter les ancres correspondantes + ortho -->
                   				<a href="#morpion"><img alt="Le morpion !"  src="images/tic_tac_toe.jpg" /></a> 
                    			<a href="#shifumi"><img alt="Le chifoumi !"  src="images/chifoumi.jpg" /></a>
                    			<a href="#echec"><img alt="Les Échecs !"  src="images/echec.jpg" /></a>
                        		<a href="#"><img alt="À venir..."  src="images/a_venir.jpg" /></a>
                        		<div class="clear">&nbsp;</div>
							</div>
                        	<div class="clear">&nbsp;</div>
						</div>
                  		<div class="templatemo_section_box_bottom"></div>
                	</div><!-- end of section box -->
                	<div class="templatemo_section_box">
                		<div class="templatemo_section_box_top">
                    		<h1>A propos</h1>
                    	</div>
						<div class="templatemo_section_box_mid">
                   			<p>Ce site est un projet scolaire de l'école ENSEEIHT ayant pour but de créer un site dynamique en utilisant la technologie J2E. Les membre du groupe sont Guillaume Casanova, Marine Lavaux, Pierre Tysebaert et Rémi Palandri</p>
						</div>
                    	<div class="templatemo_section_box_bottom"></div>
                	</div><!-- end of section box -->
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