package minimarketdemo.controller.pagos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.seguridades.BeanSegLogin;
import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Alicuota;
import minimarketdemo.model.core.entities.DetallePago;
import minimarketdemo.model.core.entities.Multa;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.Servicio;
import minimarketdemo.model.core.entities.TipoServicio;
import minimarketdemo.model.pagos.ManagerPagos;
import minimarketdemo.model.reservas.ManagerReservas;
import minimarketdemo.model.seguridades.managers.ManagerSeguridades;

@Named
@SessionScoped
public class BeanPagos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerPagos mPagos;
	@EJB
	private ManagerSeguridades mSeguridad;
	
	private List<SegUsuario> listaUsuarios;
	private List<Pago> listaPagos;
	private List<Alicuota> listaAlicuotas;
	private List<Multa> listaMultas;
	private List<Servicio> listaServicios;
	private List<TipoServicio> listaTipoServicios;
	// Pagos pendientes
	private SegUsuario actualUsuario;
	private List<DetallePago> listaDetalles;
	
	private List<Alicuota> alicuotasPendientes;
	private List<Alicuota> alicuotasPorPagar;
	private double subTotalAlicuotas;
	
	private List<Multa> multasPendientes;
	private List<Multa> multasPorPagar;
	private double subTotalMultas;
	
	private List<Servicio> serviciosPendientes;
	private List<Servicio> serviciosPorPagar;
	private double subTotalServicios;
	
	private DetallePago nuevoDetalle;
	private Pago nuevoPago;
	private Alicuota nuevaAlicuota;
	private Multa nuevaMulta;
	private Servicio nuevoServicio;
	private TipoServicio nuevoTipoServicio;
	
	@Inject
	private BeanSegLogin beanSegLogin;
	
	public BeanPagos() {
		
	}
	
	public String actionMenuHistorial() {
		listaPagos=mPagos.findAllPagos();
		return "historial";
	}
	
	public String actionMenuAlicuotas() {
		listaAlicuotas=mPagos.findAllAlicuotas();
		nuevaAlicuota = new Alicuota();
		return "alicuotas";
	}
	public String actionMenuMultas() {
		listaMultas=mPagos.findAllMultas();
		nuevaMulta = new Multa();
		return "multas";
	}
	public String actionMenuServicios() {
		listaServicios=mPagos.findAllServicios();
		nuevoServicio = new Servicio();
		nuevoTipoServicio = new TipoServicio();
		return "servicios";
	}
		public String actionMenuNuevoPago() {
		nuevoPago=new Pago();
		listaDetalles = mPagos.findAllDetalles();
		nuevoDetalle = new DetallePago();
		actualUsuario = new SegUsuario();
		listaUsuarios = mSeguridad.findAllUsuarios();
		alicuotasPorPagar = new ArrayList<>();
		alicuotasPendientes = new ArrayList<>();
		subTotalAlicuotas = 0;
		
		multasPorPagar = new ArrayList<>();
		multasPendientes = new ArrayList<>();
		subTotalMultas = 0;
		
		serviciosPorPagar = new ArrayList<>();
		serviciosPendientes = new ArrayList<>();
		subTotalServicios = 0;
		return "pagos";
	}
	
	

	//	Ingreso de pagos, alicuotas,multas y servicios
	
	public void actionListenerInsertarNuevoPago() {
		try {
			mPagos.insertarPago(nuevoPago);
			listaPagos=mPagos.findAllPagos();
			nuevoPago=new Pago();
			JSFUtil.crearMensajeINFO("Pago realizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerInsertarNuevaAlicuota() {
		try {
			mPagos.insertarAlicuota(nuevaAlicuota);
			listaAlicuotas=mPagos.findAllAlicuotas();
			nuevaAlicuota=new Alicuota();
			JSFUtil.crearMensajeINFO("Nueva alicuota ingresada.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerInsertarNuevaMulta() {
		try {
			mPagos.insertarMulta(nuevaMulta);
			listaMultas=mPagos.findAllMultas();
			nuevaMulta=new Multa();
			JSFUtil.crearMensajeINFO("Nueva multa ingresada.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerInsertarNuevoServicio() {
		try {
			mPagos.insertarTipoServicio(nuevoTipoServicio);
			nuevoServicio.setTipoServicio(nuevoTipoServicio);
			mPagos.insertarServicio(nuevoServicio);
			listaServicios=mPagos.findAllServicios();
			nuevoServicio=new Servicio();
			JSFUtil.crearMensajeINFO("Nuevo servicio ingresada.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	// Elimiar pagos, alicuotas, multas y servicios
	public void actionListenerEliminarAlicuota(int idAlicuota) {
		try {
			mPagos.eliminarAlicouta(idAlicuota);
			listaAlicuotas=mPagos.findAllAlicuotas();
			JSFUtil.crearMensajeINFO("Alicuota eliminada");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarMulta(int idMulta) {
		try {
			mPagos.eliminarMulta(idMulta);
			listaMultas=mPagos.findAllMultas();
			JSFUtil.crearMensajeINFO("Multa eliminada");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarServicio(int idServicio,int idTipServicio) {
		try {
			mPagos.eliminarServicio(idServicio);
			mPagos.eliminarTipoServicio(idTipServicio);
			listaServicios=mPagos.findAllServicios();
			JSFUtil.crearMensajeINFO("Servicio eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Pagos pendientes
	
	public void actionListenerAlicuotasPendientes() {
		alicuotasPendientes=mPagos.findAllAlicuotas();
		multasPendientes = mPagos.findAllMultas();
		serviciosPendientes = mPagos.findAllServicios();
		try {
			for (Pago pago : listaPagos) {
				if (pago.getSegUsuario()==actualUsuario) {
					for (DetallePago detalle : listaDetalles) {
						if (detalle.getPago()==pago&&detalle.getAlicuota()!=null) {
							alicuotasPendientes.remove(detalle.getAlicuota());
							
						}
						if (detalle.getPago()==pago&&detalle.getAlicuota()!=null) {
							multasPendientes.remove(detalle.getMulta());
							
						}
						if (detalle.getPago()==pago&&detalle.getAlicuota()!=null) {
							serviciosPendientes.remove(detalle.getServicio());
						}
					}
				}
			}
		} catch (Exception e) {
			
		}
		
	}

	public void actionListenerCalcularAlicuotas () {
		subTotalAlicuotas=0;
		for (Alicuota alicuota : alicuotasPorPagar) {
			System.out.println("alicuota:"+multasPorPagar.size());
			subTotalAlicuotas+=alicuota.getValorAlicuota();
		}
		
	}
	public void actionListenerCalcularMultas () {

		subTotalMultas=0;
		for (Multa multa : multasPorPagar) {
			System.out.println("multas:"+multasPorPagar.size());
			subTotalMultas+=multa.getValorMulta();
		}

	}
	public void actionListenerCalcularServicios () {

		subTotalServicios=0;
		for (Servicio servicio : serviciosPorPagar) {
			System.out.println("servicios:"+multasPorPagar.size());
			subTotalServicios+=servicio.getValorServicio();
		}
	}
	
	
	

	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public Pago getNuevoPago() {
		return nuevoPago;
	}

	public void setNuevoPago(Pago nuevoPago) {
		this.nuevoPago = nuevoPago;
	}

	public BeanSegLogin getBeanSegLogin() {
		return beanSegLogin;
	}

	public void setBeanSegLogin(BeanSegLogin beanSegLogin) {
		this.beanSegLogin = beanSegLogin;
	}

	public List<Alicuota> getListaAlicuotas() {
		return listaAlicuotas;
	}

	public void setListaAlicuotas(List<Alicuota> listaAlicuotas) {
		this.listaAlicuotas = listaAlicuotas;
	}

	public List<Multa> getListaMultas() {
		return listaMultas;
	}

	public void setListaMultas(List<Multa> listaMultas) {
		this.listaMultas = listaMultas;
	}

	public List<Servicio> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}

	public Alicuota getNuevaAlicuota() {
		return nuevaAlicuota;
	}

	public void setNuevaAlicuota(Alicuota nuevaAlicuota) {
		this.nuevaAlicuota = nuevaAlicuota;
	}

	public Multa getNuevaMulta() {
		return nuevaMulta;
	}

	public void setNuevaMulta(Multa nuevaMulta) {
		this.nuevaMulta = nuevaMulta;
	}

	public Servicio getNuevoServicio() {
		return nuevoServicio;
	}

	public void setNuevoServicio(Servicio nuevoServicio) {
		this.nuevoServicio = nuevoServicio;
	}

	public List<TipoServicio> getListaTipoServicios() {
		return listaTipoServicios;
	}

	public void setListaTipoServicios(List<TipoServicio> listaTipoServicios) {
		this.listaTipoServicios = listaTipoServicios;
	}

	public TipoServicio getNuevoTipoServicio() {
		return nuevoTipoServicio;
	}

	public void setNuevoTipoServicio(TipoServicio nuevoTipoServicio) {
		this.nuevoTipoServicio = nuevoTipoServicio;
	}

	public List<SegUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<SegUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public DetallePago getNuevoDetalle() {
		return nuevoDetalle;
	}

	public void setNuevoDetalle(DetallePago nuevoDetalle) {
		this.nuevoDetalle = nuevoDetalle;
	}

	public SegUsuario getActualUsuario() {
		return actualUsuario;
	}

	public void setActualUsuario(SegUsuario actualUsuario) {
		this.actualUsuario = actualUsuario;
	}

	public List<Alicuota> getAlicuotasPendientes() {
		return alicuotasPendientes;
	}

	public void setAlicuotasPendientes(List<Alicuota> alicuotasPendientes) {
		this.alicuotasPendientes = alicuotasPendientes;
	}

	public List<Alicuota> getAlicuotasPorPagar() {
		return alicuotasPorPagar;
	}

	public void setAlicuotasPorPagar(List<Alicuota> alicuotasPorPagar) {
		this.alicuotasPorPagar = alicuotasPorPagar;
	}

	public List<DetallePago> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<DetallePago> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public double getSubTotalAlicuotas() {
		return subTotalAlicuotas;
	}

	public void setSubTotalAlicuotas(double subTotalAlicuotas) {
		this.subTotalAlicuotas = subTotalAlicuotas;
	}

	public List<Multa> getMultasPendientes() {
		return multasPendientes;
	}

	public void setMultasPendientes(List<Multa> multasPendientes) {
		this.multasPendientes = multasPendientes;
	}

	public List<Multa> getMultasPorPagar() {
		return multasPorPagar;
	}

	public void setMultasPorPagar(List<Multa> multasPorPagar) {
		this.multasPorPagar = multasPorPagar;
	}

	public double getSubTotalMultas() {
		return subTotalMultas;
	}

	public void setSubTotalMultas(double subTotalMultas) {
		this.subTotalMultas = subTotalMultas;
	}

	public List<Servicio> getServiciosPendientes() {
		return serviciosPendientes;
	}

	public void setServiciosPendientes(List<Servicio> serviciosPendientes) {
		this.serviciosPendientes = serviciosPendientes;
	}

	public List<Servicio> getServiciosPorPagar() {
		return serviciosPorPagar;
	}

	public void setServiciosPorPagar(List<Servicio> serviciosPorPagar) {
		this.serviciosPorPagar = serviciosPorPagar;
	}

	public double getSubTotalServicios() {
		return subTotalServicios;
	}

	public void setSubTotalServicios(double subTotalServicios) {
		this.subTotalServicios = subTotalServicios;
	}
	
	
		
}
