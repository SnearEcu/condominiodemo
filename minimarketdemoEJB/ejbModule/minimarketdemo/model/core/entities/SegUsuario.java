package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_usuario database table.
 * 
 */
@Entity
@Table(name="seg_usuario")
@NamedQuery(name="SegUsuario.findAll", query="SELECT s FROM SegUsuario s")
public class SegUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seg_usuario", unique=true, nullable=false)
	private Integer idSegUsuario;

	private Boolean activo;

	@Column(length=2147483647)
	private String apellidos;

	@Column(length=2147483647)
	private String clave;

	@Column(length=2147483647)
	private String codigo;

	@Column(length=2147483647)
	private String correo;

	@Column(length=2147483647)
	private String nombres;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="segUsuario")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="segUsuario")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to SegAsignacion
	@OneToMany(mappedBy="segUsuario")
	private List<SegAsignacion> segAsignacions;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="segUsuario")
	private List<Vehiculo> vehiculos;

	//bi-directional many-to-one association to Vivienda
	@OneToMany(mappedBy="segUsuario")
	private List<Vivienda> viviendas;

	public SegUsuario() {
	}

	public Integer getIdSegUsuario() {
		return this.idSegUsuario;
	}

	public void setIdSegUsuario(Integer idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setSegUsuario(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setSegUsuario(null);

		return pago;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setSegUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setSegUsuario(null);

		return reserva;
	}

	public List<SegAsignacion> getSegAsignacions() {
		return this.segAsignacions;
	}

	public void setSegAsignacions(List<SegAsignacion> segAsignacions) {
		this.segAsignacions = segAsignacions;
	}

	public SegAsignacion addSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().add(segAsignacion);
		segAsignacion.setSegUsuario(this);

		return segAsignacion;
	}

	public SegAsignacion removeSegAsignacion(SegAsignacion segAsignacion) {
		getSegAsignacions().remove(segAsignacion);
		segAsignacion.setSegUsuario(null);

		return segAsignacion;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setSegUsuario(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setSegUsuario(null);

		return vehiculo;
	}

	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public Vivienda addVivienda(Vivienda vivienda) {
		getViviendas().add(vivienda);
		vivienda.setSegUsuario(this);

		return vivienda;
	}

	public Vivienda removeVivienda(Vivienda vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setSegUsuario(null);

		return vivienda;
	}

}