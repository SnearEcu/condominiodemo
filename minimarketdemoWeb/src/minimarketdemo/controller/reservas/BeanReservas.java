package minimarketdemo.controller.reservas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.seguridades.BeanSegLogin;
import minimarketdemo.model.core.entities.Reserva;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.reservas.ManagerReservas;
import minimarketdemo.model.seguridades.managers.ManagerSeguridades;

@Named
@SessionScoped
public class BeanReservas implements Serializable {
	@EJB
	private ManagerReservas mReservas;
	@EJB
	private ManagerSeguridades mSeguridades;
	private Reserva nuevaReserva;
	private List<Reserva> listaReserva;
	private List<Reserva> listaReserva2;

	private Reserva reservaSeleccionada;
	private List<SegUsuario> listaUsuarios;
	private int idSegUsuarioSeleccionado;

	@Inject
	private BeanSegLogin beanSeagLogin;

	public BeanReservas() {
	}
	@PostConstruct
	public void inicializar() {
		listaReserva=mReservas.findAllReservas();
		nuevaReserva=mReservas.inicializarReserva();

	}
	public List<Reserva> getListaReservas() {
		return listaReserva2;
	}
	public void setListaReserva(List<Reserva> listaReserva2) {
		this.listaReserva2 = listaReserva2;
	}
	public void actionListenerInsertarReserva() {
		try {
			mReservas.insertarReserva(beanSeagLogin.getLoginDTO(), nuevaReserva);
			JSFUtil.crearMensajeINFO("Reserva creado");
			nuevaReserva=mReservas.inicializarReserva();
			listaReserva=mReservas.findAllReservas();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeERROR(e.getMessage());
		}
	}
	public String actionSeleccionarReserva(Reserva reserva) {
		listaUsuarios=mSeguridades.findAllUsuarios();
		reservaSeleccionada=reserva;
		return "tareas?faces-redirect=true";
	}
	public Reserva getNuevaReserva() {
		return nuevaReserva;
	}
	public void setNuevaReserva(Reserva nuevaReserva) {
		this.nuevaReserva = nuevaReserva;
	}
	public List<Reserva> getListaReserva2() {
		return listaReserva2;
	}
	public void setListaReserva2(List<Reserva> listaReserva2) {
		this.listaReserva2 = listaReserva2;
	}
	public Reserva getReservaSeleccionada() {
		return reservaSeleccionada;
	}
	public void setReservaSeleccionada(Reserva reservaSeleccionada) {
		this.reservaSeleccionada = reservaSeleccionada;
	}
	public List<SegUsuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<SegUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public int getIdSegUsuarioSeleccionado() {
		return idSegUsuarioSeleccionado;
	}
	public void setIdSegUsuarioSeleccionado(int idSegUsuarioSeleccionado) {
		this.idSegUsuarioSeleccionado = idSegUsuarioSeleccionado;
	}
	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	


}