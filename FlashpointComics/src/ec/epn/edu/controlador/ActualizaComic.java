package ec.epn.edu.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import ec.epn.edu.modelo.Comic;

/**
 * Servlet implementation class ActualizaComic
 */
@Transactional
@WebServlet("/ActualizaComic")
public class ActualizaComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@PersistenceContext (unitName="ComicPU")
	private EntityManager em;/**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizaComic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String resumen = request.getParameter("resumen");
		String edicion = request.getParameter("edicion");
		String idioma = request.getParameter("idioma");
		String fechaPubli = request.getParameter("fechaPubli");
		String numPag = request.getParameter("numPag");
		String imagen = request.getParameter("imagen");
		String comic = request.getParameter("comic");
		System.out.println("Datos del libro a guardar: titulo: " 
		+ titulo + " autor: " + autor + " resumen: " + resumen);
		if(titulo.trim().equals("") || autor.trim().equals("") || edicion.trim().equals("") || idioma.trim().equals("") || numPag.trim().equals("") ) {
			request.setAttribute("valId",id);
			request.setAttribute("valTitulo", titulo);
			request.setAttribute("valAutor", autor);
			request.setAttribute("valResumen", resumen);
			request.setAttribute("valEdicion", edicion);
			request.setAttribute("valIdioma", idioma);
			request.setAttribute("valFechaPublic", fechaPubli);
			request.setAttribute("valNumPag", numPag);
			request.setAttribute("valImagen", imagen);
			request.setAttribute("valComic", comic);
			request.setAttribute("valError", "Titulo o autor sin llenar");
			
			request.getRequestDispatcher("editarComic.jsp").forward(request, response);

		}else {
			
			Comic l = new Comic();
			l.setId_comic(Integer.parseInt(id));
			l.setCmc_titulo(titulo);
			l.setCmc_autor(autor);			
			l.setCmc_resumen(resumen);
			l.setCmc_edicion(edicion);
			l.setCmc_idioma(idioma);			
			l.setCmc_fecha_publicacion(fechaPubli);		
			l.setCmc_num_paginas(Integer.parseInt(numPag));
			l.setCmc_imagen(imagen);			
			l.setCmc_comic(comic);
			em.merge(l);
			request.getRequestDispatcher("ListadoComic").forward(request, response);
		}	

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
