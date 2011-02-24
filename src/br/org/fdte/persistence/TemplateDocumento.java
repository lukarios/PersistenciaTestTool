/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/* MB */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author MB
 */
@Entity
@Table(name = "template_documento", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({@NamedQuery(name = "TemplateDocumento.findAll", query = "SELECT t FROM TemplateDocumento t"), @NamedQuery(name = "TemplateDocumento.findById", query = "SELECT t FROM TemplateDocumento t WHERE t.id = :id"), @NamedQuery(name = "TemplateDocumento.findByNome", query = "SELECT t FROM TemplateDocumento t WHERE t.nome = :nome"), @NamedQuery(name = "TemplateDocumento.findByDirecao", query = "SELECT t FROM TemplateDocumento t WHERE t.direcao = :direcao"), @NamedQuery(name = "TemplateDocumento.findByArquivoXsd", query = "SELECT t FROM TemplateDocumento t WHERE t.arquivoXsd = :arquivoXsd"), @NamedQuery(name = "TemplateDocumento.findByTipoFisico", query = "SELECT t FROM TemplateDocumento t WHERE t.tipoFisico = :tipoFisico")})
public class TemplateDocumento implements Serializable, Comparable<TemplateDocumento> {

    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "template_documento_id_seq", sequenceName = "template_documento_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "template_documento_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Basic(optional = false)
    @Column(name = "direcao", nullable = false, length = 2147483647)
    private String direcao;
    @Column(name = "arquivo_xsd", length = 255)
    private String arquivoXsd;
    @Basic(optional = false)
    @Column(name = "tipo_fisico", nullable = false, length = 2147483647)
    private String tipoFisico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTemplateDocumento")
    private Collection<Atributo> atributoCollection;
    //lrb 24/02/2011 alterado o cascade type para regraCollection
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTemplateDocumento")
    private Collection<Regra> regraCollection;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoEntrada")
    private Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoSaidaPositiva")    
    private Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoSaidaNegativa")
    private Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection2;*/

    public TemplateDocumento() {
    }

    public TemplateDocumento(Long id) {
        this.id = id;
    }

    public TemplateDocumento(Long id, String nome, String direcao, String tipoFisico) {
        this.id = id;
        this.nome = nome;
        this.direcao = direcao;
        this.tipoFisico = tipoFisico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getArquivoXsd() {
        return arquivoXsd;
    }

    public void setArquivoXsd(String arquivoXsd) {
        this.arquivoXsd = arquivoXsd;
    }

    public String getTipoFisico() {
        return tipoFisico;
    }

    public void setTipoFisico(String tipoFisico) {
        this.tipoFisico = tipoFisico;
    }

    public Collection<Atributo> getAtributoCollection() {
        return atributoCollection;
    }

    public void setAtributoCollection(Collection<Atributo> atributoCollection) {
        this.atributoCollection = atributoCollection;
    }

    public Collection<Regra> getRegraCollection() {
        return regraCollection;
    }

    public void setRegraCollection(Collection<Regra> regraCollection) {
        this.regraCollection = regraCollection;
    }

    /*public Collection<CaracterizacaoTesteValidacao> getCaracterizacaoTesteValidacaoCollection() {
        return caracterizacaoTesteValidacaoCollection;
    }

    public void setCaracterizacaoTesteValidacaoCollection(Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection) {
        this.caracterizacaoTesteValidacaoCollection = caracterizacaoTesteValidacaoCollection;
    }

    public Collection<CaracterizacaoTesteValidacao> getCaracterizacaoTesteValidacaoCollection1() {
        return caracterizacaoTesteValidacaoCollection1;
    }

    public void setCaracterizacaoTesteValidacaoCollection1(Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection1) {
        this.caracterizacaoTesteValidacaoCollection1 = caracterizacaoTesteValidacaoCollection1;
    }

    public Collection<CaracterizacaoTesteValidacao> getCaracterizacaoTesteValidacaoCollection2() {
        return caracterizacaoTesteValidacaoCollection2;
    }

    public void setCaracterizacaoTesteValidacaoCollection2(Collection<CaracterizacaoTesteValidacao> caracterizacaoTesteValidacaoCollection2) {
        this.caracterizacaoTesteValidacaoCollection2 = caracterizacaoTesteValidacaoCollection2;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemplateDocumento)) {
            return false;
        }
        TemplateDocumento other = (TemplateDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.TemplateDocumento[id=" + id + "]";
    }

    /* LRB */
    public int compareTo(TemplateDocumento doc) {
        return nome.compareTo(doc.getNome());
    }

}
