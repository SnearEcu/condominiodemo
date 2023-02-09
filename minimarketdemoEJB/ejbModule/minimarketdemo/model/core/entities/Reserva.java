package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resv_id", unique=true, nullable=false)
	private Integer resvId;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reserva")
	private Date fechaReserva;

	//bi-directional many-to-one association to Bien
	@OneToMany
	@JoinColumn(name="bien_id")
	private Bien bien;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="cond_id")
	private SegUsuario segUsuario;

	public Reserva() {
	}

	public Integer getResvId() {
		return this.resvId;
	}

	public void setResvId(Integer resvId) {
		this.resvId = resvId;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Bien getBien() {
		return this.bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}