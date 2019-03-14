package com.caballero.futbolsa.vista.tablas;

import java.util.List;

import com.caballero.futbolsa.MyUI;
import com.caballero.futbolsa.negocios.Agente;
import com.caballero.futbolsa.persistencia.pojos.Club;
import com.caballero.futbolsa.persistencia.pojosVo.OrdenVO;
import com.caballero.futbolsa.vista.paginas.PaginaPrincipal;
import com.vaadin.data.Item;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TablaOrdenesDeClub extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public TablaOrdenesDeClub(Club club) {
		List<OrdenVO> ordenes = Agente.traerOrdenesVOActivasDeClub(club);
		if (ordenes.size() > 0) {
			Table tabla = new Table("Ordenes pendientes de ejecucion");
			tabla.addContainerProperty("Operacion", String.class, null);
			tabla.addContainerProperty("Cantidad",  Integer.class, null);
			tabla.addContainerProperty("Precio",  String.class, null);
			tabla.addContainerProperty("Cotizacion",  Integer.class, null);
			tabla.addContainerProperty("Cancelar",  Button.class, null);
			
			for (OrdenVO orden : ordenes)
				agregarItem(tabla, orden);
			
			tabla.setPageLength(tabla.size());
			addComponent(tabla);
			setComponentAlignment(tabla, Alignment.MIDDLE_CENTER);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void agregarItem(Table tabla, OrdenVO orden) {
		Object itemID = tabla.addItem();
		Item registro = tabla.getItem(itemID);
		
		String operacion = orden.getTipo();
		Integer cantidad = orden.getCantidad();
		String precio = "$" + orden.getPrecio().toString();
		Integer cotizacion = orden.getCotizacion();
		
		if (operacion.equals("V"))
			operacion = "Venta";
		else
			operacion = "Compra";
		
		registro.getItemProperty("Operacion").setValue(operacion);
		registro.getItemProperty("Cantidad").setValue(cantidad);
		registro.getItemProperty("Precio").setValue(precio);
		registro.getItemProperty("Cotizacion").setValue(cotizacion);
		
		Button cancelar = new Button("Cancelar orden");
		cancelar.addClickListener(e -> {
			Agente.cancelarOrden(orden);
			MyUI ui = (MyUI) UI.getCurrent();
			ui.irPagina(PaginaPrincipal.NOMBRE);
		});
		
		registro.getItemProperty("Cancelar").setValue(cancelar);
	}
	
}