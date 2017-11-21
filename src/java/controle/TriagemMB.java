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
import modelo.Pretriagem;
import modelo.Triagem;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "triagemMB")
@RequestScoped
public class TriagemMB implements Serializable{

    Triagem triagem;
    DAO<Triagem> triagemDAO;
    List<Triagem> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    /*
    
    */
    DAO<Pretriagem> pretriagemDAO;
    List<Pretriagem> pretriagens;
    
    Pretriagem pretriagem;
    
    
    public TriagemMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        triagemDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        
        /*
        
        */
        pretriagemDAO = new DAO<>("hemocentroPU");
        
        
        triagem = new Triagem();
        pretriagem = new Pretriagem();
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        
        /*
        
        */
        //pretriagens = pretriagemDAO.getAll(Pretriagem.class, "Pretriagem.findAll");
        pretriagens = pretriagemDAO.getPretriagensHabilitadas(Pretriagem.class, true, "Pretriagem.findByHabilitadoTriagem");
        
        this.listar();
    }
    
    
    @PreDestroy
    public void fechar(){
        triagemDAO.close();
        usuarioDAO.close();
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public List<Triagem> getLista() {
        return lista;
    }

    public void setLista(List<Triagem> lista) {
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

    public List<Pretriagem> getPretriagens() {
        return pretriagens;
    }

    public void setPretriagens(List<Pretriagem> pretriagens) {
        this.pretriagens = pretriagens;
    }

    public Pretriagem getPretriagem() {
        return pretriagem;
    }

    public void setPretriagem(Pretriagem pretriagem) {
        this.pretriagem = pretriagem;
    }
    
    
    
    
    
    
    public void novo(){
        triagem = new Triagem();
    }
    
    public void salvar(){
        if(triagem.getIdTriagem() == null)
            triagemDAO.insert(triagem);
        else
            triagemDAO.update(triagem);
        this.listar();
        this.novo();
    }
    
    public void editar(Triagem triagem){
        this.triagem = triagem;
    }
    
    public void excluir(Triagem triagem){
        triagemDAO.delete(triagem);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = triagemDAO.getAll(Triagem.class, "Triagem.findAll");
    }
    
    
    /*
    
    */
    
    public String teste(Pretriagem pretriagem){
        this.pretriagem = pretriagem;
        return "triagem";
    }
}
