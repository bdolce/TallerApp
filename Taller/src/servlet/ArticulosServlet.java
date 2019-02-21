package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ArticuloLogica;

/**
 * Servlet implementation class ArticulosServlet
 */
@WebServlet("/Articulos")
public class ArticulosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticuloLogica al = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticulosServlet() {
        super();
        al = new ArticuloLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarArticulos(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("alta")) {
			altaArticulo(request);
		} else if (accion.equals("editar")) {
			editarArticulo(request);
		}
		
		listarArticulos(request, response);
		
	}
	
	private void altaArticulo(HttpServletRequest request) {
		
	};
	
	private void editarArticulo(HttpServletRequest request) {
		
	};
	
	private void listarArticulos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("articulos",al.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Articulos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}