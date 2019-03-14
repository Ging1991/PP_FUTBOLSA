package com.caballero.futbolsa.persistencia.pojosVo;

public class OrdenVO {
	private Integer orden_id, jugador_id, club_id, cantidad, cotizacion, precio;
	private String club, tipo, estado;
	private boolean emision;
	
	public OrdenVO(Integer orden_id, Integer jugador_id, Integer club_id, Integer cantidad, Integer cotizacion,
			Integer precio, String club, String tipo, String estado, boolean emision) {
		this.orden_id = orden_id;
		this.jugador_id = jugador_id;
		this.club_id = club_id;
		this.cantidad = cantidad;
		this.cotizacion = cotizacion;
		this.precio = precio;
		this.club = club;
		this.tipo = tipo;
		this.estado = estado;
		this.emision = emision;
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

	public Integer getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Integer cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
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

	public boolean isEmision() {
		return emision;
	}

	public void setEmision(boolean emision) {
		this.emision = emision;
	}
	
}