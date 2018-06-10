package com.caballero.futbolsa;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import com.caballero.futbolsa.vista.paginas.PaginaAdministrador;
import com.caballero.futbolsa.vista.paginas.PaginaIniciarSesion;
import com.caballero.futbolsa.vista.paginas.PaginaOperar;
import com.caballero.futbolsa.vista.paginas.PaginaPerfil;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.caballero.futbolsa.vista.paginas.PaginaRegistrarJugador;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class MyUI extends UI {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> sesion;
	private Navigator navegador;
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
		sesion = new HashMap<String, Object> ();
		sesion.put("jugador_activo", null);
		
		navegador = new Navigator(this, this);
		navegador.addView(PaginaAdministrador.NOMBRE, new PaginaAdministrador());
		navegador.addView(PaginaIniciarSesion.NOMBRE, new PaginaIniciarSesion());
		navegador.addView(PaginaOperar.NOMBRE, new PaginaOperar());
		navegador.addView(PaginaPerfil.NOMBRE, new PaginaPerfil());
		navegador.addView(PaginaPrincipal.NOMBRE, new PaginaPrincipal());
		navegador.addView(PaginaRegistrarJugador.NOMBRE, new PaginaRegistrarJugador());
		navegador.navigateTo(PaginaPrincipal.NOMBRE);
		}
	

	public void irPagina(String pagina) {
		navegador.navigateTo(pagina);
	}	
	
	public void setSesion(String clave, Object valor){
		sesion.put(clave, valor);
	}
	
	public Object getSesion(String clave){
		return sesion.get(clave);
	}


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }
}
