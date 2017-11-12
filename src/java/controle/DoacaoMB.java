package controle;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Doacao;
import modelo.Receptor;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "doacaoMB")
@ViewScoped
public class DoacaoMB implements Serializable{
    
    Doacao doacao;
    DAO<Doacao> doacaoDAO;
    List<Doacao> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    DAO<Receptor> receptorDAO;
    List<Receptor> receptores;

    public DoacaoMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        doacaoDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        receptorDAO = new DAO<>("hemocentroPU");
        
        
        doacao = new Doacao();
        
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        receptores = receptorDAO.getAll(Receptor.class, "Receptor.findAll");
        
        this.listar();
    }
    
    
    @PreDestroy
    public void fechar(){
        doacaoDAO.close();
        usuarioDAO.close();
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public List<Doacao> getLista() {
        return lista;
    }

    public void setLista(List<Doacao> lista) {
        this.lista = lista;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Receptor> getReceptores() {
        return receptores;
    }

    public void setReceptores(List<Receptor> receptores) {
        this.receptores = receptores;
    }
   
    
    public void novo(){
        doacao = new Doacao();
    }
    
    public void salvar(){
        if(doacao.getIdDoacao() == null)
            doacaoDAO.insert(doacao);
        else
            doacaoDAO.update(doacao);
        this.listar();
        this.novo();
    }
    
    public void editar(Doacao doacao){
        this.doacao = doacao;
    }
    
    public void excluir(Doacao doacao){
        doacaoDAO.delete(doacao);
        this.listar();
        this.novo();
    }
    
    public void listar(){
        lista = doacaoDAO.getAll(Doacao.class, "Doacao.findAll");
    }
}
