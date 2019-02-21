package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Falla;
import negocio.FallaLogica;

/**
 * Servlet implementation class FallaServlet
 */
@WebServlet("/Fallas")
public class FallasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FallaLogica fl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FallasServlet() {
        super();
        fl = new FallaLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarFallas(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaFalla(request);
		} else if (accion.equals("editar")) {
			editarFalla(request);
		}
		
		listarFallas(request, response);
		
	}
	
	private void altaFalla(HttpServletRequest request) {
		//Traer parametros del form
		String descripcion = request.getParameter("fal-descripcion");
		
		//Crear la entidad nueva y darla de alta en BD
		try {
			Falla falla = new Falla(descripcion);
			fl.crearFalla(falla);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void editarFalla(HttpServletRequest request) {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("fal-id"));
		String descripcion = request.getParameter("fal-descripcion");

		//Crear la entidad nueva y actualizarla en La BD
		try {
			Falla falla = new Falla(id, descripcion);
			fl.actualizarFalla(falla);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void listarFallas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("fallas",fl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Fallas.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
