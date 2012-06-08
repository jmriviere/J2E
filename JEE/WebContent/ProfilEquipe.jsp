<jsp:include page="Header.jsp" />

<!-- page accessible uniquement accessible si connecté apres gestion de profil prive et public -->

<%@ page import="entities.Joueur"%>
<%@ page import="entities.Equipe"%>
<%@ page import="java.util.Set"%>
<%
	Equipe e_act = (Equipe)request.getAttribute("EquipeActuelle");
	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
	Joueur j_chef = e_act.getChef();
	
	boolean ischef=false; 
	boolean ismembre=false;
	boolean hasequipe=true;
	boolean hascandidature=true;
	if(j_logged!=null) {
		ischef = (j_logged.getLogin().equals(j_chef.getLogin())); 
		ismembre = e_act.getMembre().contains(j_logged);
		hasequipe = j_logged.hasEquipe(); 
		hascandidature = j_logged.hasCandidature();
	}
%>
<!-- end of templatemo_background_section_top-->

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>
						Informations sur l'équipe
						<%= e_act.getName() %> <%= ( ismembre? "Membre" : "") %>
					</h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
						<li>Chef d'équipe : <a
							href="UserServlet?action=profil&amp;login=<%= j_chef.getLogin() %>"
							id="lien_compte"><%= j_chef.getLogin()%></a>
						</li>
						<li>Slogan : <%=((e_act.getSlogan()==null) ? "" : e_act.getSlogan())%></li>
						
						<% if(!hasequipe && !hascandidature) {  %>
							<form action="UserServlet">
								<input type="hidden" name="action" value="joinEquipe">
								<input type="hidden" name="ename"  value="<%=e_act.getName()%>">
								<button type="submit" formmethod="post">Rejoindre</button>
							</form>
						<% } %>
					</ul>
					<br></br>
					
				</div>
				<%if(ischef) { %>
				<div class="templatemo_post_bottom">
					<form action="UserServlet">
						<input type="hidden" name="action" value="SupprEquipe">
						<input type="hidden" name="ename"  value="<%=e_act.getName()%>">
						<button type="submit" formmethod="post">Dissoudre l'équipe</button>
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
					<h1>Liste des membres</h1>
				</div>
				<div class="templatemo_section_box_mid">
					<ul>
						<% Set<Joueur> list_membres = e_act.getMembre();
                           for (Joueur j : list_membres) {
                           	%>
						<li><a
							href="UserServlet?action=profil&amp;login=<%= j.getLogin() %>"
							id="lien_compte"><%= j.getLogin()%></a>
							
							<% if(ischef && !j.equals(j_logged)) { %>
							<form action="UserServlet">									
								<input type="hidden" name="action" value="SupprEquipe">
								<input type="hidden" name="player" value="<%=j.getLogin()%>">								
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
			
			<% if(ischef) { %>
			
			<div class="templatemo_section_box">
				<div class="templatemo_section_box_top">
					<h1>Liste des candidatures</h1>
				</div>
				<div class="templatemo_section_box_mid">
					<ul>
						<% Set<Joueur> list_candidatures = e_act.getCandidats();
                           for (Joueur j : list_candidatures) {%>
						<li>
						
						<a href="UserServlet?action=profil&amp;login=<%= j.getLogin() %>"id="lien_compte"><%= j.getLogin()%></a>
						
						
						<form action="UserServlet">									
							<input type="hidden" name="action" value="AccCandidature">	
							<input type="hidden" name="player" value="<%=j.getLogin()%>">							
							<button type="submit" formmethod="post">Accepter</button>
						</form>	
						<form action="UserServlet">									
							<input type="hidden" name="action" value="SupprCandidature">	
							<input type="hidden" name="player" value="<%=j.getLogin()%>">							
							<button type="submit" formmethod="post">Refuser</button>
						</form>
						</li>
						<% } %>

					</ul>
				</div>
				<div class="templatemo_section_box_bottom"></div>
			</div>
			<!-- end of section box -->
			<% } %>

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
<body></body>
<html></html>