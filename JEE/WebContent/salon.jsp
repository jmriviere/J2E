<jsp:include page="header.jsp" />

<%
	// pour les tests
	Boolean logged = true; // (Boolean) request.getAttribute("logged")
%>

       <div id="templatemo_menu_panel">
          <div id="templatemo_menu_section">
            <ul>
              <li><a href="accueil.jsp" class = "current"> Accueil</a></li>
              <li><a href="listJeux.jsp" > Liste des jeux </a></li>
              <li><a href="listEquipe.jsp" > Liste des équipe </a></li>
              <%if (logged) {%>
		      	<li><a href="ProfilJoueur.jsp">Profil</a></li>
		      <% }%>                  
            </ul> 
          </div>
        </div> <!-- end of menu -->
      </div><!-- end of container-->
    </div><!-- end of templatemo_background_section_top-->
	

	<div id="templatemo_background_section_middle">
		<div class="templatemo_container">
			<div id="templatemo_left_section">
        <div id="templatemo_subtitle">
          <h2>Salon Equipe RoxxorBoxxor</h2>
        </div>
				<div class="templatemo_post">
					<div class="templatemo_post_top">
						<h1>Parties en attente</h1>
					</div>
					<div class="templatemo_post_mid">                     
            <p>
            <a href="#">Morpion</a>(1500) <br/>
            <a href="#">Morpion</a>(902) <br/>
            <a href="#">Morpion</a>(1750) <br/>
            <a href="#">Shifoumi</a>(2000) <br/>
            <a href="#">Shifoumi</a>(300) <br/>
            </p>
						<div class="clear"></div>
					</div>
					<div class="templatemo_post_bottom">
					</div>
				</div><!-- end of templatemo_post-->
				<div class="chat_css">
          <div class="chat_textbox">
            <p>Bernard: Un petit morpion? J'ai un tournois ce soir</p>
          </div>
          <div class="chat_messagebox">
            <form action="#" method="post">
              <input name="message" type="text" class="chat_message" value=""/>
              <input type="submit" name="envoi" title="Envoyer" class="envoi"/>
            </form>
          </div>
				</div><!-- end of templatemo_post-->
			</div><!-- end of left section-->
			<div id="templatemo_right_section">
				<div class="templatemo_section_box">
					<div class="templatemo_section_box_top">
						<h1>Jeux disponibles</h1>
					</div>
					<div class="templatemo_section_box_mid">
						<a href="#"><img alt="125x125 Ad Banner"  src="images/tic_tac_toe.jpg" /></a> 
						<a href="#"><img alt="125x125 Ad Banner"  src="images/tic_tac_toe.jpg" /></a>
						<a href="#"><img alt="125x125 Ad Banner"  src="images/tic_tac_toe.jpg" /></a>
						<a href="#"><img alt="125x125 Ad Banner"  src="images/tic_tac_toe.jpg" /></a>
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
