package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the multas database table.
 * 
 */
@Entity
@Table(name="multas")
@NamedQuery(name="Multa.findAll", query="SELECT m FROM Multa m")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mult_id", unique=true, nullable=false)
	private Integer multId;

	@Column(name="tipo_multa", length=10)
	private String tipoMulta;

	@Column(name="valor_multa")
	private double valorMulta;

	//bi-directional many-to-one association to DetallePago
	@OneToMany(mappedBy="multa")
	private List<DetallePago> detallePagos;

	public Multa() {
	}

	public Integer getMultId() {
		return this.multId;
	}

	public void setMultId(Integer multId) {
		this.multId = multId;
	}

	public String getTipoMulta() {
		return this.tipoMulta;
	}

	public void setTipoMulta(String tipoMulta) {
		this.tipoMulta = tipoMulta;
	}

	public double getValorMulta() {
		return this.valorMulta;
	}

	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public List<DetallePago> getDetallePagos() {
		return this.detallePagos;
	}

	public void setDetallePagos(List<DetallePago> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public DetallePago addDetallePago(DetallePago detallePago) {
		getDetallePagos().add(detallePago);
		detallePago.setMulta(this);

		return detallePago;
	}

	public DetallePago removeDetallePago(DetallePago detallePago) {
		getDetallePagos().remove(detallePago);
		detallePago.setMulta(null);

		return detallePago;
	}

}