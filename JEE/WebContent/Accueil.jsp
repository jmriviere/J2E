<jsp:include page="Header.jsp" />

<%
	// pour les tests
	Boolean logged = true; // (Boolean) request.getAttribute("logged")
%>

       <div id="templatemo_menu_panel">
          <div id="templatemo_menu_section">
            <ul>
              <li><a href="Accueil.jsp" class = "current"> Accueil</a></li>
				<%if (!logged) {%>
					<li><a href="ListJeux.jsp" > Liste des jeux </a></li>
              	<% } else { %> 
		      		<li><a href="ListSalons.jsp" > Salon </a></li>
		      		<li><a href="ListReplays.jsp" > Replays </a></li>
		      		<li><a href="ListTournois.jsp" > Tournois </a></li>
		        <% }%>     
		        	<li><a href="listEquipe.jsp" > Liste des �quipes </a></li>         
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
                <a href="#echec"><img alt="Les �checs !"  src="images/echec.jpg" /></a>
                <a href="#"><img alt="� venir..."  src="images/a_venir.jpg" /></a>
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
              <p>Ce site est un projet scolaire de l'�cole ENSEEIHT ayant pour
              but de cr�er un site dynamique en utilisant la technologie J2E.
              Les membre du groupe sont Guillaume Casanova, Marine Lavaux,
              Pierre Tysebaert et R�mi Palandri</p>
            </div>
            <div class="templatemo_section_box_bottom"></div>
          </div><!-- end of section box -->
        </div><!-- end of right Section -->
      </div><!-- end of container-->
    </div><!-- end of background middle-->
    <div id="templatemo_bottom_panel">
      <div id="templatemo_bottom_section">
        <div id="templatemo_footer_section">
          Copyright � 2012 DreamTeam
        </div>
      </div>
    </div>
  </body>
</html>