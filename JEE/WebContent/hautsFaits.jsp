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
              <li><a href="listEquipe.jsp" > Liste des �quipe </a></li>
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
            </div><!-- end of left section-->
            <div id="templatemo_right_section">
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