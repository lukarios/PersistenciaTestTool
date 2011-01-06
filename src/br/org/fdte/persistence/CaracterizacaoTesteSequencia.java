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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "caracterizacao_teste_sequencia", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({@NamedQuery(name = "CaracterizacaoTesteSequencia.findAll", query = "SELECT c FROM CaracterizacaoTesteSequencia c"), @NamedQuery(name = "CaracterizacaoTesteSequencia.findById", query = "SELECT c FROM CaracterizacaoTesteSequencia c WHERE c.id = :id"), @NamedQuery(name = "CaracterizacaoTesteSequencia.findByNome", query = "SELECT c FROM CaracterizacaoTesteSequencia c WHERE c.nome = :nome"), @NamedQuery(name = "CaracterizacaoTesteSequencia.findByComentario", query = "SELECT c FROM CaracterizacaoTesteSequencia c WHERE c.comentario = :comentario")})
public class CaracterizacaoTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "caracterizacao_teste_sequencia_id_seq", sequenceName = "caracterizacao_teste_sequencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "caracterizacao_teste_sequencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @JoinTable(name = "suite_sequencia_por_caracterizacao_teste_sequencia", joinColumns = {@JoinColumn(name = "id_caracterizacao_teste_sequencia", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "id_suite_sequencia", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<SuiteTesteSequencia> suiteTesteSequenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracterizacaoTesteSequencia")
    private Collection<Passo> passoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracterizacaoTesteSequencia")
    private Collection<AtivacaoTesteSequencia> ativacaoTesteSequenciaCollection;

    public CaracterizacaoTesteSequencia() {
    }

    public CaracterizacaoTesteSequencia(Long id) {
        this.id = id;
    }

    public CaracterizacaoTesteSequencia(Long id, String nome) {
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<SuiteTesteSequencia> getSuiteTesteSequenciaCollection() {
        return suiteTesteSequenciaCollection;
    }

    public void setSuiteTesteSequenciaCollection(Collection<SuiteTesteSequencia> suiteTesteSequenciaCollection) {
        this.suiteTesteSequenciaCollection = suiteTesteSequenciaCollection;
    }

    public Collection<Passo> getPassoCollection() {
        return passoCollection;
    }

    public void setPassoCollection(Collection<Passo> passoCollection) {
        this.passoCollection = passoCollection;
    }

    public Collection<AtivacaoTesteSequencia> getAtivacaoTesteSequenciaCollection() {
        return ativacaoTesteSequenciaCollection;
    }

    public void setAtivacaoTesteSequenciaCollection(Collection<AtivacaoTesteSequencia> ativacaoTesteSequenciaCollection) {
        this.ativacaoTesteSequenciaCollection = ativacaoTesteSequenciaCollection;
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
        if (!(object instanceof CaracterizacaoTesteSequencia)) {
            return false;
        }
        CaracterizacaoTesteSequencia other = (CaracterizacaoTesteSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.CaracterizacaoTesteSequencia[id=" + id + "]";
    }

}
