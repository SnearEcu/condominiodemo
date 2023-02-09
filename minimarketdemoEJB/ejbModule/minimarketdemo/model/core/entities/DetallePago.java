package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_pagos database table.
 * 
 */
@Entity
@Table(name="detalle_pagos")
@NamedQuery(name="DetallePago.findAll", query="SELECT d FROM DetallePago d")
public class DetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id", unique=true, nullable=false)
	private Integer detId;

	@Column(name="subtotal_pago")
	private double subtotalPago;

	//bi-directional many-to-one association to Alicuota
	@ManyToOne
	@JoinColumn(name="ali_id")
	private Alicuota alicuota;

	//bi-directional many-to-one association to Multa
	@ManyToOne
	@JoinColumn(name="mult_id")
	private Multa multa;

	//bi-directional many-to-one association to Pago
	@ManyToOne
	@JoinColumn(name="pag_id")
	private Pago pago;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="serv_id")
	private Servicio servicio;

	public DetallePago() {
	}

	public Integer getDetId() {
		return this.detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	public double getSubtotalPago() {
		return this.subtotalPago;
	}

	public void setSubtotalPago(double subtotalPago) {
		this.subtotalPago = subtotalPago;
	}

	public Alicuota getAlicuota() {
		return this.alicuota;
	}

	public void setAlicuota(Alicuota alicuota) {
		this.alicuota = alicuota;
	}

	public Multa getMulta() {
		return this.multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}