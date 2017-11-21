package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Doador;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Doador.class, value = "converterDoador")
public class ConverterDoador implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Doador doador = null;
        
        try{
            DAO<Doador> d;
            d = new DAO<>("hemocentroPU");
            doador = d.get(Doador.class, Integer.parseInt(value));
        } catch (Exception e){
            
        }
        return doador;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Doador doador = (Doador) value;
        return doador.getIdConverter();
    }

}
