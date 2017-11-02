/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Henrique Marques dos Santos
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNomeUsuario", query = "SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 50)
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Size(max = 15)
    @Column(name = "login")
    private String login;
    @Size(max = 15)
    @Column(name = "senha")
    private String senha;
    @OneToMany(mappedBy = "usuarioPretriagem")
    private List<Pretriagem> pretriagemList;
    @OneToMany(mappedBy = "usuarioDoacao")
    private List<Doacao> doacaoList;
    @OneToMany(mappedBy = "usuarioTriagem")
    private List<Triagem> triagemList;
    @JoinColumn(name = "codigo_funcao", referencedColumnName = "id_funcao")
    @ManyToOne
    private Funcao codigoFuncao;
    @JoinColumn(name = "codigo_profissao", referencedColumnName = "id_profissao")
    @ManyToOne
    private Profissao codigoProfissao;
    @OneToMany(mappedBy = "usuarioIdentificacao")
    private List<Doador> doadorList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pretriagem> getPretriagemList() {
        return pretriagemList;
    }

    public void setPretriagemList(List<Pretriagem> pretriagemList) {
        this.pretriagemList = pretriagemList;
    }

    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    public List<Triagem> getTriagemList() {
        return triagemList;
    }

    public void setTriagemList(List<Triagem> triagemList) {
        this.triagemList = triagemList;
    }

    public Funcao getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(Funcao codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public Profissao getCodigoProfissao() {
        return codigoProfissao;
    }

    public void setCodigoProfissao(Profissao codigoProfissao) {
        this.codigoProfissao = codigoProfissao;
    }

    public List<Doador> getDoadorList() {
        return doadorList;
    }

    public void setDoadorList(List<Doador> doadorList) {
        this.doadorList = doadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public String getIdConverter() {
        return String.valueOf(idUsuario);
    }
}
