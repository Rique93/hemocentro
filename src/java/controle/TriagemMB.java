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
import modelo.Triagem;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "triagemMB")
@ViewScoped
public class TriagemMB implements Serializable{

    Triagem triagem;
    DAO<Triagem> triagemDAO;
    List<Triagem> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    
    public TriagemMB() {
    }
    
    
    @PostConstruct
    public void inicializar(){
        triagemDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        
        
        triagem = new Triagem();
        
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        
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
    
    
}
