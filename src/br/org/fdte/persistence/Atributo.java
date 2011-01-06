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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* MB */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;

/**
 *
 * @author MB
 */
@Entity
@Table(name = "atributo", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "Atributo.findAll", query = "SELECT a FROM Atributo a"), @NamedQuery(name = "Atributo.findById", query = "SELECT a FROM Atributo a WHERE a.id = :id"), @NamedQuery(name = "Atributo.findByTag", query = "SELECT a FROM Atributo a WHERE a.tag = :tag"), @NamedQuery(name = "Atributo.findByOpcional", query = "SELECT a FROM Atributo a WHERE a.opcional = :opcional"), @NamedQuery(name = "Atributo.findByNumeroMaximoOcorrencias", query = "SELECT a FROM Atributo a WHERE a.numeroMaximoOcorrencias = :numeroMaximoOcorrencias")})
public class Atributo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "atributo_id_seq", sequenceName = "atributo_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "atributo_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "tag", nullable = false, length = 255)
    private String tag;
    @Basic(optional = false)
    @Column(name = "opcional", nullable = false, length = 2147483647)
    private String opcional;
    @Basic(optional = false)
    @Column(name = "numero_maximo_ocorrencias", nullable = false)
    private int numeroMaximoOcorrencias;
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @JoinColumn(name = "id_classe_equivalencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClasseEquivalencia idClasseEquivalencia;
    @JoinColumn(name = "id_template_documento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TemplateDocumento idTemplateDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atributo")
    private Collection<Especificos> especificosCollection;

    public Atributo() {
    }

    public Atributo(Long id) {
        this.id = id;
    }

    public Atributo(Long id, String tag, String opcional, int numeroMaximoOcorrencias) {
        this.id = id;
        this.tag = tag;
        this.opcional = opcional;
        this.numeroMaximoOcorrencias = numeroMaximoOcorrencias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOpcional() {
        return opcional;
    }

    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }

    public int getNumeroMaximoOcorrencias() {
        return numeroMaximoOcorrencias;
    }

    public void setNumeroMaximoOcorrencias(int numeroMaximoOcorrencias) {
        this.numeroMaximoOcorrencias = numeroMaximoOcorrencias;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ClasseEquivalencia getIdClasseEquivalencia() {
        return idClasseEquivalencia;
    }

    public void setIdClasseEquivalencia(ClasseEquivalencia idClasseEquivalencia) {
        this.idClasseEquivalencia = idClasseEquivalencia;
    }

    public TemplateDocumento getIdTemplateDocumento() {
        return idTemplateDocumento;
    }

    public void setIdTemplateDocumento(TemplateDocumento idTemplateDocumento) {
        this.idTemplateDocumento = idTemplateDocumento;
    }

    public Collection<Especificos> getEspecificosCollection() {
        return especificosCollection;
    }

    public void setEspecificosCollection(Collection<Especificos> especificosCollection) {
        this.especificosCollection = especificosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Atributo[id=" + id + "]";
    }

}
