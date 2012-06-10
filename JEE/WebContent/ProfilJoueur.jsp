<jsp:include page="Header.jsp" />

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
    boolean chef_equipe = false;
    if(j_asked.hasEquipe()) {
    	chef_equipe=(j_asked.getEquipe().getChef().equals(j_asked));
    }
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
									%> 
									<a href="EquipeServlet?action=profilEquipe&ename=<%= j_asked.getEquipe().getName() %>"	id="lien_profilequipe"><%= j_asked.getEquipe().getName()%> <%= ( (chef_equipe)? "(Chef d'�quipe)" : "" ) %></a>
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
						Candidature actuelle : <a href="EquipeServlet?action=profilEquipe&ename=<%= ename %>"	id="lien_profilequipe"><%= ename%></a></br>
						<button type="submit" formmethod="post">Annuler la candidature</button>
					</form>
					<%
                			} else if(j_logged.hasEquipe()) {
                				Equipe e = j_logged.getEquipe();
                				String ename = e.getName();
						        %>
					<form action="UserServlet">
						<input type="hidden" name="action" value="SupprEquipe">
				        <input type="hidden" name="ename"  value="<%=ename%>">	
						Equipe actuelle : <a href="EquipeServlet?action=profilEquipe&ename=<%= ename %>"	id="lien_profilequipe"><%= ename%></a>
						<button type="submit" formmethod="post">
						<%= ( (j_logged.getEquipe().getChef().getLogin().equals(j_logged.getLogin()))? "Dissoudre l'équipe" : " Quitter l'�quipe")%>
						</button>
					</form>
					<%
                			} %>
					<form action="UserServlet">
						<input type="hidden" name="action" value="RajoutAmi">
						Ajout d'ami : <br /> 
					    <input id="joueurCible"
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
						<% Set<Joueur> list_amis = j_logged.getAmis().keySet();
                 for (Joueur j : list_amis) {
                 	if(j_logged.getAmiType(j).equals("A")) { %>
						<li><a
							href="UserServlet?action=profil&amp;login=<%= j.getLogin() %>"
							id="lien_compte"><%= j.getLogin()%></a>
							
						<form action="UserServlet">									
								<input type="hidden" name="action" value="SupprAmi">
								<input type="hidden" name="player" value="<%=j.getLogin()%>">								
								<button type="submit" formmethod="post">Supprimer</button>
						</form>	
							
						</li>
						<% } 
						 } %>

					</ul>
				</div>
				<div class="templatemo_section_box_bottom"></div>
			</div>
			<!-- end of section box -->

			<div class="templatemo_section_box">
				<div class="templatemo_section_box_top">
					<h1>Demande d'amis</h1>
				</div>
				<div class="templatemo_section_box_mid">
					<ul>
						<% Set<Joueur> list_candidats_amis = j_logged.getAmis().keySet();
                 		for (Joueur j : list_candidats_amis) {
                 		  if(j_logged.getAmiType(j).equals("IC")) { %>
						<li><a
							href="UserServlet?action=profil&amp;login=<%= j.getLogin() %>"
							id="lien_compte"><%= j.getLogin()%></a>
							
						<form action="UserServlet">									
							<input type="hidden" name="action" value="AccCandidatureAmi">	
							<input type="hidden" name="player" value="<%=j.getLogin()%>">							
							<button type="submit" formmethod="post">Accepter</button>
						</form>	
						<form action="UserServlet">									
							<input type="hidden" name="action" value="SupprCandidatureAmi">	
							<input type="hidden" name="player" value="<%=j.getLogin()%>">							
							<button type="submit" formmethod="post">Refuser</button>
						</form>							
							
						</li>
						<% } 
						} %>

					</ul>
				</div>
				<div class="templatemo_section_box_bottom"></div>
			</div>

		</div>
		<!-- end of right Section -->
		<% } %>
	</div>
	<!-- end of container-->
</div>
<!-- end of background middle-->

<jsp:include page="Footer.jsp" />

