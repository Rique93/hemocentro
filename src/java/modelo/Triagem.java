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

/**
 * @author Henrique Marques dos Santos
 */
@Entity
@Table(name = "triagem")
@NamedQueries({
    @NamedQuery(name = "Triagem.findAll", query = "SELECT t FROM Triagem t"),
    @NamedQuery(name = "Triagem.findByIdTriagem", query = "SELECT t FROM Triagem t WHERE t.idTriagem = :idTriagem"),
    @NamedQuery(name = "Triagem.findByHabilitadoDoacao", query = "SELECT t FROM Triagem t WHERE t.habilitadoDoacao = :habilitadoDoacao")})
public class Triagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_triagem")
    private Integer idTriagem;
    @Column(name = "habilitado_doacao")
    private Boolean habilitadoDoacao;
    @OneToMany(mappedBy = "triagem")
    private List<Doacao> doacaoList;
    @JoinColumn(name = "usuario_triagem", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioTriagem;

    public Triagem() {
    }

    public Triagem(Integer idTriagem) {
        this.idTriagem = idTriagem;
    }

    public Integer getIdTriagem() {
        return idTriagem;
    }

    public void setIdTriagem(Integer idTriagem) {
        this.idTriagem = idTriagem;
    }

    public Boolean getHabilitadoDoacao() {
        return habilitadoDoacao;
    }

    public void setHabilitadoDoacao(Boolean habilitadoDoacao) {
        this.habilitadoDoacao = habilitadoDoacao;
    }

    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    public Usuario getUsuarioTriagem() {
        return usuarioTriagem;
    }

    public void setUsuarioTriagem(Usuario usuarioTriagem) {
        this.usuarioTriagem = usuarioTriagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTriagem != null ? idTriagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Triagem)) {
            return false;
        }
        Triagem other = (Triagem) object;
        if ((this.idTriagem == null && other.idTriagem != null) || (this.idTriagem != null && !this.idTriagem.equals(other.idTriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Triagem[ idTriagem=" + idTriagem + " ]";
    }

}
