package ec.epn.edu.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.epn.edu.modelo.Usuario;

/**
 * Servlet implementation class ServletEditarUsuario
 */
@WebServlet("/ServletEditarUsuario")
public class ServletEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEditarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u = em.find(Usuario.class, Integer.valueOf(request.getParameter("id")));

		Integer id = u.getId();
		String nombre = u.getNombre();
		String email = u.getEmail();
		String contrase�a = u.getContrase�a();

		request.setAttribute("valId", String.valueOf(id));
		request.setAttribute("valUser", nombre);
		request.setAttribute("valEmail", email);
		request.setAttribute("valContrase�a", contrase�a);

		request.getRequestDispatcher("EditarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
