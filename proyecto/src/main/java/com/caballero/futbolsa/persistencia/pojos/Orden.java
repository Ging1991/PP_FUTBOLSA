package com.caballero.futbolsa.persistencia.pojos;

public class Orden {
	private Integer orden_id, jugador_id, club_id, cantidad, precio;
	private String tipo, estado;
	private boolean esEmision;
	
	public Orden(Integer orden_id, Integer jugador_id, Integer club_id, Integer cantidad, Integer precio, String tipo,
			String estado, boolean esEmision) {
		this.orden_id = orden_id;
		this.jugador_id = jugador_id;
		this.club_id = club_id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
		this.estado = estado;
		this.esEmision = esEmision;
	}
	
	@Override
	public String toString() {
		String ret = "orden ID: "+orden_id;
		ret = ret + ", jugador_id: " + jugador_id;
		ret = ret + ", club_id: " + club_id;
		ret = ret + ", cantidad: " + cantidad;
		ret = ret + ", precio: " + precio;
		ret = ret + ", tipo: " + tipo;
		ret = ret + ", estado: " + estado;
		ret = ret + ", esEmision: " + esEmision;
		return ret;
	}


	public Integer getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Integer orden_id) {
		this.orden_id = orden_id;
	}

	public Integer getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(Integer jugador_id) {
		this.jugador_id = jugador_id;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isEsEmision() {
		return esEmision;
	}

	public void setEsEmision(boolean esEmision) {
		this.esEmision = esEmision;
	}
	
}