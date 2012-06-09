<jsp:include page="Header.jsp" />

<%@ page import="entities.Salon"%>
<%@ page import="entities.Equipe"%>
<%@ page import="entities.Partie" %>
<%@ page import="entities.Joueur" %>
<%@ page import="java.util.Set"%>
<%
	Salon s_act = (Salon)request.getAttribute("SalonActuel");
	Joueur j_logged = (Joueur)request.getSession().getAttribute("JoueurActuel");
	// Equipe e_act = s_act.getEquipe();
	
	boolean ismembre=true;

	if(j_logged!=null && s_act.getEquipe()!=null) { 
		ismembre = (s_act.getEquipe().equals(j_logged.getEquipe()));
		System.out.println(ismembre);
	}
%>
	<!-- end of templatemo_background_section_top-->
		<div id="templatemo_background_section_middle">
			<div class="templatemo_container">
				<div id="templatemo_left_section">
					<div class="templatemo_post">
						<div class="templatemo_post_top">
						<% if(ismembre) { %>
							<h1>	
								<%= s_act.getName() %>, le salon des Winners !
							</h1>
							 <% } else {
							 	out.println("<font color=\"red\"> Vous n'avez pas le droit d'entrer ici !</font>");
							  	} %>
						</div>
						<div class="templatemo_post_mid"></div>
					</div>
					<!-- end of section box -->
				</div>
				<!-- end of left section-->
				<!--<div id="templatemo_right_section">
					<div class="templatemo_section_box">
						<div class="templatemo_section_box_top">
							<h1>Liste des replays</h1>
						</div>
						<div class="templatemo_section_box_mid">
							<ul>
								  Set<Partie> list_parties = s_act.getPartie();
                           		 for (Partie p : list_parties) {
                           		
								<li><a 
										href="PartieServlet?action=profil&amp;id= p.getPartieId() ">
									</a>
								</li>
								
							</ul>
						</div>
						<div class="templatemo_section_box_bottom"></div>
					</div> -->
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

