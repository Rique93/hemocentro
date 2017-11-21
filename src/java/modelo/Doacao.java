/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Henrique Marques dos Santos
 */
@Entity
@Table(name = "doacao")
@NamedQueries({
    @NamedQuery(name = "Doacao.findAll", query = "SELECT d FROM Doacao d"),
    @NamedQuery(name = "Doacao.findByIdDoacao", query = "SELECT d FROM Doacao d WHERE d.idDoacao = :idDoacao"),
    @NamedQuery(name = "Doacao.findByTipoDoacao", query = "SELECT d FROM Doacao d WHERE d.tipoDoacao = :tipoDoacao"),
    @NamedQuery(name = "Doacao.findByDataDoacao", query = "SELECT d FROM Doacao d WHERE d.dataDoacao = :dataDoacao"),
    @NamedQuery(name = "Doacao.findByNumeroBolsa", query = "SELECT d FROM Doacao d WHERE d.numeroBolsa = :numeroBolsa"),
    @NamedQuery(name = "Doacao.findByQuantidadeSangue", query = "SELECT d FROM Doacao d WHERE d.quantidadeSangue = :quantidadeSangue")})
public class Doacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doacao")
    private Integer idDoacao;
    @Size(max = 15)
    @Column(name = "tipo_doacao")
    private String tipoDoacao;
    @Column(name = "data_doacao")
    @Temporal(TemporalType.DATE)
    private Date dataDoacao;
    @Column(name = "numero_bolsa")
    private Integer numeroBolsa;
    @Column(name = "quantidade_sangue")
    private Integer quantidadeSangue;
    @JoinColumn(name = "doador", referencedColumnName = "id_doador")
    @ManyToOne
    private Doador doador;
    @JoinColumn(name = "pretriagem", referencedColumnName = "id_pretriagem")
    @ManyToOne
    private Pretriagem pretriagem;
    @JoinColumn(name = "receptor", referencedColumnName = "id_doador")
    @ManyToOne
    private Doador receptor;
    @JoinColumn(name = "triagem", referencedColumnName = "id_triagem")
    @ManyToOne
    private Triagem triagem;
    @JoinColumn(name = "usuario_doacao", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioDoacao;

    public Doacao() {
    }

    public Doacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public String getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(String tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Integer getNumeroBolsa() {
        return numeroBolsa;
    }

    public void setNumeroBolsa(Integer numeroBolsa) {
        this.numeroBolsa = numeroBolsa;
    }

    public Integer getQuantidadeSangue() {
        return quantidadeSangue;
    }

    public void setQuantidadeSangue(Integer quantidadeSangue) {
        this.quantidadeSangue = quantidadeSangue;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Pretriagem getPretriagem() {
        return pretriagem;
    }

    public void setPretriagem(Pretriagem pretriagem) {
        this.pretriagem = pretriagem;
    }

    public Doador getReceptor() {
        return receptor;
    }

    public void setReceptor(Doador receptor) {
        this.receptor = receptor;
    }

    

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Usuario getUsuarioDoacao() {
        return usuarioDoacao;
    }

    public void setUsuarioDoacao(Usuario usuarioDoacao) {
        this.usuarioDoacao = usuarioDoacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoacao != null ? idDoacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doacao)) {
            return false;
        }
        Doacao other = (Doacao) object;
        if ((this.idDoacao == null && other.idDoacao != null) || (this.idDoacao != null && !this.idDoacao.equals(other.idDoacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Doacao[ idDoacao=" + idDoacao + " ]";
    }

}
