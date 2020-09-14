package ec.epn.edu.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Comic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_comic;
	@Column
	private String cmc_titulo;
	@Column
	private String cmc_autor;
	@Column
	private String cmc_resumen;
	@Column
	private String cmc_edicion;
	@Column
	private String cmc_idioma;
	@Column
	private String cmc_fecha_publicacion;
	@Column
	private Integer cmc_num_paginas;
	@Column
	private String cmc_imagen;
	@Column
	private String cmc_comic;
	
	public Integer getId_comic() {
		return id_comic;
	}
	public void setId_comic(Integer id_comic) {
		this.id_comic = id_comic;
	}
	public String getCmc_titulo() {
		return cmc_titulo;
	}
	public void setCmc_titulo(String cmc_titulo) {
		this.cmc_titulo = cmc_titulo;
	}
	public String getCmc_autor() {
		return cmc_autor;
	}
	public void setCmc_autor(String cmc_autor) {
		this.cmc_autor = cmc_autor;
	}
	public String getCmc_resumen() {
		return cmc_resumen;
	}
	public void setCmc_resumen(String cmc_resumen) {
		this.cmc_resumen = cmc_resumen;
	}
	public String getCmc_edicion() {
		return cmc_edicion;
	}
	public void setCmc_edicion(String cmc_edicion) {
		this.cmc_edicion = cmc_edicion;
	}
	public String getCmc_idioma() {
		return cmc_idioma;
	}
	public void setCmc_idioma(String cmc_idioma) {
		this.cmc_idioma = cmc_idioma;
	}
	
	public String getCmc_fecha_publicacion() {
		return cmc_fecha_publicacion;
	}
	public void setCmc_fecha_publicacion(String cmc_fecha_publicacion) {
		this.cmc_fecha_publicacion = cmc_fecha_publicacion;
	}
	public Integer getCmc_num_paginas() {
		return cmc_num_paginas;
	}
	public void setCmc_num_paginas(Integer cmc_num_paginas) {
		this.cmc_num_paginas = cmc_num_paginas;
	}
	public String getCmc_imagen() {
		return cmc_imagen;
	}
	public void setCmc_imagen(String cmc_imagen) {
		this.cmc_imagen = cmc_imagen;
	}
	public String getCmc_comic() {
		return cmc_comic;
	}
	public void setCmc_comic(String cmc_comic) {
		this.cmc_comic = cmc_comic;
	}

	
}
