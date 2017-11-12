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
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelo.Doador;
import modelo.Pretriagem;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "pretriagemMB")
@RequestScoped
public class PretriagemMB implements Serializable{

    Pretriagem pretriagem;
    DAO<Pretriagem> pretriagemDAO;
    List<Pretriagem> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    
    /*
    
    */
    DAO<Doador> doadorDAO;
    List<Doador> doadores;
    
    Doador doador;
    
    
    public PretriagemMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        pretriagemDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        
        /*
        
        */
        doadorDAO = new DAO<>("hemocentroPU");
        
        
        pretriagem = new Pretriagem();
        doador = new Doador();
        
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        
        
        /*
        
        */
        doadores = doadorDAO.getAll(Doador.class, "Doador.findAll");
        
        
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        pretriagemDAO.close();
        usuarioDAO.close();
    }

    public Pretriagem getPretriagem() {
        return pretriagem;
    }

    public void setPretriagem(Pretriagem pretriagem) {
        this.pretriagem = pretriagem;
    }

    public List<Pretriagem> getLista() {
        return lista;
    }

    public void setLista(List<Pretriagem> lista) {
        this.lista = lista;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    /*
    
    */

    public List<Doador> getDoadores() {
        return doadores;
    }

    public void setDoadores(List<Doador> doadores) {
        this.doadores = doadores;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }
    
    
    
    
    public void novo(){
        pretriagem = new Pretriagem();
    }
    
    public void salvar(){
        if(pretriagem.getIdPretriagem() == null)
            pretriagemDAO.insert(pretriagem);
        else
            pretriagemDAO.update(pretriagem);
        this.listar();
        this.novo();
    }
    
    public void editar(Pretriagem pretriagem){
        this.pretriagem = pretriagem;
    }
    
    public void excluir(Pretriagem pretriagem){
        pretriagemDAO.delete(pretriagem);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = pretriagemDAO.getAll(Pretriagem.class, "Pretriagem.findAll");
    }
    
    
    /*
    
    */
    
    public String teste(Doador doador){
        this.doador = doador;
        return "pretriagem";
    }
    
}
