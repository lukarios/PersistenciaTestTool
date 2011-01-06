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
@Table(name = "especificos", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "Especificos.findAll", query = "SELECT e FROM Especificos e"), @NamedQuery(name = "Especificos.findById", query = "SELECT e FROM Especificos e WHERE e.id = :id"), @NamedQuery(name = "Especificos.findByTipo", query = "SELECT e FROM Especificos e WHERE e.tipo = :tipo"), @NamedQuery(name = "Especificos.findByQuantidade", query = "SELECT e FROM Especificos e WHERE e.quantidade = :quantidade")})
public class Especificos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "especificos_id_seq", sequenceName = "especificos_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "especificos_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "tipo", length = 2147483647)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @JoinColumn(name = "atributo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Atributo atributo;
    @JoinColumn(name = "id_caracterizacao_teste_validacao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteValidacao idCaracterizacaoTesteValidacao;

    public Especificos() {
    }

    public Especificos(Long id) {
        this.id = id;
    }

    public Especificos(Long id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

     public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public CaracterizacaoTesteValidacao getIdCaracterizacaoTesteValidacao() {
        return idCaracterizacaoTesteValidacao;
    }

    public void setIdCaracterizacaoTesteValidacao(CaracterizacaoTesteValidacao idCaracterizacaoTesteValidacao) {
        this.idCaracterizacaoTesteValidacao = idCaracterizacaoTesteValidacao;
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
        if (!(object instanceof Especificos)) {
            return false;
        }
        Especificos other = (Especificos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Especificos[id=" + id + "]";
    }

}
