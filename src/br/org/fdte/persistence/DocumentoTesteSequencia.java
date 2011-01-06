/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "documento_teste_sequencia", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "DocumentoTesteSequencia.findAll", query = "SELECT d FROM DocumentoTesteSequencia d"), @NamedQuery(name = "DocumentoTesteSequencia.findById", query = "SELECT d FROM DocumentoTesteSequencia d WHERE d.id = :id"), @NamedQuery(name = "DocumentoTesteSequencia.findByTipo", query = "SELECT d FROM DocumentoTesteSequencia d WHERE d.tipo = :tipo")})
public class DocumentoTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "documento_teste_sequencia_id_seq", sequenceName = "documento_teste_sequencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "documento_teste_sequencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 2147483647)
    private String tipo;
    @Lob
    @Column(name = "documento")
    private byte[] documento;
    @JoinColumn(name = "id_ativacao_passo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AtivacaoPasso idAtivacaoPasso;

    public DocumentoTesteSequencia() {
    }

    public DocumentoTesteSequencia(Long id) {
        this.id = id;
    }

    public DocumentoTesteSequencia(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public AtivacaoPasso getIdAtivacaoPasso() {
        return idAtivacaoPasso;
    }

    public void setIdAtivacaoPasso(AtivacaoPasso idAtivacaoPasso) {
        this.idAtivacaoPasso = idAtivacaoPasso;
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
        if (!(object instanceof DocumentoTesteSequencia)) {
            return false;
        }
        DocumentoTesteSequencia other = (DocumentoTesteSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.DocumentoTesteSequencia[id=" + id + "]";
    }

}
