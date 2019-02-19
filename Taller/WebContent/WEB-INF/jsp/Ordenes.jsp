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
          <h2>Gestión <b>Ordenes de Reparacion</b></h2>
        </div>
        <div class="col-sm-6">
          <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Nuevo Cliente</span></a>
        </div>
              </div>
          </div>
          <table class="table table-striped table-hover">
              <thead>
                  <tr>
                    <th>ID</th>
                    <th>Articulo</th>
                    <th>Fecha Ingreso</th>
                    <th>Fecha Retiro</th>
                    <th>Estado</th>
                    <th>Accesorios</th>
                    <th>Prioridad</th>
                    <th>Cliente</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach var="o" items="${ordenes}" >
                  <tr>
                    <td>${o.getId()}</td>
                    <td>${o.getArticulo().getDescripcion()}</td>
                    <td>${o.getFechaIngreso()}</td>
                    <td>${o.getFechaRetiro()}</td>
                    <td>${o.getEstado()}</td>
                    <td>${o.getAccesorios()}</td>
                    <td>${o.getPrioridad()}</td>
                    <td>${o.getArticulo().getCliente()}</td>
                    <td>
                      <a href="#editarCliente" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
          </table>
          </div>
      </div>
  </jsp:body>
</t:layout>