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
import modelo.Doador;
import modelo.Hospital;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "doadorMB")
@ViewScoped
public class DoadorMB implements Serializable{

    Doador doador;
    DAO<Doador> doadorDAO;
    List<Doador> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    DAO<Hospital> hospitalDAO;
    List<Hospital> hospitais;
    
    public DoadorMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        doadorDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        hospitalDAO = new DAO<>("hemocentroPU");
        
        doador = new Doador();
        
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        hospitais = hospitalDAO.getAll(Hospital.class, "Hospital.findAll");
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        doadorDAO.close();
        usuarioDAO.close();
        hospitalDAO.close();
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public List<Doador> getLista() {
        return lista;
    }

    public void setLista(List<Doador> lista) {
        this.lista = lista;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Hospital> getHospitais() {
        return hospitais;
    }

    public void setHospitais(List<Hospital> hospitais) {
        this.hospitais = hospitais;
    }
    
    
    
    public void novo(){
        doador = new Doador();
    }
    
    public void salvar(){
        if(doador.getIdDoador() == null)
            doadorDAO.insert(doador);
        else
            doadorDAO.update(doador);
        this.listar();
        this.novo();
    }
    
    public void editar(Doador doador){
        this.doador = doador;
    }
    
    public void excluir(Doador doador){
        doadorDAO.delete(doador);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = doadorDAO.getAll(Doador.class, "Doador.findAll");
    }
}
