<jsp:include page="header.jsp" />

    <div id="templatemo_background_section_middle">
      <div class="templatemo_container">
        <div id="templatemo_left_section">
          <div class="templatemo_post">
            <div class="templatemo_post_top">
              <h1>Inscription</h1>
            </div>
            <div class="templatemo_post_mid">
              <div id="register_box" class="register_form">
                <form  action="UserServlet" autocomplete="on" method="post"> 
                  <%
                  	Object oerror = request.getAttribute("error");
                  	Integer error = (Integer)oerror;
                  %>
                  <p> 
                  <label for="usernamesignup" class="uname" data-icon="u">Pseudo (*)</label><br/>
                  <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="pseudo" />
                  <% 
                  	if (error != null) {
                  		if ((error/2)%2 == 1) {
                  			out.println("<font color=\"red\"> Pseudo déja utilisé. </font>");
                  		}
                  	}
                  %><br/>
                  <label for="passwordsignup" class="youpasswd" data-icon="p">Mot de passe (*)</label><br/>
                  <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="ex. bacon123"/>
                  <%
                  	if (error != null) {
                  		if (error%2 == 1) {
                  			out.println("<font color=\"red\"> les mots de passe ne correspondent pas. </font>");
                  		}
                  	}

                  %><br/>
                  <label for="passwordconfirmsignup" class="youpasswd" data-icon="p">Confirmez le mot de passe (*)</label><br/>
                  <input id="passwordconfirmsignup" name="passwordconfirmsignup" required="required" type="password" placeholder="ex. bacon123"/><br/>
                  <label for="emailsignup" class="youmail" data-icon="e" >email (*)</label><br/>
                  <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mon@mail.com"/>
                  <% 
                  	if (error != null) {
                  		if ((error/4)%2 == 1) {
                  			out.println("<font color=\"red\"> Mail déja utilisé. </font>");
                  		}
                  	}
                  %><br/>
                  <label for="namesignup" class="uname" data-icon="e" >Prénom</label><br/>
                  <input id="namesignup" name="namesignup" type="text" placeholder="Roger"/><br/>
                  <label for="snamesignup" class="uname" data-icon="e" >Nom</label><br/>
                  <input id="snamesignup" name="snamesignup" type="text" placeholder="Dufour"/><br/>
                  <label for="sexsignup" class="yousex" data-icon="e" >Sexe</label><br/>
                  <select name="sexe" id="sexe">
                    <option value="--">--</option>
                    <option value="homme">homme</option>
                    <option value="femme">femme</option>
                    <option value="br">brésilien</option>
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
              <div class="templatemo_post_bottom">
                <span class="post">Déjà membre ? Identifiez vous en haut à droite.</span><br/>
                <span class="post">(*) Champs obligatoires.</span>
              </div>
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
