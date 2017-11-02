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
import modelo.Profissao;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Profissao.class, value = "converterProfissao")
public class ConverterProfissao implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Profissao profissao = null;
        
        try{
            DAO<Profissao> p;
            p = new DAO<>("hemocentroPU");
            profissao = p.get(Profissao.class, Integer.parseInt(value));
        } catch (Exception e) {
            
        }
        return profissao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Profissao profissao = (Profissao) value;
        return profissao.getIdConverter();
    }

}
