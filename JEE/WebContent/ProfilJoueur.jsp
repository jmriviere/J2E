<jsp:include page="Header.jsp" />

<!-- page accessible uniquement accessible si connecté apres gestion de profil prive et public -->

<%@ page import="entities.Joueur"%>
<%@ page import="entities.Equipe"%>
<%@ page import="java.util.Set"%>
<%
	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
    Joueur j_asked = (Joueur)request.getAttribute("asked_player");
    if(j_asked==null) {
    	j_asked=j_logged;
    }
    boolean amis = j_logged.hasAmi(j_asked);
    boolean act_profile = (j_asked.getLogin().equals(j_logged.getLogin()));    
%>
<!-- end of templatemo_background_section_top-->

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>
						Informations du joueur
						<%= j_asked.getLogin() %>
						<%= (amis ? "(Ami)" : "") %></h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
						<li>Nom et prénom : <%= ((j_asked.getPrenom()==null) ? " - " : j_asked.getPrenom()) %>
							<%= ((j_asked.getNom()==null) ? " - " : j_asked.getNom()) %>
						</li>
						<li>Pseudo : <%=j_asked.getLogin()%></li>
						<li>Sexe : <%= ((j_asked.getSexe()==null) ? " - " : j_asked.getSexe()) %></li>
						<%
						   if(amis || act_profile) {
					     %>
						<li>E-mail : <%= j_asked.getMail()%></li>
						<% } %>
						<li>Equipe : <% if (j_asked.getEquipe()==null) {
									out.print("Sans equipe");
								} else {
									%> <a
							href="ProfilEquipe.jsp?equipe=<%=j_asked.getEquipe().getName()%>">Equipe
								<%=j_asked.getEquipe().getName()%></a> <%
								}%></li>
						<li><a href="hautsFaits.jsp">Hauts Faits</a></li>
						<li><a href="replaysRecents.jsp">Replays</a></li>

					</ul>
					<br></br>
					<%
                		if (!act_profile) {
                			if(!amis ) {
						%>
					<form action="UserServlet">
						<input type="hidden" name="action" value="RajoutAmi"> <input
							type="hidden" name="joueurCible" value="<%=j_asked.getLogin()%>">
						<button type="submit" formmethod="post">Rajouter en ami</button>
					</form>
					<% } %>
					<form action="UserServlet">
						<input type="hidden" name="action" value="BeginDiscussion">
						<input type="hidden" name="joueurCible"
							value="<%=j_asked.getLogin()%>">
						<button type="submit" formmethod="post">Inviter à
							discuter</button>
					</form>
					<%
                		} else {
                			if(j_logged.hasCandidature()) {
                				Equipe e = j_logged.getCandidature();
                				String ename = e.getName();
                				%>
					<form action="UserServlet">
						<input type="hidden" name="action" value="SupprCandidature">
						Candidature actuelle : <a href="NavigationServlet?action=profilEquipe&ename=<%= ename %>"	id="lien_profilequipe"><%= ename%></a>
						<button type="submit" formmethod="post">Annuler la candidature</button>
					</form>
					<%
                			} else if(j_logged.hasEquipe()) {
                				Equipe e = j_logged.getEquipe();
                				String ename = e.getName();
						        %>
					<form action="UserServlet">
						<input type="hidden" name="action" value="SupprEquipe">
						Equipe actuelle : <a href="NavigationServlet?action=profilEquipe&ename=<%= ename %>"	id="lien_profilequipe"><%= ename%></a>
						<button type="submit" formmethod="post">Quitter l'equipe</button>
					</form>
					<%
                			} %>
					<form action="UserServlet">
						<input type="hidden" name="action" value="RajoutAmi">
						Ajout d'ami : <br /> <label for="joueurCible" class="uname"
							data-icon="u">Pseudo (*)</label><br /> <input id="joueurCible"
							name="joueurCible" required="required" type="text"
							placeholder="pseudo" />
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
						<% Set<Joueur> list_amis = j_logged.getAmis();
                 for (Joueur j : list_amis) {%>
						<li><a
							href="UserServlet?action=profil&amp;login=<%= j.getLogin() %>"
							id="lien_compte"><%= j.getLogin()%></a></li>
						<% } %>

					</ul>
				</div>
				<div class="templatemo_section_box_bottom"></div>
			</div>
			<!-- end of section box -->

		</div>
		<!-- end of right Section -->
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