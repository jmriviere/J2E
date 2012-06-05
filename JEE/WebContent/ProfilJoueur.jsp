<jsp:include page="header.jsp" />

<!-- page accessible uniquement accessible si connecté apres gestion de profil prive et public -->

       <div id="templatemo_menu_panel">
          <div id="templatemo_menu_section">
            <ul>
              <li><a href="accueil.jsp" > Accueil</a></li> 
		      <li><a href="listSalon.jsp" > Salon </a></li>
		      <li><a href="replaysRecents.jsp" > Replays </a></li>
		      <li><a href="listTournois.jsp" > Tournois </a></li>   
		      <li><a href="listEquipe.jsp" > Liste des équipe </a></li>         
            </ul> 
          </div>
        </div> <!-- end of menu -->
      </div><!-- end of container--> 
    </div><!-- end of templatemo_background_section_top-->
	
<%
	String nom = (String) request.getAttribute("nom");
	String pseudo = (String) request.getAttribute("pseudo");
	String sexe = (String) request.getAttribute("sexe");
	String equipe = (String) request.getAttribute("equipe");
	String[] jeux = (String[]) request.getAttribute("jeux");
	Boolean mine = true;//(Boolean) request.getAttribute("mine");
%>

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
							<li> <a href="hautsFaits.jsp">Hauts Faits</a></li>
							<li> <a href="replaysRecents.jsp">Replays</a></li>
						</ul>
                    </div>
                </div><!-- end of section box -->
                <div class="templatemo_section_box">
                	<div class="templatemo_section_box_mid">
                		<%
                		if (mine) {
						%>
                		<form action="Servjeux" >
							<input type="hidden" name="act" value="profJoueurPub">
							<input type="hidden" name="joueurCible" value=<%=pseudo%>>
							<input type="button" name="page" value="" alt="Rajouter en amis" id="button"><br />
							<input type="button" name="page" value="" alt="Inviter à discuter" id="button"><br />
						</form>
						<%
                		} else {
						%>
						<form action="Servjeux" >
							<input type="hidden" name="act" value="profJoueurPub">
							<input type="hidden" name="joueurCible" value=<%=pseudo%>>
							<input type="button" name="page" value="" alt="Mes amis" id="button"><br />
						</form>
						<%
                		}
						%>
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