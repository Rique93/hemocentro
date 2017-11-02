/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author henrique
 */
@Named(value = "autoComplete")
@ViewScoped
public class AutoComplete implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> nomes = new ArrayList<String>();
    private String Municipio;
    
    public AutoComplete() {
        nomes.add("Recife");
        nomes.add("Tocantes");
        nomes.add("São Paulo");
        nomes.add("Minas Gerais");
        nomes.add("Curitiba");
        nomes.add("Porto Alegre");
        nomes.add("Belo Horizonte");
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }
    
    
    public List<String> sugerirNomes(String consulta){
        List<String> nomesSugeridos = new ArrayList<String>();
        
        for (String indiceNomes : this.nomes){
            if (indiceNomes.toLowerCase().startsWith(consulta.toLowerCase())) {
                nomesSugeridos.add(indiceNomes);
            }
        }
        return nomesSugeridos;
    }
}
