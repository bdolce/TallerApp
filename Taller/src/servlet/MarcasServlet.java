package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Marca;
import negocio.MarcaLogica;

/**
 * Servlet implementation class MarcaServlet
 */
@WebServlet("/Marcas")
public class MarcasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MarcaLogica ml = null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcasServlet() {
        super();
        ml = new MarcaLogica();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarMarcas(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaMarca(request);
		} else if (accion.equals("editar")) {
			editarMarca(request);
		}
		
		listarMarcas(request, response);
		
	}
	
	private void altaMarca(HttpServletRequest request) {
		//Traer parametros del form
		String nombre = request.getParameter("mar-nombre");
		
		//Crear la entidad nueva y darla de alta en BD
		try {
			Marca marca = new Marca(nombre);
			ml.crearMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void editarMarca(HttpServletRequest request) {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("mar-id"));
		String nombre = request.getParameter("mar-nombre");

		//Crear la entidad nueva y actualizarla en La BD
		try {
			Marca marca = new Marca(id, nombre);
			ml.actualizarMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void listarMarcas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("marcas",ml.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Marcas.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
