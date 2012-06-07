<jsp:include page="Header.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
	List<String> listeJoueurs = (List<String>)request.getAttribute("ListeJoueurs");
%>

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>Liste de tous les joueurs de JEEux</h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
					<%
					for(String nick : listeJoueurs) {
					%>	
              	      <li><a href="UserServlet?action=profil&login=<%= nick %>" id="lien_compte"><%= nick %></a></li>     						
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
<div id="templatemo_bottom_panel">
	<div id="templatemo_bottom_section">
		<div id="templatemo_footer_section">Copyright © 2012 DreamTeam</div>
	</div>
</div>
<body></body>
<html></html>