<jsp:include page="Header.jsp" />

<!-- page accessible uniquement accessible si non connecté -->

    <div id="templatemo_background_section_middle">
      <div class="templatemo_container">
        <div id="templatemo_left_section">
          <div class="templatemo_post">
            <div class="templatemo_post_top">
              <h1>Création de tournoi</h1>
            </div>
            <div class="templatemo_post_mid">
              <div id="register_box" class="register_form">
                <form  action="TournoiServlet" autocomplete="on" method="post"> 
                  <%
                  	Boolean name_taken = (Boolean)request.getAttribute("tname_taken");
                  %>
                  <p> 
                  <label for="tournoinamesignup" class="uname" data-icon="u">Nom du Tournoi (*)</label><br/>
                  <input id="tournoinamesignup" name="tournoinamesignup" required="required" type="text" placeholder="SuperNom" />
                  <% 
                  	if (name_taken != null) {
                  		if(name_taken) {
                  			out.println("<font color=\"red\"> Nom de tournoi déjà utilisé </font>");    
                  		}
                  	}
                  %><br/>
                
                  <label for="nbeqsignup" class="younbeq" data-icon="e" >Nombre maximum d'équipes</label><br/>
                  <input id="nbeqsignup" pattern="[0-9]*" name="nbeqsignup" type="text" placeholder="42"/><br/>                              
                  <input type="hidden" name="action" value="registerTournoi"/>
                  </p>
                  <p class="signin button"> 
                  <input type="submit" value="Création du Tournoi"/> 
                  </p>
                </form> 
              </div>
              <div class="templatemo_post_bottom">
                <span class="post">Commencez un tournoi sans merci dans JEEux</span><br/>
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