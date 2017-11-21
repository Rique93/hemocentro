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
@Table(name = "hospital")
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findByIdHospital", query = "SELECT h FROM Hospital h WHERE h.idHospital = :idHospital"),
    @NamedQuery(name = "Hospital.findByNomeHospital", query = "SELECT h FROM Hospital h WHERE h.nomeHospital = :nomeHospital"),
    @NamedQuery(name = "Hospital.findByCep", query = "SELECT h FROM Hospital h WHERE h.cep = :cep"),
    @NamedQuery(name = "Hospital.findByCidade", query = "SELECT h FROM Hospital h WHERE h.cidade = :cidade")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hospital")
    private Integer idHospital;
    @Size(max = 80)
    @Column(name = "nome_hospital")
    private String nomeHospital;
    @Size(max = 10)
    @Column(name = "cep")
    private String cep;
    @Size(max = 20)
    @Column(name = "cidade")
    private String cidade;
    @OneToMany(mappedBy = "codigoHospital")
    private List<Doador> receptorList;

    public Hospital() {
    }

    public Hospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Doador> getReceptorList() {
        return receptorList;
    }

    public void setReceptorList(List<Doador> receptorList) {
        this.receptorList = receptorList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospital != null ? idHospital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.idHospital == null && other.idHospital != null) || (this.idHospital != null && !this.idHospital.equals(other.idHospital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Hospital[ idHospital=" + idHospital + " ]";
    }

    public String getIdConverter() {
        return String.valueOf(idHospital);
    }
}
