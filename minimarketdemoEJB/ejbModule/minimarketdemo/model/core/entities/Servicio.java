package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id", unique=true, nullable=false)
	private Integer servId;

	@Column(name="valor_servicio")
	private double valorServicio;

	//bi-directional many-to-one association to DetallePago
	@OneToMany(mappedBy="servicio")
	private List<DetallePago> detallePagos;

	//bi-directional many-to-one association to TipoServicio
	@ManyToOne
	@JoinColumn(name="tip_ser_id")
	private TipoServicio tipoServicio;

	public Servicio() {
	}

	public Integer getServId() {
		return this.servId;
	}

	public void setServId(Integer servId) {
		this.servId = servId;
	}

	public double getValorServicio() {
		return this.valorServicio;
	}

	public void setValorServicio(double valorServicio) {
		this.valorServicio = valorServicio;
	}

	public List<DetallePago> getDetallePagos() {
		return this.detallePagos;
	}

	public void setDetallePagos(List<DetallePago> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public DetallePago addDetallePago(DetallePago detallePago) {
		getDetallePagos().add(detallePago);
		detallePago.setServicio(this);

		return detallePago;
	}

	public DetallePago removeDetallePago(DetallePago detallePago) {
		getDetallePagos().remove(detallePago);
		detallePago.setServicio(null);

		return detallePago;
	}

	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

}