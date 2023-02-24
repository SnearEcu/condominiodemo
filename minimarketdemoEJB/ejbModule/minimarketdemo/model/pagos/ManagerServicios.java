package minimarketdemo.model.pagos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Multa;
import minimarketdemo.model.core.entities.Reserva;
import minimarketdemo.model.core.entities.Servicio;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

/**
 * Session Bean implementation class ManagerReservas
 */
@Stateless
@LocalBean
public class ManagerServicios {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerServicios() {
    }
    public List<Servicio> findAllServicios(){
    	return mDAO.findAll(Servicio.class);
    }
    public List<DTOServicios> findAllDTOMulta(){
    	List<DTOServicios> listaDTO=new ArrayList<DTOServicios>();
    	for(Servicio servicio:findAllServicios()) {
    		DTOServicios nuevoDTO=new DTOServicios(servicio.getServId(),servicio.getValorServicio(),servicio.getTipoServicio().getNombreServicio());
    		listaDTO.add(nuevoDTO);
    	}
    	return listaDTO;
    }
    public Servicio inicializarServicio() {
    	Servicio servicio=new Servicio();
    	servicio.setValorServicio(0);
    	servicio.setTipoServicio(null);
    	return servicio;
    }
    public void insertarServicio(LoginDTO loginDTO,Servicio nuevaServicio) throws Exception{
    	if(nuevaServicio.getValorServicio()<0)
    		throw new Exception("El valor del servicio debe ser mayor a 0.");
    	mDAO.insertar(nuevaServicio);
    	mAuditoria.mostrarLog(loginDTO,getClass(), "insertarServicio", "Servicio de "+nuevaServicio.getTipoServicio().getNombreServicio()+" se a insertado exitosamente.");
    }
    

}
