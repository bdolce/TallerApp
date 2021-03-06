package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocio.ClienteLogica;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteLogica cl = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
        cl = new ClienteLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("UsuarioLogeado") == null) {
			response.sendRedirect("Login");
		} else {
			listarClientes(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");

		if(accion.equals("alta")) {
			altaCliente(request);
		}	else if (accion.equals("editar")) {
			editarCliente(request);
		}

		listarClientes(request, response);

	}


	private void altaCliente(HttpServletRequest request) {
		//Traer parametros del form
		String apellido = request.getParameter("cli-apellido");
		String nombre = request.getParameter("cli-nombre");
		String direccion = request.getParameter("cli-direccion");
		String telefono = request.getParameter("cli-telefono");
		String email = request.getParameter("cli-email");

		//Crear la entidad nueva y darla de alta en BD
		try {
			Cliente cliente = new Cliente(apellido, nombre, direccion, telefono, email);
			cl.crearCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	private void editarCliente(HttpServletRequest request) {
		//Traer parametros del form
		int id = Integer.parseInt(request.getParameter("cli-id"));
		String apellido = request.getParameter("cli-apellido");
		String nombre = request.getParameter("cli-nombre");
		String direccion = request.getParameter("cli-direccion");
		String telefono = request.getParameter("cli-telefono");
		String email = request.getParameter("cli-email");

		//VALIDACION?
		//Crear la entidad nueva y actualizarla en La BD
		try {
			Cliente cliente = new Cliente(id, apellido, nombre, direccion, telefono, email);
			cl.actualizarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clientes",cl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Clientes.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
