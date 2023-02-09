package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vivienda database table.
 * 
 */
@Entity
@Table(name="vivienda")
@NamedQuery(name="Vivienda.findAll", query="SELECT v FROM Vivienda v")
public class Vivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="viv_id", unique=true, nullable=false)
	private Integer vivId;

	@Column(name="direccion_vivienda", length=2147483647)
	private String direccionVivienda;

	@Column(name="numero_vivienda", precision=131089)
	private BigDecimal numeroVivienda;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="cond_id")
	private SegUsuario segUsuario;

	public Vivienda() {
	}

	public Integer getVivId() {
		return this.vivId;
	}

	public void setVivId(Integer vivId) {
		this.vivId = vivId;
	}

	public String getDireccionVivienda() {
		return this.direccionVivienda;
	}

	public void setDireccionVivienda(String direccionVivienda) {
		this.direccionVivienda = direccionVivienda;
	}

	public BigDecimal getNumeroVivienda() {
		return this.numeroVivienda;
	}

	public void setNumeroVivienda(BigDecimal numeroVivienda) {
		this.numeroVivienda = numeroVivienda;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}