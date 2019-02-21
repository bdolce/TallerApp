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
              <a href="#nuevaOrden" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Nueva Orden</span></a>
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
                    <a href="#editarOrden" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
      </div>
    </div>
    
    <!-- Modales HTML -->
    <div id="nuevaOrden" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formNuevo" method="post" action="Ordenes">
            <div class="modal-header">            
              <h4 class="modal-title">Añadir Orden</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">   
              <input type="hidden" name="accion" value="alta" />   
              <div class="form-group">
                <label>Articulo</label>
                <select class="custom-select" id="modal-articulo" name="ord-articulo">
                  <c:forEach var="a" items="${articulos}">
                    <option value="${a.getId()}">${a.getDescripcion()}</option>
                  </c:forEach>
                </select> 
              </div>     
              <div class="form-group">
                <label>Fecha Ingreso</label>
                <input type="date" id="modal-fechaingreso" class="form-control" name="ord-fechaIngreso" required>
              </div>
              <div class="form-group">
                <label>Observaciones</label>
                <input type="text" id="modal-observaciones" class="form-control" name="ord-observaciones">
              </div>
              <div class="form-group">
                <label>Accesorios</label>|
                <input type="text" id="modal-accesorios" class="form-control" name="ord-accesorios">
              </div>
              <div class="form-group">
                <label>Prioridad</label>
                <input type="number" id="modal-prioridad" class="form-control" name="ord-prioridad" value="1" min="1" max="3" step="1" required>
              </div>
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
              <input type="submit" class="btn btn-success" value="Agregar">
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="editarArticulo" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formEditar" method="post" action="Ordenes">
            <div class="modal-header">            
              <h4 class="modal-title">Editar Orden</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">  
              <div class="form-group">
                <label>ID</label>
                <input type="text" id="modal-id" class="form-control" name="art-id" required>
              </div> 
              <input type="hidden" name="accion" value="editar" />
              <div class="form-group">
                <label>Cliente</label>
                <select class="custom-select" id="modal-cliente" name="art-cliente">
                  <c:forEach var="c" items="${clientes}">
                    <option value="${c.getId()}">${c}</option>
                  </c:forEach>
                </select> 
              </div>     
              <div class="form-group">
                <label>Tipo</label>
                <select class="custom-select" id="modal-tipo" name="art-tipo">
                  <c:forEach var="t" items="${tipos}">
                    <option value="${t.getId()}">${t}</option>
                  </c:forEach>
                </select> 
              </div>     
              <div class="form-group">
                <label>Marca</label>
                <select class="custom-select" id="modal-marca" name="art-marca">
                  <c:forEach var="m" items="${marcas}">
                    <option value="${m.getId()}">${m}</option>
                  </c:forEach>
                </select> 
              </div>     
              <div class="form-group">
                <label>Modelo</label>
                <input type="text" id="modal-modelo" class="form-control" name="art-modelo" required>
              </div>
              <div class="form-group">
                <label>Serie</label>
                <input type="text" id="modal-serie" class="form-control" name="art-serie" required>
              </div>      
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
              <input type="submit" class="btn btn-success" value="Agregar">
            </div>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</t:layout>