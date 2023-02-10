package minimarketdemo.model.reservas;

public class DTOReserva {
	private Integer id_reserva;
	private String nombre;
	private String bien;
	private String fecha_reserva;
	private String fecha_inicio;
	private String fecha_fin;
	public DTOReserva(Integer id_reserva, String nombre, String bien, String fecha_reserva, String fecha_inicio,
			String fecha_fin) {
		super();
		this.id_reserva = id_reserva;
		this.nombre = nombre;
		this.bien = bien;
		this.fecha_reserva = fecha_reserva;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public Integer getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBien() {
		return bien;
	}
	public void setBien(String bien) {
		this.bien = bien;
	}
	public String getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(String fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	
}
