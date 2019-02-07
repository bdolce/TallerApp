<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
          <h2>Gestión <b>Clientes</b></h2>
        </div>
        <div class="col-sm-6">
          <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Nuevo Cliente</span></a>
          <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Eliminar</span></a>            
        </div>
              </div>
          </div>
          <table class="table table-striped table-hover">
              <thead>
                  <tr>
          <th>
            <span class="custom-checkbox">
              <input type="checkbox" id="selectAll">
              <label for="selectAll"></label>
            </span>
          </th>
          <th>ID</th>
                      <th>Nombre</th>
                      <th>Apellido</th>
          <th>Direccion</th>
                      <th>Telefono</th>
                      <th>Email</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
          <td>
            <span class="custom-checkbox">
              <input type="checkbox" id="checkbox1" name="options[]" value="1">
              <label for="checkbox1"></label>
            </span>
          </td>
          <td>01</td>
                      <td>Thomas Hardy</td>
                      <td>thomashardy@mail.com</td>
          <td>89 Chiaroscuro Rd, Portland, USA</td>
                      <td>(171) 555-2222</td>
                      <td>
                          <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                          <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                      </td>
                  </tr>
              </tbody>
          </table>
        <!--<div class="clearfix">
                  <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                  <ul class="pagination">
                      <li class="page-item disabled"><a href="#">Previous</a></li>
                      <li class="page-item"><a href="#" class="page-link">1</a></li>
                      <li class="page-item"><a href="#" class="page-link">2</a></li>
                      <li class="page-item active"><a href="#" class="page-link">3</a></li>
                      <li class="page-item"><a href="#" class="page-link">4</a></li>
                      <li class="page-item"><a href="#" class="page-link">5</a></li>
                      <li class="page-item"><a href="#" class="page-link">Next</a></li>
                  </ul>
            </div>-->
          </div>
      </div>
      
    <!-- Modales HTML -->
    <div id="addEmployeeModal" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form>
            <div class="modal-header">            
              <h4 class="modal-title">Añadir Cliente</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">          
              <div class="form-group">
                <label>Name</label>
                <input type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Address</label>
                <textarea class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Phone</label>
                <input type="text" class="form-control" required>
              </div>          
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
              <input type="submit" class="btn btn-success" value="Add">
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="editEmployeeModal" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form>
            <div class="modal-header">            
              <h4 class="modal-title">Editar Cliente</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">  
              <div class="form-group">
                <label>ID</label>
                <input type="text" class="form-control" required>
              </div>        
              <div class="form-group">
                <label>Nombre</label>
                <input type="text" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Apellido</label>
                <input type="email" class="form-control" required>
              </div>
              <div class="form-group">
                <label>Direccion</label>
                <textarea class="form-control" required></textarea>
              </div>
              <div class="form-group">
                <label>Telefono</label>
                <input type="text" class="form-control" required>
              </div>  
              <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control">
              </div>        
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
              <input type="submit" class="btn btn-info" value="Save">
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- Delete Modal HTML -->
    <div id="deleteEmployeeModal" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <form>
            <div class="modal-header">            
              <h4 class="modal-title">Eliminar Cliente</h4>
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">          
              <p>¿Está seguro que desea eliminar el cliente?</p>
              <p class="text-warning"><small>Esta acción no puede deshacerse.</small></p>
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
              <input type="submit" class="btn btn-danger" value="Delete">
            </div>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</t:layout>