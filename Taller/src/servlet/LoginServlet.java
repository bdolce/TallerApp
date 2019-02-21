package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import negocio.UsuarioLogica;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioLogica ul;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        ul = new UsuarioLogica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("UsuarioLogeado") == null) {
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
		} else {
			response.sendRedirect("Inicio");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if(accion.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Usuario usuario = new Usuario(username,password);
			try {
				if (ul.validarUsuario(usuario)) {
					request.getSession().setAttribute("UsuarioLogeado", usuario);
					response.sendRedirect("Inicio");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (accion.equals("registro")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String email = request.getParameter("email");
			
			if (password.equals(password2)) {
				try {
					Usuario usuario = new Usuario(username,password,email);			
					ul.crearUsuario(usuario);
					request.getSession().setAttribute("UsuarioLogeado", usuario);
					response.sendRedirect("Inicio");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
}
