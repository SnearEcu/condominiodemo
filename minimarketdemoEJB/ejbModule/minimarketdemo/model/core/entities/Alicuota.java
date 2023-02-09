package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the alicuota database table.
 * 
 */
@Entity
@Table(name="alicuota")
@NamedQuery(name="Alicuota.findAll", query="SELECT a FROM Alicuota a")
public class Alicuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ali_id", unique=true, nullable=false)
	private Integer aliId;

	@Column(precision=131089)
	private BigDecimal periodo;

	@Column(name="valor_alicuota")
	private double valorAlicuota;

	//bi-directional many-to-one association to DetallePago
	@OneToMany(mappedBy="alicuota")
	private List<DetallePago> detallePagos;

	public Alicuota() {
	}

	public Integer getAliId() {
		return this.aliId;
	}

	public void setAliId(Integer aliId) {
		this.aliId = aliId;
	}

	public BigDecimal getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(BigDecimal periodo) {
		this.periodo = periodo;
	}

	public double getValorAlicuota() {
		return this.valorAlicuota;
	}

	public void setValorAlicuota(double valorAlicuota) {
		this.valorAlicuota = valorAlicuota;
	}

	public List<DetallePago> getDetallePagos() {
		return this.detallePagos;
	}

	public void setDetallePagos(List<DetallePago> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public DetallePago addDetallePago(DetallePago detallePago) {
		getDetallePagos().add(detallePago);
		detallePago.setAlicuota(this);

		return detallePago;
	}

	public DetallePago removeDetallePago(DetallePago detallePago) {
		getDetallePagos().remove(detallePago);
		detallePago.setAlicuota(null);

		return detallePago;
	}

}