<jsp:include page="Header.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entities.Equipe" %>
<%
	List<Equipe> listeEquipes = (List<Equipe>)request.getAttribute("ListeEquipes");
%>

<div id="templatemo_background_section_middle">
	<div class="templatemo_container">
		<div id="templatemo_left_section">
			<div class="templatemo_post">
				<div class="templatemo_post_top">
					<h1>Liste de toutes les équipes de JEEux</h1>
				</div>
				<div class="templatemo_post_mid">
					<ul>
					<%
					for(Equipe e : listeEquipes) {
						String ename = e.getName();
						String slogan = e.getSlogan();
					%>	
              	      <li>
              	      <a href="EquipeServlet?action=profilEquipe&ename=<%= ename %>" id="lien_compte">
              	      <%= ename %> <%= ((slogan==null) ? "" : (" : "+slogan)) %>
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
