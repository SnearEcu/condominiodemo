package minimarketdemo.model.pagos;

import java.math.BigDecimal;

public class DTOMulta {
	private Integer id_multa;
	private Double valor;
	private String tipo_multa;
	public DTOMulta(Integer id_multa, Double valor, String tipo_multa) {
		super();
		this.id_multa = id_multa;
		this.valor = valor;
		this.tipo_multa = tipo_multa;
	}
	public Integer getId_multa() {
		return id_multa;
	}
	public void setId_multa(Integer id_multa) {
		this.id_multa = id_multa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo_multa() {
		return tipo_multa;
	}
	public void setTipo_multa(String tipo_multa) {
		this.tipo_multa = tipo_multa;
	}
	
	
	
	
}
