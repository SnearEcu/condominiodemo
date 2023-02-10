package minimarketdemo.model.reservas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Reserva;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

/**
 * Session Bean implementation class ManagerReservas
 */
@Stateless
@LocalBean
public class ManagerReservas {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerReservas() {
    }
    public List<Reserva> findAllReservas(){
    	return mDAO.findAll(Reserva.class);
    }
    public List<DTOReserva> findAllDTOReservas(){
    	List<DTOReserva> listaDTO=new ArrayList<DTOReserva>();
    	for(Reserva reserva:findAllReservas()) {
    		DTOReserva nuevoDTO=new DTOReserva(reserva.getResvId(),reserva.getSegUsuario().getNombres()+" "+reserva.getSegUsuario().getApellidos(),
    		reserva.getBien().getNombreBien(),reserva.getFechaReserva().toString(),reserva.getFechaInicio().toString(),reserva.getFechaFin().toString());
    		listaDTO.add(nuevoDTO);
    	}
    	return listaDTO;
    }
    public Reserva inicializarReserva() {
    	Reserva reserva=new Reserva();
    	reserva.setBien(null);
    	reserva.setFechaReserva(new Date());
    	reserva.setFechaInicio(new Date());
    	reserva.setFechaFin(ModelUtil.addDays(new Date(), 30));
    	return reserva;
    }
    public void insertarReserva(LoginDTO loginDTO,Reserva nuevaReserva) throws Exception{
    	if(nuevaReserva.getFechaFin().before(nuevaReserva.getFechaInicio()))
    		throw new Exception("La fecha de fin debe ser posterior a la fecha de inicio.");
    	mDAO.insertar(nuevaReserva);
    	mAuditoria.mostrarLog(loginDTO,getClass(), "insertarReserva", "Reserva de "+nuevaReserva.getBien()+" insertada exitosamente.");
    }
    

}
