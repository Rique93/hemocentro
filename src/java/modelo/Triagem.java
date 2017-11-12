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
    
    
    
    
    @Column(name = "pergunta1")
    private Boolean pergunta1;
    
    @Column(name = "pergunta2")
    private Boolean pergunta2;
    
    @Column(name = "pergunta3")
    private Boolean pergunta3;
    
    @Column(name = "pergunta4")
    private Boolean pergunta4;
    
    @Column(name = "pergunta5")
    private Boolean pergunta5;
    
    @Column(name = "pergunta6")
    private Boolean pergunta6;
    
    @Column(name = "pergunta7")
    private Boolean pergunta7;
    
    @Column(name = "pergunta8")
    private Boolean pergunta8;
    
    @Column(name = "pergunta9")
    private Boolean pergunta9;
    
    @Column(name = "pergunta10")
    private Boolean pergunta10;
    
    @Column(name = "pergunta11")
    private Boolean pergunta11;
    
    @Column(name = "pergunta12")
    private Boolean pergunta12;
    
    @Column(name = "pergunta13")
    private Boolean pergunta13;
    
    @Column(name = "pergunta14")
    private Boolean pergunta14;
    
    @Column(name = "pergunta15")
    private Boolean pergunta15;
    
    @Column(name = "pergunta16")
    private Boolean pergunta16;
    
    @Column(name = "pergunta17")
    private Boolean pergunta17;
    
    @Column(name = "pergunta18")
    private Boolean pergunta18;
    
    @Column(name = "pergunta19")
    private Boolean pergunta19;
    
    @Column(name = "pergunta20")
    private Boolean pergunta20;
    
    @Column(name = "pergunta21")
    private Boolean pergunta21;
    
    @Column(name = "pergunta22")
    private Boolean pergunta22;
    
    @Column(name = "pergunta23")
    private Boolean pergunta23;
    
    @Column(name = "pergunta24")
    private Boolean pergunta24;
    
    
    
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

    public Boolean getPergunta1() {
        return pergunta1;
    }

    public void setPergunta1(Boolean pergunta1) {
        this.pergunta1 = pergunta1;
    }

    public Boolean getPergunta2() {
        return pergunta2;
    }

    public void setPergunta2(Boolean pergunta2) {
        this.pergunta2 = pergunta2;
    }

    public Boolean getPergunta3() {
        return pergunta3;
    }

    public void setPergunta3(Boolean pergunta3) {
        this.pergunta3 = pergunta3;
    }

    public Boolean getPergunta4() {
        return pergunta4;
    }

    public void setPergunta4(Boolean pergunta4) {
        this.pergunta4 = pergunta4;
    }

    public Boolean getPergunta5() {
        return pergunta5;
    }

    public void setPergunta5(Boolean pergunta5) {
        this.pergunta5 = pergunta5;
    }

    public Boolean getPergunta6() {
        return pergunta6;
    }

    public void setPergunta6(Boolean pergunta6) {
        this.pergunta6 = pergunta6;
    }

    public Boolean getPergunta7() {
        return pergunta7;
    }

    public void setPergunta7(Boolean pergunta7) {
        this.pergunta7 = pergunta7;
    }

    public Boolean getPergunta8() {
        return pergunta8;
    }

    public void setPergunta8(Boolean pergunta8) {
        this.pergunta8 = pergunta8;
    }

    public Boolean getPergunta9() {
        return pergunta9;
    }

    public void setPergunta9(Boolean pergunta9) {
        this.pergunta9 = pergunta9;
    }

    public Boolean getPergunta10() {
        return pergunta10;
    }

    public void setPergunta10(Boolean pergunta10) {
        this.pergunta10 = pergunta10;
    }

    public Boolean getPergunta11() {
        return pergunta11;
    }

    public void setPergunta11(Boolean pergunta11) {
        this.pergunta11 = pergunta11;
    }

    public Boolean getPergunta12() {
        return pergunta12;
    }

    public void setPergunta12(Boolean pergunta12) {
        this.pergunta12 = pergunta12;
    }

    public Boolean getPergunta13() {
        return pergunta13;
    }

    public void setPergunta13(Boolean pergunta13) {
        this.pergunta13 = pergunta13;
    }

    public Boolean getPergunta14() {
        return pergunta14;
    }

    public void setPergunta14(Boolean pergunta14) {
        this.pergunta14 = pergunta14;
    }

    public Boolean getPergunta15() {
        return pergunta15;
    }

    public void setPergunta15(Boolean pergunta15) {
        this.pergunta15 = pergunta15;
    }

    public Boolean getPergunta16() {
        return pergunta16;
    }

    public void setPergunta16(Boolean pergunta16) {
        this.pergunta16 = pergunta16;
    }

    public Boolean getPergunta17() {
        return pergunta17;
    }

    public void setPergunta17(Boolean pergunta17) {
        this.pergunta17 = pergunta17;
    }

    public Boolean getPergunta18() {
        return pergunta18;
    }

    public void setPergunta18(Boolean pergunta18) {
        this.pergunta18 = pergunta18;
    }

    public Boolean getPergunta19() {
        return pergunta19;
    }

    public void setPergunta19(Boolean pergunta19) {
        this.pergunta19 = pergunta19;
    }

    public Boolean getPergunta20() {
        return pergunta20;
    }

    public void setPergunta20(Boolean pergunta20) {
        this.pergunta20 = pergunta20;
    }

    public Boolean getPergunta21() {
        return pergunta21;
    }

    public void setPergunta21(Boolean pergunta21) {
        this.pergunta21 = pergunta21;
    }

    public Boolean getPergunta22() {
        return pergunta22;
    }

    public void setPergunta22(Boolean pergunta22) {
        this.pergunta22 = pergunta22;
    }

    public Boolean getPergunta23() {
        return pergunta23;
    }

    public void setPergunta23(Boolean pergunta23) {
        this.pergunta23 = pergunta23;
    }

    public Boolean getPergunta24() {
        return pergunta24;
    }

    public void setPergunta24(Boolean pergunta24) {
        this.pergunta24 = pergunta24;
    }

    
    
    
    
    
}
