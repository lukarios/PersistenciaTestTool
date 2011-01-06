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
@Table(name = "valor", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v"), @NamedQuery(name = "Valor.findById", query = "SELECT v FROM Valor v WHERE v.id = :id"), @NamedQuery(name = "Valor.findByValor", query = "SELECT v FROM Valor v WHERE v.valor = :valor"), @NamedQuery(name = "Valor.findByPositivoNegativo", query = "SELECT v FROM Valor v WHERE v.positivoNegativo = :positivoNegativo"), @NamedQuery(name = "Valor.findByComentario", query = "SELECT v FROM Valor v WHERE v.comentario = :comentario")})
public class Valor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "valor_id_seq", sequenceName = "valor_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "valor_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false, length = 2147483647)
    private String valor;
    @Basic(optional = false)
    @Column(name = "positivo_negativo", nullable = false, length = 2147483647)
    private String positivoNegativo;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @JoinColumn(name = "id_classe_equivalencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClasseEquivalencia idClasseEquivalencia;

    public Valor() {
    }

    public Valor(Long id) {
        this.id = id;
    }

    public Valor(Long id, String valor, String positivoNegativo) {
        this.id = id;
        this.valor = valor;
        this.positivoNegativo = positivoNegativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPositivoNegativo() {
        return positivoNegativo;
    }

    public void setPositivoNegativo(String positivoNegativo) {
        this.positivoNegativo = positivoNegativo;
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

    public ClasseEquivalencia getIdClasseEquivalencia() {
        return idClasseEquivalencia;
    }

    public void setIdClasseEquivalencia(ClasseEquivalencia idClasseEquivalencia) {
        this.idClasseEquivalencia = idClasseEquivalencia;
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
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Valor[id=" + id + "]";
    }

}
