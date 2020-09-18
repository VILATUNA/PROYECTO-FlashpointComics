package ec.epn.edu.controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import java.util.Locale;

import ec.epn.edu.modelo.Comic;


/**
 * Servlet implementation class RegistroComic
 */

@Transactional
@WebServlet("/RegistroComic")
public class RegistroComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext (unitName="ComicPU")
	private EntityManager em;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroComic() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	if(titulo.trim().equals("") || autor.trim().equals("") || 
			edicion.trim().equals("") || idioma.trim().equals("") || numPag.trim().equals("")
			|| imagen.trim().equals("") || comic.trim().equals("")) {		
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
		
		request.getRequestDispatcher("registrarComic.jsp").forward(request, response);

	}else {
		
		Comic l = new Comic();
		l.setCmc_titulo(titulo);
		l.setCmc_autor(autor);			
		l.setCmc_resumen(resumen);
		l.setCmc_edicion(edicion);
		l.setCmc_idioma(idioma);			
		l.setCmc_fecha_publicacion(fechaPubli);		
		l.setCmc_num_paginas(Integer.parseInt(numPag));
		l.setCmc_imagen(imagen);			
		l.setCmc_comic(comic);
		em.persist(l);
		request.getRequestDispatcher("ListadoComic").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    
}


