package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_servicios database table.
 * 
 */
@Entity
@Table(name="tipo_servicios")
@NamedQuery(name="TipoServicio.findAll", query="SELECT t FROM TipoServicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tip_ser_id", unique=true, nullable=false)
	private Integer tipSerId;

	@Column(name="nombre_servicio", length=2147483647)
	private String nombreServicio;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tipoServicio")
	private List<Servicio> servicios;

	public TipoServicio() {
	}

	public Integer getTipSerId() {
		return this.tipSerId;
	}

	public void setTipSerId(Integer tipSerId) {
		this.tipSerId = tipSerId;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setTipoServicio(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setTipoServicio(null);

		return servicio;
	}

}