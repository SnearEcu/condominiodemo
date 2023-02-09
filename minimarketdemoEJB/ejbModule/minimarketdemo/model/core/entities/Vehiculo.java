package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@Table(name="vehiculo")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="veh_id", unique=true, nullable=false)
	private Integer vehId;

	@Column(name="placa_vehiculo", length=2147483647)
	private String placaVehiculo;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="cond_id")
	private SegUsuario segUsuario;

	public Vehiculo() {
	}

	public Integer getVehId() {
		return this.vehId;
	}

	public void setVehId(Integer vehId) {
		this.vehId = vehId;
	}

	public String getPlacaVehiculo() {
		return this.placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}