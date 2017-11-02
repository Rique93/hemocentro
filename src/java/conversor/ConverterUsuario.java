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
import modelo.Usuario;
import persistencia.DAO;

/**
 * @author Henrique Marques dos Santos
 */
@FacesConverter(forClass = Usuario.class, value = "converterUsuario")
public class ConverterUsuario implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario usuario = null;
        
        try{
            DAO<Usuario> u;
            u = new DAO<>("hemocentroPU");
            usuario = u.get(Usuario.class, Integer.parseInt(value));
        } catch (Exception e){
            
        }
        return usuario;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Usuario usuario = (Usuario) value;
        return usuario.getIdConverter();
    }

}
