/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Hospital;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Hospital.class, value = "converterHospital")
public class ConverterHospital implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Hospital hospital = null;
        
        try{
            DAO<Hospital> h;
            h = new DAO<>("hemocentroPU");
            hospital = h.get(Hospital.class, Integer.parseInt(value));
        } catch (Exception e){
            
        }
        return hospital;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Hospital hospital = (Hospital) value;
        return hospital.getIdConverter();
    }

}
