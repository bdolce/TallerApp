package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Articulo;
import entidades.Orden;
import negocio.ArticuloLogica;
import negocio.OrdenLogica;

/**
 * Servlet implementation class Ordenes
 */
@WebServlet("/Ordenes")
public class OrdenesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdenLogica ol = null;
    private ArticuloLogica al = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenesServlet() {
        super();
        ol = new OrdenLogica();
        al = new ArticuloLogica();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("UsuarioLogeado") == null) {
			response.sendRedirect("Login");
		} else {
			listarOrdenes(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaOrden(request);
		} else if (accion.equals("editar")) {
			editarOrden(request);
		}
		
		listarOrdenes(request, response);
		
	}
	
	private void altaOrden(HttpServletRequest request) {
		
		try {
			//Traer parametros del form
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaIngreso  = formatoFecha.parse(request.getParameter("ord-fechaIngreso"));
			String observaciones = request.getParameter("ord-observaciones");
			String accesorios = request.getParameter("ord-accesorios");
			int prioridad = Integer.parseInt(request.getParameter("ord-prioridad"));
			int id_articulo = Integer.parseInt(request.getParameter("ord-articulo"));
			
			//Mapear las subentidades 
			Articulo a = new Articulo();
			a.setId(id_articulo);
			Articulo articulo = al.getOneById(a);
			
			//Crear la entidad nueva y darla de alta en la BD
			Orden orden = new Orden(fechaIngreso, observaciones, accesorios, prioridad, articulo);
			orden.setEstado("No Revisado");
			ol.crearOrden(orden);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	};
	
	private void editarOrden(HttpServletRequest request) {
		
	};
	
	private void listarOrdenes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("ordenes",ol.getAll());
			request.setAttribute("articulos", al.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Ordenes.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
