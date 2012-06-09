<jsp:include page="Header.jsp" />

<!-- page accessible uniquement accessible si connecté apres gestion de profil prive et public -->

<%@ page import="entities.Joueur"%>
<%@ page import="entities.Equipe"%>
<%@ page import="entities.Tournoi"%>
<%@ page import="java.util.Set"%>
<%
	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
	Tournoi t_act = (Tournoi)request.getAttribute("TournoiActuel");

	boolean hasequipe=j_logged.hasEquipe();
	boolean isEquipeChef=(hasequipe? j_logged.getEquipe().getChef().equals(j_logged) : false);
	boolean isTournoiManager = t_act.getManager().equals(j_logged);
	boolean equipeInTournoi=false;
	
	Set<Equipe> list_equipes = t_act.getEquipes_participantes().keySet();
	
	if(j_logged.hasEquipe()) {
    	for (Equipe e : list_equipes) {
    		if(e.equals(j_logged.getEquipe())) {
    			equipeInTournoi=true;
    		}
   		}
	}
	
%>
<!-- end of templatemo_background_section_top-->

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>
						Informations sur le tournoi
						<%= t_act.getNom() %> <%= (isTournoiManager? " (Manager)" : "") %>
					</h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
						<li>Manager : <a
							href="UserServlet?action=profil&amp;login=<%= t_act.getManager().getLogin() %>"
							id="lien_compte"><%= t_act.getManager().getLogin() + " de l'équipe " + t_act.getManager().getEquipe().getName() %></a>
						</li>
						<% if(t_act.getNombre_max_equipes()!=-1) { %>
						<li>Nombre maximum d'équipes : <%= t_act.getNombre_max_equipes().toString() %></li>
						<% } %>
						<% 
						if(isEquipeChef && !equipeInTournoi) {  %>
							<form action="TournoiServlet">
								<input type="hidden" name="action" value="joindreTournoi">
								<input type="hidden" name="ename" value="<%=j_logged.getEquipe().getName()%>">
								<input type="hidden" name="tname" value="<%=t_act.getNom()%>">
								<button type="submit" formmethod="post">Rejoindre le tournoi ( Equipe <%= j_logged.getEquipe().getName() %> )</button>
							</form>
						<% } %>
					</ul>
					<br></br>
					
				</div>
				<%if(isTournoiManager) { %>
				<div class="templatemo_post_bottom">
					<form action="TournoiServlet">
						<input type="hidden" name="action" value="FinirTournoi">
						<input type="hidden" name="tname"  value="<%=t_act.getNom()%>">
						<button type="submit" formmethod="post">Finir le tournoi</button>
					</form>
				</div>
				<% } %>
			</div>
			<!-- end of section box -->
		</div>
		<!-- end of left section-->
		<div id="templatemo_right_section">
			<div class="templatemo_section_box">
				<div class="templatemo_section_box_top">
					<h1>Liste des équipes participantes</h1>
				</div>
				<div class="templatemo_section_box_mid">
					<ul>
						<% 
                           for (Equipe e : list_equipes) {
                           	%>
						<li>
						
						<a href="EquipeServlet?action=profilEquipe&ename=<%= e.getName() %>"	id="lien_profilequipe"><%= e.getName()%></a> Score : <%= t_act.getEquipes_participantes().get(e).toString() %>	
							<% if(isTournoiManager && !(j_logged.getEquipe().equals(e))) { %>
							<form action="TournoiServlet">									
								<input type="hidden" name="action" value="SupprEquipe">
								<input type="hidden" name="ename" value="<%=e.getName()%>">	
								<input type="hidden" name="tname" value="<%=t_act.getNom()%>">							
								<button type="submit" formmethod="post">Exclure</button>
						    </form>	
							<% } %>
											
							</li>
						<%  
                           	}%>

					</ul>
				</div>
				<div class="templatemo_section_box_bottom"></div>
			</div>
			<!-- end of section box -->

		</div>
		<!-- end of right Section -->
	</div>
	<!-- end of container-->
</div>
<!-- end of background middle-->
<div id="templatemo_bottom_panel">
	<div id="templatemo_bottom_section">
		<div id="templatemo_footer_section">Copyright © 2012 DreamTeam</div>
	</div>
</div>
</body>
</html>