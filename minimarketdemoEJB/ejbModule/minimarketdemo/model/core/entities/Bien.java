package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bien database table.
 * 
 */
@Entity
@Table(name="bien")
@NamedQuery(name="Bien.findAll", query="SELECT b FROM Bien b")
public class Bien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bien_id", unique=true, nullable=false)
	private Integer bienId;

	@Column(name="direccion_bien", length=2147483647)
	private String direccionBien;

	@Column(name="nombre_bien", length=2147483647)
	private String nombreBien;

	//bi-directional many-to-one association to Reserva
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bien")
	private List<Reserva> reservas;

	public Bien() {
	}

	public Integer getBienId() {
		return this.bienId;
	}

	public void setBienId(Integer bienId) {
		this.bienId = bienId;
	}

	public String getDireccionBien() {
		return this.direccionBien;
	}

	public void setDireccionBien(String direccionBien) {
		this.direccionBien = direccionBien;
	}

	public String getNombreBien() {
		return this.nombreBien;
	}

	public void setNombreBien(String nombreBien) {
		this.nombreBien = nombreBien;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setBien(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setBien(null);

		return reserva;
	}

}