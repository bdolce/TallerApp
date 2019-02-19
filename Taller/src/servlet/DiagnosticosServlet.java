package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Diagnostico;
import negocio.DiagnosticoLogica;

/**
 * Servlet implementation class DiagnosticoServlet
 */
@WebServlet("/Diagnosticos")
public class DiagnosticosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiagnosticoLogica dl = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosticosServlet() {
        super();
        dl = new DiagnosticoLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarDiagnosticos(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaDiagnostico(request);
		} else if (accion.equals("editar")) {
			editarDiagnostico(request);
		}
		
		listarDiagnosticos(request, response);
		
	}
	
	private void altaDiagnostico(HttpServletRequest request) {
		//Traer parametros del form
		String descripcion = request.getParameter("diag-descripcion");
		
		//Crear la entidad nueva y darla de alta en BD
		try {
			Diagnostico diagnostico = new Diagnostico(descripcion);
			dl.crearDiagnostico(diagnostico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void editarDiagnostico(HttpServletRequest request) {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("diag-id"));
		String descripcion = request.getParameter("diag-descripcion");

		//Crear la entidad nueva y actualizarla en La BD
		try {
			Diagnostico diagnostico = new Diagnostico(id, descripcion);
			dl.actualizarDiagnostico(diagnostico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	private void listarDiagnosticos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("diagnosticos",dl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Diagnosticos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}