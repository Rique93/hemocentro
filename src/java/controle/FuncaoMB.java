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
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "funcaoMB")
@ViewScoped
public class FuncaoMB implements Serializable{
    
    Funcao funcao;
    DAO<Funcao> funcaoDAO;
    List<Funcao> lista;

    public FuncaoMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        funcaoDAO = new DAO<>("hemocentroPU");
        funcao = new Funcao();
        this.listar();
    }
    
    @PreDestroy
    public void fechar(){
        funcaoDAO.close();
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<Funcao> getLista() {
        return lista;
    }

    public void setLista(List<Funcao> lista) {
        this.lista = lista;
    }
    
    public void novo(){
        funcao = new Funcao();
    }
    
    public void salvar(){
        if(funcao.getIdFuncao() == null)
            funcaoDAO.insert(funcao);
        else
            funcaoDAO.update(funcao);
        this.listar();
        this.novo();
    }
    
    public void editar(Funcao funcao){
        this.funcao = funcao;
    }
    
    public void excluir(Funcao funcao){
        funcaoDAO.delete(funcao);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = funcaoDAO.getAll(Funcao.class, "Funcao.findAll");
    }
    
    
}
