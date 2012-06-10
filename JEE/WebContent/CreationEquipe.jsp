<jsp:include page="Header.jsp" />

    <div id="templatemo_background_section_middle">
      <div class="templatemo_container">
        <div id="templatemo_left_section">
          <div class="templatemo_post">
            <div class="templatemo_post_top">
              <h1>Cr�ation d'�quipe</h1>
            </div>
            <div class="templatemo_post_mid">
              <div id="register_box" class="register_form">
                <form  action="EquipeServlet" autocomplete="on" method="post"> 
                  <%
                  	Boolean name_taken = (Boolean)request.getAttribute("ename_taken");
                  %>
                  <p> 
                  <label for="equipenamesignup" class="uname" data-icon="u">* Nom de l'�quipe</label><br/>
                  <input id="equipenamesignup" name="equipenamesignup" required="required" type="text" placeholder="SuperNom" />
                  <% 
                  	if (name_taken != null) {
                  		if(name_taken) {
                  			out.println("<font color=\"red\"> Nom d'�quipe d�j� utilis� </font>");    
                  		}
                  	}
                  %><br/>
                
                  <label for="slogansignup" class="youslogan" data-icon="e" >Slogan</label><br/>
                  <input id="slogansignup" name="slogansignup" type="text" placeholder="SuperSlogan!"/><br/>                              
                  <input type="hidden" name="action" value="registerEquipe"/>
                  </p>
                  <p class="signin button"> 
                  <input type="submit" value="Cr�ation d'�quipe"/> 
                  </p>
                </form> 
              </div>
              <div class="templatemo_post_bottom">
                <span class="post">Devenez un respect� chef d'�quipe de JEEux !</span><br/>
                <span class="post">(*) Champ obligatoire</span>
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

<jsp:include page="Footer.jsp" />
