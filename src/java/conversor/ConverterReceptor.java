package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Receptor;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Receptor.class, value = "converterReceptor")
public class ConverterReceptor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Receptor receptor = null;
        
        try{
            DAO<Receptor> r;
            r = new DAO<>("hemocentroPU");
            receptor = r.get(Receptor.class, Integer.parseInt(value));
        } catch (Exception e){
            
        }
        return receptor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Receptor receptor = (Receptor) value;
        return receptor.getIdConverter();
    }

}
