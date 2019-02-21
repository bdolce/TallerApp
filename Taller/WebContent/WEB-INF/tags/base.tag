<%@tag description="HTML Layout Template" pageEncoding="UTF-8"%>
<%@attribute name='tabla' fragment="true" required="false" %>
<%@attribute name='modal' fragment="true" required="false" %>
<%@attribute name='titulo' fragment="true" required="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:layout>
  <jsp:attribute name="head"> <!-- Referencias extra que se añaden a las de la base (OJO SI EL COMENTARIO ESTA EN LA LINEA ANTERIOR SE ROMPE) -->
    <link rel="stylesheet" href="style/css/custom/crud.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  </jsp:attribute>
  <jsp:body>
      <!-- Contenido que se extiende en la plantilla base -->
    <div class="container">
      <div class="table-wrapper">
        <div class="table-title">
          <div class="row">
            <div class="col-sm-6">
              <h2>Gestión <b><jsp:invoke fragment="titulo"></jsp:invoke>  </b></h2>
            </div>
            <div class="col-sm-6"></div>
          </div>
        </div>
        <div class="table-responsive">
              <jsp:invoke fragment="tabla"></jsp:invoke>  
        </div>
      </div>
          <jsp:invoke fragment="modal"></jsp:invoke>  
    </div>
  </jsp:body>
</t:layout>