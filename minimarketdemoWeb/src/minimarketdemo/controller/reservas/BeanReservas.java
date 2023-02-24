package minimarketdemo.controller.reservas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.seguridades.BeanSegLogin;
import minimarketdemo.model.core.entities.Bien;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.Reserva;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.reservas.ManagerReservas;
import minimarketdemo.model.seguridades.managers.ManagerSeguridades;

@Named
@SessionScoped
public class BeanReservas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerReservas mReservas;
	@EJB
	private ManagerSeguridades mSeguridades;
	private Reserva nuevaReserva;
	private List<Reserva> listaReserva;
	private List<Reserva> listaReserva2;
	private String bienElegido;
	private String usuarioElegido;
	
	private List<Bien> listaBienes;
	
	private Reserva reservaSeleccionada;
	private List<SegUsuario> listaUsuarios;
	private int idSegUsuarioSeleccionado;

	private Bien nuevoBien;
	@Inject
	private BeanSegLogin beanSeagLogin;

	public BeanReservas() {
	}
	@PostConstruct
	public void inicializar() {
		listaReserva=mReservas.findAllReservas();
		

	}
	
	public String actionMenuBienes() {
		listaBienes=mReservas.findAllBienes();
		nuevoBien=new Bien();
		return "bienes";
	}
	public String actionMenuReserva() {
		listaReserva=mReservas.findAllReservas();
		listaUsuarios = mSeguridades.findAllUsuarios();
		listaBienes = mReservas.findAllBienes();
		nuevaReserva= new Reserva();
		bienElegido = "";
		usuarioElegido = "";
		return "reservas";
	}
	
	
	
	
	public List<Reserva> getListaReservas() {
		return listaReserva2;
	}
	public void setListaReserva(List<Reserva> listaReserva2) {
		this.listaReserva2 = listaReserva2;
	}
	public void actionListenerInsertarNuevoBien() {
		try {
			mReservas.insertarBien(beanSeagLogin.getLoginDTO(),nuevoBien);
			listaBienes=mReservas.findAllBienes();
			nuevoBien=new Bien();
			JSFUtil.crearMensajeINFO("Pago realizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerInsertarReserva() {
		try {
			if (bienElegido!=""&&usuarioElegido!="") {
				for (Bien bien : listaBienes) {
					if (bien.getBienId()==Integer.parseInt(bienElegido) ) {
						nuevaReserva.setBien(bien);
						break;
					}
				}
				for (SegUsuario usuario : listaUsuarios) {
					if (usuario.getIdSegUsuario()==Integer.parseInt(usuarioElegido) ) {
						nuevaReserva.setSegUsuario(usuario);
						break;
					}
				}
			}
			
			nuevaReserva.setFechaReserva(new Date());
			mReservas.insertarReserva(beanSeagLogin.getLoginDTO(),nuevaReserva);
			JSFUtil.crearMensajeINFO("Reserva creada");
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
	public Bien getNuevoBien() {
		return nuevoBien;
	}
	public void setNuevoBien(Bien nuevoBien) {
		this.nuevoBien = nuevoBien;
	}
	public List<Bien> getListaBienes() {
		return listaBienes;
	}
	public void setListaBienes(List<Bien> listaBienes) {
		this.listaBienes = listaBienes;
	}
	public String getBienElegido() {
		return bienElegido;
	}
	public void setBienElegido(String bienElegido) {
		this.bienElegido = bienElegido;
	}
	public String getUsuarioElegido() {
		return usuarioElegido;
	}
	public void setUsuarioElegido(String usuarioElegido) {
		this.usuarioElegido = usuarioElegido;
	}

	


}
