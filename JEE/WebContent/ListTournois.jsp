<jsp:include page="Header.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entities.Equipe" %>
<%
	List<String> listeTournois = (List<String>)request.getAttribute("ListeTournois");
%>

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>Liste de tous les tournois actifs dans JEEux</h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
					<%
					for(String tname : listeTournois) {		
					%>	
              	      <li>
              	      <a href="TournoiServlet?action=profilTournoi&tname=<%= tname %>" id="lien_compte">
              	      <%= tname %>
              	      </a>
              	      </li>     						
					<%
					}
					%>
					</ul>
				</div>
			</div>

		</div>
		<!-- end of left section-->
		<div id="templatemo_right_section"></div>
		<!-- end of right Section -->
	</div>
	<!-- end of container-->
</div>
<!-- end of background middle-->

<jsp:include page="Footer.jsp" />
