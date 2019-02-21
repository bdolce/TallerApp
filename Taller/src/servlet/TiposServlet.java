package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tipo;
import negocio.TipoLogica;

/**
 * Servlet implementation class TiposServlet
 */
@WebServlet("/Tipos")
public class TiposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoLogica tl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiposServlet() {
        super();
        tl = new TipoLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("UsuarioLogeado") == null) {
			response.sendRedirect("Login");
		} else {
			listarTipos(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaTipo(request);
		} else if (accion.equals("editar")) {
			editarTipo(request);
		}
		
		listarTipos(request, response);
		
	}
	
	private void altaTipo(HttpServletRequest request) {
		//Traer parametros del form
		String descripcion = request.getParameter("tip-descripcion");
		
		//Crear la entidad nueva y darla de alta en BD
		try {
			Tipo tipo = new Tipo(descripcion);
			tl.crearTipo(tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void editarTipo(HttpServletRequest request) {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("tip-id"));
		String descripcion = request.getParameter("tip-descripcion");

		//Crear la entidad nueva y actualizarla en La BD
		try {
			Tipo tipo = new Tipo(id, descripcion);
			tl.actualizarTipo(tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void listarTipos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("tipos",tl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Tipos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
