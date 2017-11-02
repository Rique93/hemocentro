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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Henrique Marques dos Santos
 */
@Entity
@Table(name = "profissao")
@NamedQueries({
    @NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p"),
    @NamedQuery(name = "Profissao.findByIdProfissao", query = "SELECT p FROM Profissao p WHERE p.idProfissao = :idProfissao"),
    @NamedQuery(name = "Profissao.findByNomeProfissao", query = "SELECT p FROM Profissao p WHERE p.nomeProfissao = :nomeProfissao")})
public class Profissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profissao")
    private Integer idProfissao;
    @Size(max = 30)
    @Column(name = "nome_profissao")
    private String nomeProfissao;
    @OneToMany(mappedBy = "codigoProfissao")
    private List<Usuario> usuarioList;

    public Profissao() {
    }

    public Profissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
    }

    public Integer getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfissao != null ? idProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.idProfissao == null && other.idProfissao != null) || (this.idProfissao != null && !this.idProfissao.equals(other.idProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Profissao[ idProfissao=" + idProfissao + " ]";
    }

    
    public String getIdConverter() {
        return String.valueOf(idProfissao);
    }
}
