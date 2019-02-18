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
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteLogica cl = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
        cl = new ClienteLogica(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clientes",cl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Clientes.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if(accion.equals("alta")) {
			//CODIGO DE ALTA DE CLIENTE...
			//TRAER PARAMETROS DEL FORM
			String apellido = request.getParameter("cli-apellido");
			String nombre = request.getParameter("cli-nombre");
			String direccion = request.getParameter("cli-direccion");
			String telefono = request.getParameter("cli-telefono");
			String email = request.getParameter("cli-email");
			
			//CREAR LA ENTIDAD CLIENTE NUEVA PARA ALTA
			//REDIRIGIR?
			try {
				Cliente cliente = new Cliente(apellido, nombre, direccion, telefono, email);
				cl.crearCliente(cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if (accion.equals("editar")) {
			//CODIGO DE EDICION DE CLIENTE...
			//TRAER PARAMETROS DEL FORM
			int id = Integer.parseInt(request.getParameter("cli-id"));
			String apellido = request.getParameter("cli-apellido");
			String nombre = request.getParameter("cli-nombre");
			String direccion = request.getParameter("cli-direccion");
			String telefono = request.getParameter("cli-telefono");
			String email = request.getParameter("cli-email");
			
			//VALIDACION?
			//CREAR LA ENTIDAD CLIENTE Y PASARLA PARA ACTULIZACION
			try {
				Cliente cliente = new Cliente(id, apellido, nombre, direccion, telefono, email);
				cl.actualizarCliente(cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			request.setAttribute("clientes",cl.getAll());
			request.getRequestDispatcher("/WEB-INF/jsp/Clientes.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
