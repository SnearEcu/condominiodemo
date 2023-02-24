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
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

/**
 * Session Bean implementation class ManagerReservas
 */
@Stateless
@LocalBean
public class ManagerMultas {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerMultas() {
    }
    public List<Multa> findAllMultas(){
    	return mDAO.findAll(Multa.class);
    }
    public List<DTOMulta> findAllDTOMulta(){
    	List<DTOMulta> listaDTO=new ArrayList<DTOMulta>();
    	for(Multa multa:findAllMultas()) {
    		DTOMulta nuevoDTO=new DTOMulta(multa.getMultId(),multa.getValorMulta(),multa.getTipoMulta());
    		listaDTO.add(nuevoDTO);
    	}
    	return listaDTO;
    }
    public Multa inicializarMulta() {
    	Multa multa=new Multa();
    	multa.setValorMulta(0);
    	multa.setTipoMulta(null);
    	return multa;
    }
    public void insertarMulta(LoginDTO loginDTO,Multa nuevaMulta) throws Exception{
    	if(nuevaMulta.getValorMulta()<0)
    		throw new Exception("El valor de la multa debe ser mayor a 0.");
    	mDAO.insertar(nuevaMulta);
    	mAuditoria.mostrarLog(loginDTO,getClass(), "insertarMulta", "Multa por "+nuevaMulta.getTipoMulta()+" insertada exitosamente.");
    }
    

}
