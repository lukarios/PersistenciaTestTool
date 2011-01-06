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
@Table(name = "regra", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "Regra.findAll", query = "SELECT r FROM Regra r"), @NamedQuery(name = "Regra.findById", query = "SELECT r FROM Regra r WHERE r.id = :id"), @NamedQuery(name = "Regra.findBySeAtributo", query = "SELECT r FROM Regra r WHERE r.seAtributo = :seAtributo"), @NamedQuery(name = "Regra.findBySeValor", query = "SELECT r FROM Regra r WHERE r.seValor = :seValor"), @NamedQuery(name = "Regra.findByEntaoAtributo", query = "SELECT r FROM Regra r WHERE r.entaoAtributo = :entaoAtributo"), @NamedQuery(name = "Regra.findByEntaoValor", query = "SELECT r FROM Regra r WHERE r.entaoValor = :entaoValor"), @NamedQuery(name = "Regra.findByComentario", query = "SELECT r FROM Regra r WHERE r.comentario = :comentario")})
public class Regra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "regra_id_seq", sequenceName = "regra_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "regra_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "se_atributo", nullable = false)
    private long seAtributo;
    @Column(name = "se_valor", length = 255)
    private String seValor;
    @Basic(optional = false)
    @Column(name = "entao_atributo", nullable = false)
    private long entaoAtributo;
    @Column(name = "entao_valor", length = 255)
    private String entaoValor;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @JoinColumn(name = "entao_relacao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RelacaoEntao entaoRelacao;
    @JoinColumn(name = "se_relacao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RelacaoSe seRelacao;
    @JoinColumn(name = "id_template_documento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TemplateDocumento idTemplateDocumento;

    public Regra() {
    }

    public Regra(Long id) {
        this.id = id;
    }

    public Regra(Long id, long seAtributo, long entaoAtributo) {
        this.id = id;
        this.seAtributo = seAtributo;
        this.entaoAtributo = entaoAtributo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSeAtributo() {
        return seAtributo;
    }

    public void setSeAtributo(long seAtributo) {
        this.seAtributo = seAtributo;
    }

    public String getSeValor() {
        return seValor;
    }

    public void setSeValor(String seValor) {
        this.seValor = seValor;
    }

    public long getEntaoAtributo() {
        return entaoAtributo;
    }

    public void setEntaoAtributo(long entaoAtributo) {
        this.entaoAtributo = entaoAtributo;
    }

    public String getEntaoValor() {
        return entaoValor;
    }

    public void setEntaoValor(String entaoValor) {
        this.entaoValor = entaoValor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

     public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public RelacaoEntao getEntaoRelacao() {
        return entaoRelacao;
    }

    public void setEntaoRelacao(RelacaoEntao entaoRelacao) {
        this.entaoRelacao = entaoRelacao;
    }

    public RelacaoSe getSeRelacao() {
        return seRelacao;
    }

    public void setSeRelacao(RelacaoSe seRelacao) {
        this.seRelacao = seRelacao;
    }

    public TemplateDocumento getIdTemplateDocumento() {
        return idTemplateDocumento;
    }

    public void setIdTemplateDocumento(TemplateDocumento idTemplateDocumento) {
        this.idTemplateDocumento = idTemplateDocumento;
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
        if (!(object instanceof Regra)) {
            return false;
        }
        Regra other = (Regra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Regra[id=" + id + "]";
    }

}
