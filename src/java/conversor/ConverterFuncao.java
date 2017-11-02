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
import modelo.Funcao;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Funcao.class, value = "converterFuncao")
public class ConverterFuncao implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Funcao funcao = null;
        
        try{
            DAO<Funcao> f;
            f = new DAO<>("hemocentroPU");
            funcao = f.get(Funcao.class, Integer.parseInt(value));
        } catch (Exception e) {
            
        }
        return funcao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Funcao funcao = (Funcao) value;
        return funcao.getIdConverter();
    }

}
