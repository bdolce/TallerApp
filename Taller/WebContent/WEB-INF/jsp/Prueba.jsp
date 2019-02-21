<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:base>
  <jsp:attribute name="titulo">Marcas</jsp:attribute>
  <jsp:attribute name="tabla">
    <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Marca</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="m" items="${marcas}" >
            <tr>
              <td>${m.getId()}</td>
              <td>${m.getNombre()}</td>
              <td>
                <a href="#editarMarca" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
  </jsp:attribute>
  <jsp:attribute name="modal">
    <!-- Modales HTML -->
    <div id="nuevaMarca" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formNuevo" method="post" action="Marcas">
            <div class="modal-header">            
              <h4 class="modal-title">Añadir Marca</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">   
              <input type="hidden" name="accion" value="alta" />       
              <div class="form-group">
                <label>Nombre</label>
                <input type="text" id="modal-nombre" class="form-control" name="mar-nombre" required>
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
    <div id="editarMarca" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formEditar" method="post" action="Marcas">
            <div class="modal-header">            
              <h4 class="modal-title">Editar Marca</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">  
              <input type="hidden" name="accion" value="editar">
              <div class="form-group">
                <label>ID</label>
                <input type="text" id="modal-id" class="form-control" name="mar-id" readonly required>
              </div>        
              <div class="form-group">
                <label>Nombre</label>
                <input type="text" id="modal-nombre" class="form-control" name="mar-nombre" required>
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
          $("#formEditar #modal-nombre").val(td_nombre);
      });
      
    </script>
  </jsp:attribute>
</t:base>