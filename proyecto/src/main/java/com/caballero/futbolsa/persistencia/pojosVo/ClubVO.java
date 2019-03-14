package com.caballero.futbolsa.persistencia.pojosVo;

public class ClubVO {
	private Integer club_id, presidente_id, cotizacion, efectivo, div_victoria, div_empate, div_derrota, posicion,
		cantidad_venta, cantidad_compra, precio_compra, precio_venta;
	private String club, presidente;

	public ClubVO(Integer club_id, Integer presidente_id, Integer cotizacion, Integer efectivo, Integer div_victoria,
			Integer div_empate, Integer div_derrota, Integer posicion, Integer cantidad_venta, Integer cantidad_compra,
			Integer precio_compra, Integer precio_venta, String club, String presidente) {
		this.club_id = club_id;
		this.presidente_id = presidente_id;
		this.cotizacion = cotizacion;
		this.efectivo = efectivo;
		this.div_victoria = div_victoria;
		this.div_empate = div_empate;
		this.div_derrota = div_derrota;
		this.posicion = posicion;
		this.cantidad_venta = cantidad_venta;
		this.cantidad_compra = cantidad_compra;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.club = club;
		this.presidente = presidente;
	}

	public Integer getClub_id() {
		return club_id;
	}

	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}

	public Integer getPresidente_id() {
		return presidente_id;
	}

	public void setPresidente_id(Integer presidente_id) {
		this.presidente_id = presidente_id;
	}

	public Integer getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Integer cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Integer getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(Integer efectivo) {
		this.efectivo = efectivo;
	}

	public Integer getDiv_victoria() {
		return div_victoria;
	}

	public void setDiv_victoria(Integer div_victoria) {
		this.div_victoria = div_victoria;
	}

	public Integer getDiv_empate() {
		return div_empate;
	}

	public void setDiv_empate(Integer div_empate) {
		this.div_empate = div_empate;
	}

	public Integer getDiv_derrota() {
		return div_derrota;
	}

	public void setDiv_derrota(Integer div_derrota) {
		this.div_derrota = div_derrota;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public Integer getCantidad_venta() {
		return cantidad_venta;
	}

	public void setCantidad_venta(Integer cantidad_venta) {
		this.cantidad_venta = cantidad_venta;
	}

	public Integer getCantidad_compra() {
		return cantidad_compra;
	}

	public void setCantidad_compra(Integer cantidad_compra) {
		this.cantidad_compra = cantidad_compra;
	}

	public Integer getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Integer precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Integer getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Integer precio_venta) {
		this.precio_venta = precio_venta;
	}
	
}