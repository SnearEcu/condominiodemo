package minimarketdemo.api.rest.reserva;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import minimarketdemo.model.reservas.DTOReserva;
import minimarketdemo.model.reservas.ManagerReservas;

@RequestScoped
@Path("reservas")
@Produces("application/json")
@Consumes("application/json")
public class ServiceRESTReservas {
	@EJB
	private ManagerReservas mReserva;
	
	// la ruta completa es:
	// /apirest/auditoria/bitacora
	@GET
	@Path(value = "reserva")
	public List<DTOReserva> findDTOReservas(){
		return mReserva.findAllDTOReservas();
	}
}
