<jsp:include page="Header.jsp" />

<!-- page accessible uniquement accessible si connecté apres gestion de profil prive et public -->

<%@ page import="entities.Joueur"%>
<%@ page import="java.util.List"%>
<%
	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
    Joueur j_asked = (Joueur)request.getAttribute("asked_player");
    boolean amis = j_logged.hasAmi(j_asked);
    boolean act_profile = (j_asked.getLogin().equals(j_logged.getLogin()));
%>

<div id="templatemo_menu_panel">
	<div id="templatemo_menu_section">
		<ul>
			<li><a href="Accueil.jsp"> Accueil</a></li>
			<li><a href="ListSalons.jsp"> Salon </a></li>
			<li><a href="ListReplays.jsp"> Replays </a></li>
			<li><a href="ListTournois.jsp"> Tournois </a></li>
			<li><a href="ListEquipes.jsp"> Liste des équipe </a></li>
		</ul>
	</div>
</div>
<!-- end of menu -->
<div></div>
<!-- end of container-->
<div></div>
<!-- end of templatemo_background_section_top-->

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>Informations du joueur <%= j_asked.getLogin() %> <%= (amis ? "(Ami)" : "") %></h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
						<li>Nom et prénom : <%= ((j_asked.getPrenom()==null) ? " - " : j_asked.getPrenom()) %>
						 				    <%= ((j_asked.getNom()==null) ? " - " : j_asked.getNom()) %>					
						</li>
						<li>Pseudo : <%=j_asked.getLogin()%></li>
						<li>Sexe : <%= ((j_asked.getSexe()==null) ? " - " : j_asked.getSexe()) %></li>
						<%
						   if(amis) {
					     %>
						 <li>E-mail : <%= j_asked.getMail()%></li>
						 <% } %>
						<li>Equipe : <% if (j_asked.getEquipe()==null) {
									out.print("Sans equipe");
								} else {
									%>
									<a href="ProfilEquipe.jsp?equipe=<%=j_asked.getEquipe().getName()%>">Equipe <%=j_asked.getEquipe().getName()%></a>
									<%
								}%></li>
						<li><a href="hautsFaits.jsp">Hauts Faits</a></li>
						<li><a href="replaysRecents.jsp">Replays</a></li>
						
					</ul>
					<br></br>
					<%
                		if (!act_profile) {
                			if(!amis ) {
						%>
					<form action="UserServlet" >
							<input type="hidden" name="action" value="RajoutAmi">
							<input type="hidden" name="joueurCible" value=<%=j_asked.getLogin()%>>
							<button type="submit" formmethod="post">Rajouter en ami</button>
					</form>
					<% } %>
					<form action="UserServlet" >
							<input type="hidden" name="action" value="BeginDiscussion">
							<input type="hidden" name="joueurCible" value=<%=j_asked.getLogin()%>>
							<button type="submit" formmethod="post" >Inviter à discuter</button>
					</form>
					<%
                		} else {
						%>				                  
						<form action="UserServlet" >
						    <input type="hidden" name="action" value="RajoutAmi">
						    Ajout d'ami : 
						    <label for="joueurCible" class="uname" data-icon="u">Pseudo (*)</label><br/>
                            <input id="joueurCible" name="joueurCible" required="required" type="text" placeholder="pseudo" />
                            <button type="submit" formmethod="post">Rajouter en ami</button>
						</form>
					<%
                		}
						%>
				</div>
			</div>
			<!-- end of section box -->
		</div>
		<!-- end of left section-->
		<% if(act_profile) { %>
		<div id="templatemo_right_section">
          <div class="templatemo_section_box">
            <div class="templatemo_section_box_top">
              <h1>Amis</h1>
            </div>
            <div class="templatemo_section_box_mid">
              <ul>
              <% List<Joueur> list_amis = j_logged.getAmis();
                 for (Joueur j : list_amis) {%>
              	<li><a href="UserServlet?action=profil&login=<%= j.getLogin() %>" id="lien_compte"><%= j.getLogin()%></a></li>            
              <% } %>
              
              </ul>
            </div>
            <div class="templatemo_section_box_bottom"></div>
          </div><!-- end of section box -->
        
        </div><!-- end of right Section -->
        <% } %>
	</div>
	<!-- end of container-->
</div>
<!-- end of background middle-->
<div id="templatemo_bottom_panel">
	<div id="templatemo_bottom_section">
		<div id="templatemo_footer_section">Copyright © 2012 DreamTeam</div>
	</div>
</div>
<body></body>
<html></html>