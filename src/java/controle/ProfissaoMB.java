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
import modelo.Profissao;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "profissaoMB")
@ViewScoped
public class ProfissaoMB implements Serializable{
    
    Profissao profissao;
    DAO<Profissao> profissaoDAO;
    List<Profissao> lista;

    public ProfissaoMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        profissaoDAO = new DAO<>("hemocentroPU");
        profissao = new Profissao();
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        profissaoDAO.close();
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getLista() {
        return lista;
    }

    public void setLista(List<Profissao> lista) {
        this.lista = lista;
    }
    
    public void novo(){
        profissao = new Profissao();
    }
    
    public void salvar(){
        if(profissao.getIdProfissao() == null)
            profissaoDAO.insert(profissao);
        else
            profissaoDAO.update(profissao);
        this.listar();
        this.novo();
    }
    
    public void editar(Profissao profissao){
        this.profissao = profissao;
    }
    
    public void excluir(Profissao profissao){
        profissaoDAO.delete(profissao);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = profissaoDAO.getAll(Profissao.class, "Profissao.findAll");
    }
}
