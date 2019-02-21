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
          <h2>Gestión <b>Articulos</b></h2>
        </div>
        <div class="col-sm-6">
        </div>
              </div>
          </div>
          <table class="table table-striped table-hover">
              <thead>
                  <tr>
                    <th>ID</th>
                    <th>Descripcion</th>
                    <th>Modelo</th>
                    <th>Serie</th>
                    <th>Cliente</th>
                    <th>Marca</th>
                    <th>Tipo</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach var="a" items="${articulos}" >
                  <tr>
                    <td>${a.getId()}</td>
                    <td>${a.getDescripcion()}</td>
                    <td>${a.getModelo()}</td>
                    <td>${a.getSerie()}</td>
                    <td>${a.getCliente()}</td>
                    <td>${a.getMarca()}</td>
                    <td>${a.getTipo()}</td>
                  </tr>
                </c:forEach>
              </tbody>
          </table>
          </div>
      </div>
  </jsp:body>
</t:layout>