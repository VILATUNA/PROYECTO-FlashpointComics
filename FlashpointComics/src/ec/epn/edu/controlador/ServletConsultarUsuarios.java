package ec.epn.edu.controlador;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ec.epn.edu.modelo.Usuario;

/**
 * Servlet implementation class ServletConsultarUsuarios
 */
@WebServlet("/ServletConsultarUsuarios")
public class ServletConsultarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConsultarUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Nombre = request.getParameter("username");
		String Contrase�a = request.getParameter("password");
		Query q = em.createQuery("Select U from Usuario as U", Usuario.class);
		List<Usuario> usuarios = q.getResultList();

		if (Nombre.trim().equals("") || Contrase�a.trim().equals("")) {
			request.setAttribute("valUser", Nombre);
			request.setAttribute("valContrase�a", Contrase�a);
			request.setAttribute("valError", "Por favor LLenar todos los campos ");
		} else {
			for (Usuario u : usuarios) {
				if (u.getNombre().equals(Nombre) && u.getContrase�a().equals(Contrase�a)) {

					request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);

				}

			}
		}

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
