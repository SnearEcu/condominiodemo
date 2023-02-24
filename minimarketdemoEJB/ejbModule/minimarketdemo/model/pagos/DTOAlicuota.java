package minimarketdemo.model.pagos;

import java.math.BigDecimal;

public class DTOAlicuota {
	private Integer id_alicuota;
	private Double valor;
	private BigDecimal periodo;
	public DTOAlicuota(Integer id_alicuota, Double valor, BigDecimal periodo) {
		super();
		this.id_alicuota = id_alicuota;
		this.valor = valor;
		this.periodo = periodo;
	}
	public Integer getId_alicuota() {
		return id_alicuota;
	}
	public void setId_alicuota(Integer id_alicuota) {
		this.id_alicuota = id_alicuota;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public BigDecimal getPeriodo() {
		return periodo;
	}
	public void setPeriodo(BigDecimal periodo) {
		this.periodo = periodo;
	}
	
	
	
}
