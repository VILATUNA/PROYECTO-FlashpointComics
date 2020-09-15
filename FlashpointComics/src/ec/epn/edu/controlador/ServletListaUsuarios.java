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
 * Servlet implementation class ServletListaLibros
 */
@WebServlet("/ServletListaUsuarios")
public class ServletListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListaUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Query q = em.createQuery("Select U from Usuario as U", Usuario.class);

		List<Usuario> Usuario = q.getResultList();

		request.setAttribute("Usuarios", Usuario);

		request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
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
