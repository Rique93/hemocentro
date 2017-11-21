/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Henrique Marques dos Santos
 */
@Entity
@Table(name = "doador")
@NamedQueries({
    @NamedQuery(name = "Doador.findAll", query = "SELECT d FROM Doador d"),
    @NamedQuery(name = "Doador.findByIdDoador", query = "SELECT d FROM Doador d WHERE d.idDoador = :idDoador"),
    @NamedQuery(name = "Doador.findByNomeDoador", query = "SELECT d FROM Doador d WHERE d.nomeDoador = :nomeDoador"),
    @NamedQuery(name = "Doador.findBySexo", query = "SELECT d FROM Doador d WHERE d.sexo = :sexo"),
    @NamedQuery(name = "Doador.findByDataNascimento", query = "SELECT d FROM Doador d WHERE d.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Doador.findByTipoDocumento", query = "SELECT d FROM Doador d WHERE d.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Doador.findByNumeroDocumento", query = "SELECT d FROM Doador d WHERE d.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Doador.findByOrgaoExpeditor", query = "SELECT d FROM Doador d WHERE d.orgaoExpeditor = :orgaoExpeditor"),
    @NamedQuery(name = "Doador.findByNaturalidade", query = "SELECT d FROM Doador d WHERE d.naturalidade = :naturalidade"),
    @NamedQuery(name = "Doador.findByNacionalidade", query = "SELECT d FROM Doador d WHERE d.nacionalidade = :nacionalidade"),
    @NamedQuery(name = "Doador.findByFiliacaoMaterna", query = "SELECT d FROM Doador d WHERE d.filiacaoMaterna = :filiacaoMaterna"),
    @NamedQuery(name = "Doador.findByFiliacaoPaterna", query = "SELECT d FROM Doador d WHERE d.filiacaoPaterna = :filiacaoPaterna"),
    @NamedQuery(name = "Doador.findByOcupacaoHabitual", query = "SELECT d FROM Doador d WHERE d.ocupacaoHabitual = :ocupacaoHabitual"),
    @NamedQuery(name = "Doador.findByCep", query = "SELECT d FROM Doador d WHERE d.cep = :cep"),
    @NamedQuery(name = "Doador.findByLogradouro", query = "SELECT d FROM Doador d WHERE d.logradouro = :logradouro"),
    @NamedQuery(name = "Doador.findByNumeroResidencia", query = "SELECT d FROM Doador d WHERE d.numeroResidencia = :numeroResidencia"),
    @NamedQuery(name = "Doador.findByBairro", query = "SELECT d FROM Doador d WHERE d.bairro = :bairro"),
    @NamedQuery(name = "Doador.findByCidade", query = "SELECT d FROM Doador d WHERE d.cidade = :cidade"),
    @NamedQuery(name = "Doador.findByTelefone", query = "SELECT d FROM Doador d WHERE d.telefone = :telefone"),
    @NamedQuery(name = "Doador.findByEmail", query = "SELECT d FROM Doador d WHERE d.email = :email"),
    @NamedQuery(name = "Doador.findByTipoSanguineo", query = "SELECT d FROM Doador d WHERE d.tipoSanguineo = :tipoSanguineo"),
    @NamedQuery(name = "Doador.findByEscolaridade", query = "SELECT d FROM Doador d WHERE d.escolaridade = :escolaridade")})
public class Doador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doador")
    private Integer idDoador;
    @Size(max = 50)
    @Column(name = "nome_doador")
    private String nomeDoador;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 50)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "numero_documento")
    private BigInteger numeroDocumento;
    @Size(max = 50)
    @Column(name = "orgao_expeditor")
    private String orgaoExpeditor;
    @Size(max = 20)
    @Column(name = "naturalidade")
    private String naturalidade;
    @Size(max = 20)
    @Column(name = "nacionalidade")
    private String nacionalidade;
    @Size(max = 50)
    @Column(name = "filiacao_materna")
    private String filiacaoMaterna;
    @Size(max = 50)
    @Column(name = "filiacao_paterna")
    private String filiacaoPaterna;
    @Size(max = 50)
    @Column(name = "ocupacao_habitual")
    private String ocupacaoHabitual;
    @Size(max = 10)
    @Column(name = "cep")
    private String cep;
    @Size(max = 50)
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero_residencia")
    private Integer numeroResidencia;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 20)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 12)
    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;
    @Size(max = 18)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 40)
    @Column(name = "escolaridade")
    private String escolaridade;
    @OneToMany(mappedBy = "doador")
    private List<Doacao> doacaoList;
    @JoinColumn(name = "usuario_identificacao", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioIdentificacao;
    @JoinColumn(name = "codigo_hospital", referencedColumnName = "id_hospital")
    @ManyToOne
    private Hospital codigoHospital;

    public Doador() {
    }

    public Doador(Integer idDoador) {
        this.idDoador = idDoador;
    }

    public Integer getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(Integer idDoador) {
        this.idDoador = idDoador;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getFiliacaoMaterna() {
        return filiacaoMaterna;
    }

    public void setFiliacaoMaterna(String filiacaoMaterna) {
        this.filiacaoMaterna = filiacaoMaterna;
    }

    public String getFiliacaoPaterna() {
        return filiacaoPaterna;
    }

    public void setFiliacaoPaterna(String filiacaoPaterna) {
        this.filiacaoPaterna = filiacaoPaterna;
    }

    public String getOcupacaoHabitual() {
        return ocupacaoHabitual;
    }

    public void setOcupacaoHabitual(String ocupacaoHabitual) {
        this.ocupacaoHabitual = ocupacaoHabitual;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    public Usuario getUsuarioIdentificacao() {
        return usuarioIdentificacao;
    }

    public void setUsuarioIdentificacao(Usuario usuarioIdentificacao) {
        this.usuarioIdentificacao = usuarioIdentificacao;
    }

    public Hospital getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(Hospital codigoHospital) {
        this.codigoHospital = codigoHospital;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoador != null ? idDoador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doador)) {
            return false;
        }
        Doador other = (Doador) object;
        if ((this.idDoador == null && other.idDoador != null) || (this.idDoador != null && !this.idDoador.equals(other.idDoador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Doador[ idDoador=" + idDoador + " ]";
    }

    public String getIdConverter() {
        return String.valueOf(idDoador);
    }
}
