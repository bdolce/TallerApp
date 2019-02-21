<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
              <h2>Gestión <b>Fallas</b></h2>
            </div>
            <div class="col-sm-6"></div>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</t:layout>