package minimarketdemo.controller.reservas;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import minimarketdemo.model.core.entities.Bien;
import minimarketdemo.model.reservas.ManagerReservas;

@FacesConverter("bienConverter")
public class BienCorverter implements Converter<Object> {
	@EJB
	private ManagerReservas mReservas;
	private List<Bien> listaBienes;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		listaBienes = mReservas.findAllBienes();
		Integer id = Integer.parseInt(value);
		for (Bien bien : listaBienes) {
			if (bien.getBienId() == id) {
				return bien;

			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
            return "";
        }
        // Aquí debes implementar la lógica para convertir el objeto Bien en un valor que pueda ser mostrado en el selectOneMenu.
        Bien bien = (Bien) value;
        return bien.getBienId().toString();
	}

	public BienCorverter() {

	}

}
