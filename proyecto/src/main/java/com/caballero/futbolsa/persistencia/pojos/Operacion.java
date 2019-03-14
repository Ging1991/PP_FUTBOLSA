package com.caballero.futbolsa.persistencia.pojos;

import java.sql.Date;

public class Operacion {
	private Integer operacion_id, vendedor, comprador, club, cantidad, precio;
	private Date fecha;
	private boolean emision;
	
	public Operacion(Integer operacion_id, Integer vendedor, Integer comprador, Integer club, Integer cantidad,
			Integer precio, Date fecha, boolean emision) {
		this.operacion_id = operacion_id;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.club = club;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
		this.emision = emision;
	}

	public Operacion(Integer vendedor, Integer comprador, Integer club, Integer cantidad,
			Integer precio, boolean emision) {
		this.operacion_id = -1;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.club = club;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = null;
		this.emision = emision;
	}

	@Override
	public String toString() {
		String ret = "operacion ID: "+operacion_id;
		ret = ret + ", vendedor: " + vendedor;
		ret = ret + ", comprador: " + comprador;
		ret = ret + ", club: " + club;
		ret = ret + ", cantidad: " + cantidad;
		ret = ret + ", precio: " + precio;
		ret = ret + ", fecha: " + fecha;
		ret = ret + ", emision: " + emision;
		return ret;
	}
		
	public Integer getOperacion_id() {
		return operacion_id;
	}

	public void setOperacion_id(Integer operacion_id) {
		this.operacion_id = operacion_id;
	}

	public Integer getVendedor() {
		return vendedor;
	}

	public void setVendedor(Integer vendedor) {
		this.vendedor = vendedor;
	}

	public Integer getComprador() {
		return comprador;
	}

	public void setComprador(Integer comprador) {
		this.comprador = comprador;
	}

	public Integer getClub() {
		return club;
	}

	public void setClub(Integer club) {
		this.club = club;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isEmision() {
		return emision;
	}

	public void setEmision(boolean emision) {
		this.emision = emision;
	}
	
}