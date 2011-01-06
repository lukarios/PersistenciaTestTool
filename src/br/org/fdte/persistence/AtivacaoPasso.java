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
@Table(name = "ativacao_passo", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "AtivacaoPasso.findAll", query = "SELECT a FROM AtivacaoPasso a"), @NamedQuery(name = "AtivacaoPasso.findById", query = "SELECT a FROM AtivacaoPasso a WHERE a.id = :id")})
public class AtivacaoPasso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "ativacao_passo_id_seq", sequenceName = "ativacao_passo_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "ativacao_passo_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_ativacao_teste_sequencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AtivacaoTesteSequencia idAtivacaoTesteSequencia;
    @JoinColumn(name = "id_passo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Passo idPasso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtivacaoPasso")
    private Collection<DocumentoTesteSequencia> documentoTesteSequenciaCollection;

    public AtivacaoPasso() {
    }

    public AtivacaoPasso(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtivacaoTesteSequencia getIdAtivacaoTesteSequencia() {
        return idAtivacaoTesteSequencia;
    }

    public void setIdAtivacaoTesteSequencia(AtivacaoTesteSequencia idAtivacaoTesteSequencia) {
        this.idAtivacaoTesteSequencia = idAtivacaoTesteSequencia;
    }

    public Passo getIdPasso() {
        return idPasso;
    }

    public void setIdPasso(Passo idPasso) {
        this.idPasso = idPasso;
    }

    public Collection<DocumentoTesteSequencia> getDocumentoTesteSequenciaCollection() {
        return documentoTesteSequenciaCollection;
    }

    public void setDocumentoTesteSequenciaCollection(Collection<DocumentoTesteSequencia> documentoTesteSequenciaCollection) {
        this.documentoTesteSequenciaCollection = documentoTesteSequenciaCollection;
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
        if (!(object instanceof AtivacaoPasso)) {
            return false;
        }
        AtivacaoPasso other = (AtivacaoPasso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.AtivacaoPasso[id=" + id + "]";
    }

}
