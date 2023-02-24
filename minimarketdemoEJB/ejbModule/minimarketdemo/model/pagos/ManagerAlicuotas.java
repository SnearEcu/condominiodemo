package minimarketdemo.model.pagos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.Alicuota;
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
public class ManagerAlicuotas {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

    /**
     * Default constructor. 
     */
    public ManagerAlicuotas() {
    }
    public List<Alicuota> findAllAlicuotas(){
    	return mDAO.findAll(Alicuota.class);
    }
    public List<DTOAlicuota> findAllDTOAlicuota(){
    	List<DTOAlicuota> listaDTO=new ArrayList<DTOAlicuota>();
    	for(Alicuota alicuota:findAllAlicuotas()) {
    		DTOAlicuota nuevoDTO=new DTOAlicuota(alicuota.getAliId(),alicuota.getValorAlicuota(),alicuota.getPeriodo());
    		listaDTO.add(nuevoDTO);
    	}
    	return listaDTO;
    }
    public Alicuota inicializarAlicuota() {
    	Alicuota alicuota=new Alicuota();
    	alicuota.setValorAlicuota(0);
    	alicuota.setPeriodo(null);
    	return alicuota;
    }
    public void insertarAlicuota(LoginDTO loginDTO,Alicuota nuevaAlicuota) throws Exception{
    	if(nuevaAlicuota.getValorAlicuota()<0)
    		throw new Exception("El valor de la alicuota debe ser mayor a 0.");
    	mDAO.insertar(nuevaAlicuota);
    	mAuditoria.mostrarLog(loginDTO,getClass(), "insertarAlicuota", "Alicuota del periodo:  "+nuevaAlicuota.getPeriodo()+" insertada exitosamente.");
    }
    

}
