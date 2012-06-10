<jsp:include page="Header.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="entities.Salon" %>
<%@ page import="entities.Equipe" %>
<%
	List<Salon> listeSalons = (List<Salon>)request.getAttribute("ListeSalons");
%>

		<div id="templatemo_background_section_middle">
			<div class="templatemo_container">
				<div id="templatemo_left_section">
					<div class="templatemo_post">
						<div class="templatemo_post_top">
							<h1>Liste de tous les salons de JEEux</h1>
						</div>
						<div class="templatemo_post_mid">
							<ul>
							<%
							for(Salon s : listeSalons) {
								String sname = s.getName();
								String ename = "-";
								if (s.getEquipe()!=null) { 
									Equipe e  = s.getEquipe();
									ename = e.getName();
								}
							%>	
              	      			<li>
              	      				<a href="SalonServlet?action=profilSalon&sname=<%= sname %>">
              	      					<%= sname %>
              	     				</a>
              	     				(<a href="EquipeServlet?action=profilEquipe&ename=<%= ename %>">
              	      					<%= ename %>
              	     				</a>)
              	      			</li>     						
							<% } %>
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
