<jsp:include page="Header.jsp" />
<div id="templatemo_background_section_middle">
  <div class="templatemo_container">
    <div id="templatemo_left_section">
      <object type="application/x-java-applet" height="525" width="750">
        <param name="code" value="Morpion.class" />
        <% 
        String numJoueur = request.getParameter("numeroJoueur");
        if (numJoueur != null) {
          out.println("<param name=\"numeroJoueur\" value=\"" + numJoueur + "\" />");
        }
        %>
        <p> Applet failed to run.  No Java plug-in was found. </p>
      </object>
    </div>

<jsp:include page="Footer.jsp" />

