/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Hospital;
import modelo.Receptor;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "receptorMB")
@ViewScoped
public class ReceptorMB implements Serializable{

    Receptor receptor;
    DAO<Receptor> receptorDAO;
    List<Receptor> lista;
    
    DAO<Hospital> hospitalDAO;
    List<Hospital> hospitais;
    
    public ReceptorMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        receptorDAO = new DAO<>("hemocentroPU");
        hospitalDAO = new DAO<>("hemocentroPU");
        
        receptor = new Receptor();
        
        hospitais = hospitalDAO.getAll(Hospital.class, "Hospital.findAll");
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        receptorDAO.close();
        hospitalDAO.close();
    }

    public Receptor getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

    public List<Receptor> getLista() {
        return lista;
    }

    public void setLista(List<Receptor> lista) {
        this.lista = lista;
    }

    public List<Hospital> getHospitais() {
        return hospitais;
    }

    public void setHospitais(List<Hospital> hospitais) {
        this.hospitais = hospitais;
    }
    
    public void novo(){
        receptor = new Receptor();
    }
    
    public void salvar(){
        if(receptor.getIdReceptor() == null)
            receptorDAO.insert(receptor);
        else
            receptorDAO.update(receptor);
        this.listar();
        this.novo();
    }
    
    public void editar(Receptor receptor){
        this.receptor = receptor;
    }
    
    public void excluir(Receptor receptor){
        receptorDAO.delete(receptor);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = receptorDAO.getAll(Receptor.class, "Receptor.findAll");
    }
}

