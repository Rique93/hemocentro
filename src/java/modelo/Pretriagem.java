/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pretriagem")
@NamedQueries({
    @NamedQuery(name = "Pretriagem.findAll", query = "SELECT p FROM Pretriagem p"),
    @NamedQuery(name = "Pretriagem.findByIdPretriagem", query = "SELECT p FROM Pretriagem p WHERE p.idPretriagem = :idPretriagem"),
    @NamedQuery(name = "Pretriagem.findByPulso", query = "SELECT p FROM Pretriagem p WHERE p.pulso = :pulso"),
    @NamedQuery(name = "Pretriagem.findByPressaoMi", query = "SELECT p FROM Pretriagem p WHERE p.pressaoMi = :pressaoMi"),
    @NamedQuery(name = "Pretriagem.findByPressaoMa", query = "SELECT p FROM Pretriagem p WHERE p.pressaoMa = :pressaoMa"),
    @NamedQuery(name = "Pretriagem.findByTemperatura", query = "SELECT p FROM Pretriagem p WHERE p.temperatura = :temperatura"),
    @NamedQuery(name = "Pretriagem.findByPeso", query = "SELECT p FROM Pretriagem p WHERE p.peso = :peso"),
    @NamedQuery(name = "Pretriagem.findByAltura", query = "SELECT p FROM Pretriagem p WHERE p.altura = :altura"),
    @NamedQuery(name = "Pretriagem.findByHemoglobina", query = "SELECT p FROM Pretriagem p WHERE p.hemoglobina = :hemoglobina"),
    @NamedQuery(name = "Pretriagem.findByHematocrito", query = "SELECT p FROM Pretriagem p WHERE p.hematocrito = :hematocrito"),
    @NamedQuery(name = "Pretriagem.findByHabilitadoTriagem", query = "SELECT p FROM Pretriagem p WHERE p.habilitadoTriagem = :habilitadoTriagem")})
public class Pretriagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pretriagem")
    private Integer idPretriagem;
    @Column(name = "pulso")
    private Integer pulso;
    @Column(name = "pressao_mi")
    private Integer pressaoMi;
    @Column(name = "pressao_ma")
    private Integer pressaoMa;
    @Column(name = "temperatura")
    private Integer temperatura;
    @Column(name = "peso")
    private Integer peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "altura")
    private BigDecimal altura;
    @Column(name = "hemoglobina")
    private BigDecimal hemoglobina;
    @Column(name = "hematocrito")
    private BigDecimal hematocrito;
    @Column(name = "habilitado_triagem")
    private Boolean habilitadoTriagem;
    @JoinColumn(name = "usuario_pretriagem", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioPretriagem;
    @OneToMany(mappedBy = "pretriagem")
    private List<Doacao> doacaoList;

    public Pretriagem() {
    }

    public Pretriagem(Integer idPretriagem) {
        this.idPretriagem = idPretriagem;
    }

    public Integer getIdPretriagem() {
        return idPretriagem;
    }

    public void setIdPretriagem(Integer idPretriagem) {
        this.idPretriagem = idPretriagem;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
    }

    public Integer getPressaoMi() {
        return pressaoMi;
    }

    public void setPressaoMi(Integer pressaoMi) {
        this.pressaoMi = pressaoMi;
    }

    public Integer getPressaoMa() {
        return pressaoMa;
    }

    public void setPressaoMa(Integer pressaoMa) {
        this.pressaoMa = pressaoMa;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getHemoglobina() {
        return hemoglobina;
    }

    public void setHemoglobina(BigDecimal hemoglobina) {
        this.hemoglobina = hemoglobina;
    }

    public BigDecimal getHematocrito() {
        return hematocrito;
    }

    public void setHematocrito(BigDecimal hematocrito) {
        this.hematocrito = hematocrito;
    }

    public Boolean getHabilitadoTriagem() {
        return habilitadoTriagem;
    }

    public void setHabilitadoTriagem(Boolean habilitadoTriagem) {
        this.habilitadoTriagem = habilitadoTriagem;
    }

    public Usuario getUsuarioPretriagem() {
        return usuarioPretriagem;
    }

    public void setUsuarioPretriagem(Usuario usuarioPretriagem) {
        this.usuarioPretriagem = usuarioPretriagem;
    }

    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPretriagem != null ? idPretriagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pretriagem)) {
            return false;
        }
        Pretriagem other = (Pretriagem) object;
        if ((this.idPretriagem == null && other.idPretriagem != null) || (this.idPretriagem != null && !this.idPretriagem.equals(other.idPretriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pretriagem[ idPretriagem=" + idPretriagem + " ]";
    }

}
