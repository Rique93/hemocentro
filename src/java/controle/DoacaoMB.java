package controle;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelo.Doacao;
import modelo.Doador;
import modelo.Triagem;
import modelo.Usuario;
import persistencia.DAO;

/**
 *
 * @author henrique
 */
@Named(value = "doacaoMB")
@RequestScoped
public class DoacaoMB implements Serializable{
    
    Doacao doacao;
    DAO<Doacao> doacaoDAO;
    List<Doacao> lista;
    
    DAO<Usuario> usuarioDAO;
    List<Usuario> usuarios;
    
    DAO<Doador> doadorDAO;
    List<Doador> doadores;
    
    /*
    
    */
    DAO<Triagem> triagemDAO;
    List<Triagem> triagens;
    
    Triagem triagem;

    public DoacaoMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        doacaoDAO = new DAO<>("hemocentroPU");
        usuarioDAO = new DAO<>("hemocentroPU");
        doadorDAO = new DAO<>("hemocentroPU");
        
        /*
        
        */
        triagemDAO = new DAO<>("hemocentroPU");
        
        
        doacao = new Doacao();
        triagem = new Triagem();
        
        usuarios = usuarioDAO.getAll(Usuario.class, "Usuario.findAll");
        doadores = doadorDAO.getAll(Doador.class, "Doador.findAll");
        
        /*
        
        */
        //triagens = triagemDAO.getAll(Triagem.class, "Triagem.findAll");
        triagens = triagemDAO.getTriagensHabilitadas(Triagem.class, true, "Triagem.findByHabilitadoDoacao");
        
        this.listar();
    }
    
    
    @PreDestroy
    public void fechar(){
        doacaoDAO.close();
        usuarioDAO.close();
        doadorDAO.close();
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

    public List<Doador> getDoadores() {
        return doadores;
    }

    public void setDoadores(List<Doador> doadores) {
        this.doadores = doadores;
    }

    public List<Triagem> getTriagens() {
        return triagens;
    }

    public void setTriagens(List<Triagem> triagens) {
        this.triagens = triagens;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
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
    
    public String teste(Triagem triagem){
        this.triagem = triagem;
        return "coleta";
    }
}
