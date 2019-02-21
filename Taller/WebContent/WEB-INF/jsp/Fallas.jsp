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
            <div class="col-sm-6">
              <a href="#nuevaFalla" id ="btnNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Nuevo Falla</span></a>
            </div>
          </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th>ID</th>
                <th>Descripcion</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="f" items="${fallas}" >
                <tr>
                  <td>${f.getId()}</td>
                  <td>${f.getDescripcion()}</td>
                  <td>
                    <a href="#editarFalla" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
      </div>
    </div>
      
    <!-- Modales HTML -->
    <div id="nuevaFalla" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formNuevo" method="post" action="Fallas">
            <div class="modal-header">            
              <h4 class="modal-title">Añadir Falla</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">   
              <input type="hidden" name="accion" value="alta" />       
              <div class="form-group">
                <label>Descripcion</label>
                <input type="text" id="modal-nombre" class="form-control" name="fal-descripcion" required>
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
    <div id="editarFalla" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formEditar" method="post" action="Fallas">
            <div class="modal-header">            
              <h4 class="modal-title">Editar Falla</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">  
              <input type="hidden" name="accion" value="editar">
              <div class="form-group">
                <label>ID</label>
                <input type="text" id="modal-id" class="form-control" name="fal-id" readonly required>
              </div>        
              <div class="form-group">
                <label>Descripcion</label>
                <input type="text" id="modal-descripcion" class="form-control" name="fal-descripcion" required>
              </div>
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
              <input type="submit" class="btn btn-info" value="Guardar">
            </div>
          </form>
        </div>
      </div>
    </div>
    
    <script>
      $(".edit").click(function() {
          var $row = $(this).closest("tr")   // Finds the closest row <tr> 
          //Find the <td> children elements
          var td_id = $row.find("td:nth-child(1)").text()
          var td_nombre = $row.find("td:nth-child(2)").text()
          
          //Set modal control values
          $("#formEditar #modal-id").val(td_id);
          $("#formEditar #modal-descripcion").val(td_nombre);
      });
      
    </script>
  </jsp:body>
</t:layout>