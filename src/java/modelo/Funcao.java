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
@Table(name = "funcao")
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findByIdFuncao", query = "SELECT f FROM Funcao f WHERE f.idFuncao = :idFuncao"),
    @NamedQuery(name = "Funcao.findByNomeFuncao", query = "SELECT f FROM Funcao f WHERE f.nomeFuncao = :nomeFuncao")})
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcao")
    private Integer idFuncao;
    @Size(max = 20)
    @Column(name = "nome_funcao")
    private String nomeFuncao;
    @OneToMany(mappedBy = "codigoFuncao")
    private List<Usuario> usuarioList;

    public Funcao() {
    }

    public Funcao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
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
        hash += (idFuncao != null ? idFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.idFuncao == null && other.idFuncao != null) || (this.idFuncao != null && !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funcao[ idFuncao=" + idFuncao + " ]";
    }

    
    public String getIdConverter() {
        return String.valueOf(idFuncao);
    }
}
