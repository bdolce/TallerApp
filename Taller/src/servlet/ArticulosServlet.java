package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Articulo;
import entidades.Cliente;
import entidades.Marca;
import entidades.Tipo;
import negocio.ArticuloLogica;
import negocio.ClienteLogica;
import negocio.MarcaLogica;
import negocio.TipoLogica;

/**
 * Servlet implementation class ArticulosServlet
 */
@WebServlet("/Articulos")
public class ArticulosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticuloLogica al = null;
	private ClienteLogica cl = null;
	private MarcaLogica ml = null;
	private TipoLogica tl = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticulosServlet() {
        super();
        al = new ArticuloLogica();
        ml = new MarcaLogica();
        tl = new TipoLogica();
        cl = new ClienteLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("UsuarioLogeado") == null) {
			response.sendRedirect("Login");
		} else {
			listarArticulos(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		try {
			if (accion.equals("alta")) {
				altaArticulo(request);
			} else if (accion.equals("editar")) {
				editarArticulo(request);
			}

			listarArticulos(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void altaArticulo(HttpServletRequest request) throws SQLException {
		//Traer parametros del form
		String modelo  = request.getParameter("art-modelo");
		String serie = request.getParameter("art-serie");
		int id_cliente  = Integer.parseInt(request.getParameter("art-cliente"));
		int id_tipo = Integer.parseInt(request.getParameter("art-tipo"));
		int id_marca = Integer.parseInt(request.getParameter("art-marca"));

		//Mapear las subentidades
		Cliente c = new Cliente();
		c.setId(id_cliente);
		Cliente cliente = cl.getOneById(c);

		Tipo t = new Tipo();
		t.setId(id_tipo);
		Tipo tipo = tl.getOne(t);

		Marca m = new Marca();
		m.setId(id_marca);
		Marca marca = ml.getOne(m);

		//Crear la entidad nueva y darla de alta en la BD
		try {
			Articulo articulo = new Articulo(cliente, marca, tipo, modelo);
			if (!serie.equals("")) {
				articulo.setSerie(serie);
			}

			al.crearArticulo(articulo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	private void editarArticulo(HttpServletRequest request) throws SQLException {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("art-id"));
		String modelo  = request.getParameter("art-modelo");
		String serie = request.getParameter("art-serie");
		int id_tipo = Integer.parseInt(request.getParameter("art-tipo"));
		int id_marca = Integer.parseInt(request.getParameter("art-marca"));

		//Mapear las subentidades 		
		Tipo t = new Tipo();
		t.setId(id_tipo);
		Tipo tipo = tl.getOne(t);

		Marca m = new Marca();
		m.setId(id_marca);
		Marca marca = ml.getOne(m);

		//Crear la entidad nueva y editar en la BD
		try {
			Articulo articulo = new Articulo(id, modelo, serie, marca, tipo);
			al.actualizarArticulo(articulo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	private void listarArticulos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("articulos",al.getAll());
			request.setAttribute("marcas",ml.getAll());
			request.setAttribute("tipos",tl.getAll());
			request.setAttribute("clientes",cl.getAll());  //PROVISIONAL, CAMBIAR
			request.getRequestDispatcher("/WEB-INF/jsp/Articulos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
