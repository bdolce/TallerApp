package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.OrdenLogica;

/**
 * Servlet implementation class Ordenes
 */
@WebServlet("/Ordenes")
public class OrdenesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdenLogica ol = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenesServlet() {
        super();
        ol = new OrdenLogica();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarOrdenes(request, response);
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
		
	};
	
	private void editarOrden(HttpServletRequest request) {
		
	};
	
	private void listarOrdenes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("ordenes",ol.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Ordenes.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

}
