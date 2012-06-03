<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>JEEux, accueil</title>
    <meta name="keywords" content="JEEux, jeux en ligne, compétition de jeux en ligne, plateforme de jeux, communauté de joueurs" />
    <meta name="description" content="JEEux, site en ligne de jeux compétitifs" />
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
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
            <form action="/JEE/accueil" method="post">
              <input name="login" type="text" id="login" value="identifiant" onfocus="clearText(this)"/>
              <input name="pass" type="password" id="pass" value="mot de passe" onfocus="clearText(this)"/>
              <input type="hidden" name="action" value="login"/>
              <input type="button" name="Connexion" value="" alt="Connexion" id="button" title="Connexion" onclick="checkLogin()"/>
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
          <div class="templatemo_post">
            <div class="templatemo_post_top">
              <h1>Inscription</h1>
            </div>
            <div class="templatemo_post_mid">
              <div id="register_box" class="register_form">
                <form  action="/Register" autocomplete="on" method="post"> 
                  <p> 
                  <label for="usernamesignup" class="uname" data-icon="u">Pseudo</label><br/>
                  <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="pseudo" /><br/>
                  <label for="passwordsignup" class="youpasswd" data-icon="p">Mot de passe</label><br/>
                  <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="ex. bacon123"/><br/>
                  <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Confirmez le mot de passe</label><br/>
                  <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="ex. bacon123"/><br/>
                  <label for="emailsignup" class="youmail" data-icon="e" >email</label><br/>
                  <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mon@mail.com"/><br/>
                  <label for="namesignup" class="uname" data-icon="e" >Prénom</label><br/>
                  <input id="namesignup" name="namesignup" type="text" placeholder="Roger"/><br/>
                  <label for="snamesignup" class="uname" data-icon="e" >Nom</label><br/>
                  <input id="snamesignup" name="snamesignup" type="text" placeholder="Dufour"/><br/>
                  <label for="sexsignup" class="yousex" data-icon="e" >Sexe</label><br/>
                  <select name="sexe" id="sexe">
                    <option value="--">--</option>
                    <option value="homme">homme</option>
                    <option value="femme">femme</option>
                    <option value="inconnu">inconnu</option>
                  </select>
                  <br/>
                  <label for="regionsignup" class="youregion" data-icon="e" >Region</label><br/>
                  <select name="region" id="region">
                    <option value="--">--</option>
                    <option value="Afrique">Afrique</option>
                    <option value="Amerique">Amerique</option>
                    <option value="Asie">Asie</option>
                    <option value="Europe">Europe</option>
                  </select>
                  <br/>
                  <input type="hidden" name="action" value="register"/>
                  </p>
                  <p class="signin button"> 
                  <input type="submit" value="Inscription"/> 
                  </p>
                </form> 
              </div>
            </div>
            <div class="templatemo_post_bottom">
              <span class="post">Déjà membre ? Identifiez vous en haut à droite.</span>
            </div>
          </div>
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
              <p>Ce site est un projet scolaire de l'école ENSEEIHT ayant pour
              but de créer un site dynamique en utilisant la technologie J2E.
              Les membre du groupe sont Guillaume Casanova, Marine Lavaux,
              Pierre Tysebaert et Rémi Palandri</p>
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
