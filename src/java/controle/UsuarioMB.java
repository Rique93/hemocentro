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
import modelo.Funcao;
import modelo.Profissao;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable{
    
    Usuario usuario;
    DAO<Usuario> usuarioDAO;
    List<Usuario> lista;
    
    DAO<Funcao> funcaoDAO;
    List<Funcao> funcoes;
    
    DAO<Profissao> profissaoDAO;
    List<Profissao> profissoes;

    public UsuarioMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        usuarioDAO = new DAO<>("hemocentroPU");
        funcaoDAO = new DAO<>("hemocentroPU");
        profissaoDAO = new DAO<>("hemocentroPU");
        
        usuario = new Usuario();
        
        funcoes = funcaoDAO.getAll(Funcao.class, "Funcao.findAll");
        profissoes = profissaoDAO.getAll(Profissao.class, "Profissao.findAll");
        
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        usuarioDAO.close();
        funcaoDAO.close();
        profissaoDAO.close();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public List<Profissao> getProfissoes() {
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }
    
    public void novo(){
        usuario = new Usuario();
    }
    
    public void salvar(){
        if(usuario.getIdUsuario() == null)
            usuarioDAO.insert(usuario);
        else
            usuarioDAO.update(usuario);
        this.listar();
        this.novo();
    }
    
    public void editar(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void excluir(Usuario usuario){
        usuarioDAO.delete(usuario);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
    }
}
