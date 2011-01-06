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
@Table(name = "relacao_entao", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "RelacaoEntao.findAll", query = "SELECT r FROM RelacaoEntao r"), @NamedQuery(name = "RelacaoEntao.findById", query = "SELECT r FROM RelacaoEntao r WHERE r.id = :id"), @NamedQuery(name = "RelacaoEntao.findByNome", query = "SELECT r FROM RelacaoEntao r WHERE r.nome = :nome")})
public class RelacaoEntao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "relacao_entao_id_seq", sequenceName = "relacao_entao_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "relacao_entao_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entaoRelacao")
    private Collection<Regra> regraCollection;

    public RelacaoEntao() {
    }

    public RelacaoEntao(Long id) {
        this.id = id;
    }

    public RelacaoEntao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Collection<Regra> getRegraCollection() {
        return regraCollection;
    }

    public void setRegraCollection(Collection<Regra> regraCollection) {
        this.regraCollection = regraCollection;
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
        if (!(object instanceof RelacaoEntao)) {
            return false;
        }
        RelacaoEntao other = (RelacaoEntao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.RelacaoEntao[id=" + id + "]";
    }

}
