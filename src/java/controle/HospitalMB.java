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
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "hospitalMB")
@ViewScoped
public class HospitalMB implements Serializable{

    Hospital hospital;
    DAO<Hospital> hospitalDAO;
    List<Hospital> lista;
    
    public HospitalMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        hospitalDAO = new DAO<>("hemocentroPU");
        hospital = new Hospital();
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        hospitalDAO.close();
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Hospital> getLista() {
        return lista;
    }

    public void setLista(List<Hospital> lista) {
        this.lista = lista;
    }
    
    public void novo(){
        hospital = new Hospital();
    }
    
    public void salvar(){
        if(hospital.getIdHospital() == null)
            hospitalDAO.insert(hospital);
        else
            hospitalDAO.update(hospital);
        this.listar();
        this.novo();
    }
    
    public void editar(Hospital hospital){
        this.hospital = hospital;
    }
    
    public void excluir(Hospital hospital){
        hospitalDAO.delete(hospital);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = hospitalDAO.getAll(Hospital.class, "Hospital.findAll");
    }
}
