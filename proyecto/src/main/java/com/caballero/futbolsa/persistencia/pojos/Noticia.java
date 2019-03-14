package com.caballero.futbolsa.persistencia.pojos;

import java.sql.Date;

public class Noticia {
	private Integer noticia_id;
	private String contenido;
	private Date fecha;
	
	public Noticia(Integer noticia_id, String contenido, Date fecha) {
		this.noticia_id = noticia_id;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Noticia_id = "+noticia_id+", Fecha = "+fecha+", Contenido = "+contenido;
	}

	public Integer getNoticia_id() {
		return noticia_id;
	}

	public void setNoticia_id(Integer noticia_id) {
		this.noticia_id = noticia_id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}