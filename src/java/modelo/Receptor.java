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
@Table(name = "receptor")
@NamedQueries({
    @NamedQuery(name = "Receptor.findAll", query = "SELECT r FROM Receptor r"),
    @NamedQuery(name = "Receptor.findByIdReceptor", query = "SELECT r FROM Receptor r WHERE r.idReceptor = :idReceptor"),
    @NamedQuery(name = "Receptor.findByNomeReceptor", query = "SELECT r FROM Receptor r WHERE r.nomeReceptor = :nomeReceptor"),
    @NamedQuery(name = "Receptor.findByTipoSanguineo", query = "SELECT r FROM Receptor r WHERE r.tipoSanguineo = :tipoSanguineo")})
public class Receptor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receptor")
    private Integer idReceptor;
    @Size(max = 50)
    @Column(name = "nome_receptor")
    private String nomeReceptor;
    @Size(max = 12)
    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;
    @JoinColumn(name = "codigo_hospital", referencedColumnName = "id_hospital")
    @ManyToOne
    private Hospital codigoHospital;
    @OneToMany(mappedBy = "receptor")
    private List<Doacao> doacaoList;

    public Receptor() {
    }

    public Receptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    public Integer getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    public String getNomeReceptor() {
        return nomeReceptor;
    }

    public void setNomeReceptor(String nomeReceptor) {
        this.nomeReceptor = nomeReceptor;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Hospital getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(Hospital codigoHospital) {
        this.codigoHospital = codigoHospital;
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
        hash += (idReceptor != null ? idReceptor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receptor)) {
            return false;
        }
        Receptor other = (Receptor) object;
        if ((this.idReceptor == null && other.idReceptor != null) || (this.idReceptor != null && !this.idReceptor.equals(other.idReceptor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Receptor[ idReceptor=" + idReceptor + " ]";
    }
    
    public String getIdConverter() {
        return String.valueOf(idReceptor);
    }

}
