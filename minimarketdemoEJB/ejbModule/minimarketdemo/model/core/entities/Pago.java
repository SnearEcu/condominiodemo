package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pag_id", unique=true, nullable=false)
	private Integer pagId;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Column(name="total_pago")
	private double totalPago;

	//bi-directional many-to-one association to DetallePago
	@OneToMany(mappedBy="pago")
	private List<DetallePago> detallePagos;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="id_seg_usuario")
	private SegUsuario segUsuario;

	public Pago() {
	}

	public Integer getPagId() {
		return this.pagId;
	}

	public void setPagId(Integer pagId) {
		this.pagId = pagId;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getTotalPago() {
		return this.totalPago;
	}

	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}

	public List<DetallePago> getDetallePagos() {
		return this.detallePagos;
	}

	public void setDetallePagos(List<DetallePago> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public DetallePago addDetallePago(DetallePago detallePago) {
		getDetallePagos().add(detallePago);
		detallePago.setPago(this);

		return detallePago;
	}

	public DetallePago removeDetallePago(DetallePago detallePago) {
		getDetallePagos().remove(detallePago);
		detallePago.setPago(null);

		return detallePago;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}