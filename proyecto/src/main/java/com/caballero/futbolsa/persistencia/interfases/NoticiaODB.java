package com.caballero.futbolsa.persistencia.interfases;

import com.caballero.futbolsa.persistencia.pojos.Noticia;

public interface NoticiaODB {
	
	public Integer insert(Noticia noticia);
	
	public Noticia selectByID(Integer id) throws Exception ;

}
