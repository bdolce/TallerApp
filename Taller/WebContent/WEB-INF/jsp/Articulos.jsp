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
              <a href="#nuevoArticulo" id ="btnNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Nuevo Articulo</span></a>
            </div>
            <div class="col-sm-6"></div>
          </div>
        </div>
        <div class="table-responsive">
          <table class="table table-striped table-hover">
              <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Serie</th>
                    <th scope="col">Cliente</th>
                  </tr>
              </thead>
              <tbody>
                <c:forEach var="a" items="${articulos}" >
                  <tr scope="row">
                    <td>${a.getId()}</td>
                    <td>${a.getDescripcion()}</td>
                    <td>${a.getModelo()}</td>
                    <td>${a.getSerie()}</td>
                    <td>${a.getCliente()}</td>
                    <td>
                      <a href="#editarArticulo" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
          </table>
        </div>
      </div>
    </div>
    
    <!-- Modales HTML -->
    <div id="nuevoArticulo" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formNuevo" method="post" action="Articulos">
            <div class="modal-header">            
              <h4 class="modal-title">Añadir Articulo</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">   
              <input type="hidden" name="accion" value="alta" />
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
    <!-- Edit Modal HTML -->
    <div id="editarArticulo" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form id="formEditar" method="post" action="Articulos">
            <div class="modal-header">            
              <h4 class="modal-title">Editar Articulo</h4>
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
    
    <script>
      $(".edit").click(function() {
          var $row = $(this).closest("tr")   // Finds the closest row <tr> 
          //Find the <td> children elements
          var td_id = $row.find("td:nth-child(1)").text()
          var td_cliente = $row.find("td:nth-child(2)").text()
          var td_tipo = $row.find("td:nth-child(3)").text()
          var td_marca = $row.find("td:nth-child(4)").text()
          var td_modelo = $row.find("td:nth-child(3)").text()
          var td_serie = $row.find("td:nth-child(4)").text()
          
          //Set modal control values
          $("#formEditar #modal-id").val(td_id);
          $("#formEditar #modal-cliente").val(td_cliente);
          $("#formEditar #modal-tipo").val(td_tipo);
          $("#formEditar #modal-marca").val(td_marca);
          $("#formEditar #modal-modelo").val(td_modelo);
          $("#formEditar #modal-serie").val(td_serie);
      });
      
    </script>
  </jsp:body>
</t:layout>