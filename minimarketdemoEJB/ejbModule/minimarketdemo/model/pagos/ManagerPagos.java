package minimarketdemo.model.pagos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Alicuota;
import minimarketdemo.model.core.entities.DetallePago;
import minimarketdemo.model.core.entities.Multa;
import minimarketdemo.model.core.entities.Pago;
import minimarketdemo.model.core.entities.SegAsignacion;
import minimarketdemo.model.core.entities.SegModulo;
import minimarketdemo.model.core.entities.SegPerfil;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.Servicio;
import minimarketdemo.model.core.entities.TipoServicio;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

/**
 * Implementa la logica de manejo de usuarios y autenticacion.
 * Funcionalidades principales:
 * <ul>
 * 	<li>Verificacion de credenciales de usuario.</li>
 *  <li>Asignacion de modulos a un usuario.</li>
 * </ul>
 * @author mrea
 */
@Stateless
@LocalBean
public class ManagerPagos {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
    /**
     * Default constructor. 
     */
    public ManagerPagos() {
        
    }
    public List<Pago> findAllPagos(){
    	return mDAO.findAll(Pago.class);
    }
    public List<Alicuota> findAllAlicuotas(){
    	return mDAO.findAll(Alicuota.class);
    }
    public List<Multa> findAllMultas(){
    	return mDAO.findAll(Multa.class);
    }
    public List<Servicio> findAllServicios(){
    	return mDAO.findAll(Servicio.class);
    }
    public List<Servicio> findAllTipoServicios(){
    	return mDAO.findAll(TipoServicio.class);
    }
    public List<DetallePago> findAllDetalles(){
    	return mDAO.findAll(DetallePago.class);
    }
    
    public SegUsuario findByIdSegUsuario(int idSegUsuario) throws Exception {
    	return (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
    }
    
    public void insertarPago(Pago nuevoPago) throws Exception {
    	nuevoPago.setFechaPago(new java.util.Date());;
    	mDAO.insertar(nuevoPago);
    }
    public void insertarAlicuota(Alicuota nuevaAlicuota) throws Exception {
    	mDAO.insertar(nuevaAlicuota);
    }
    public void insertarMulta(Multa nuevaMulta) throws Exception {
    	mDAO.insertar(nuevaMulta);
    }
    public void insertarServicio(Servicio nuevoServicio) throws Exception {
    	mDAO.insertar(nuevoServicio);
    }
    public void insertarTipoServicio(TipoServicio nuevoServicio) throws Exception {
    	mDAO.insertar(nuevoServicio);
    }
    
    
    public void eliminarAlicouta(int idAlicuota) throws Exception {
    	Alicuota item=(Alicuota) mDAO.findById(Alicuota.class, idAlicuota);
    	if(item.getDetallePagos().size()>0)
    		throw new Exception("No se puede eliminar este item porque tiene pagos asignados.");
    	mDAO.eliminar(Alicuota.class, idAlicuota);
    }
    public void eliminarMulta(int idMulta) throws Exception {
    	Multa item=(Multa) mDAO.findById(Multa.class, idMulta);
    	if(item.getDetallePagos().size()>0)
    		throw new Exception("No se puede eliminar este item porque tiene pagos asignados.");
    	mDAO.eliminar(Multa.class, idMulta);
    }
    public void eliminarServicio(int idServicio) throws Exception {
    	Servicio item=(Servicio) mDAO.findById(Servicio.class, idServicio);
    	if(item.getDetallePagos().size()>0)
    		throw new Exception("No se puede eliminar este item porque tiene pagos asignados.");
    	mDAO.eliminar(Servicio.class, idServicio);
    }
    public void eliminarTipoServicio(int idTipoServicio) throws Exception {
    	mDAO.eliminar(TipoServicio.class, idTipoServicio);
    }
      
    
}
