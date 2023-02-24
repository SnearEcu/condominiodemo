package minimarketdemo.model.pagos;



public class DTOServicios {
	private Integer id_servicio;
	private Double valor;
	private String tipo_servicio;
	public DTOServicios(Integer id_servicio, Double valor, String tipo_servicio) {
		super();
		this.id_servicio = id_servicio;
		this.valor = valor;
		this.tipo_servicio = tipo_servicio;
	}
	public Integer getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	
	
	
	
	
	
	
	
}
