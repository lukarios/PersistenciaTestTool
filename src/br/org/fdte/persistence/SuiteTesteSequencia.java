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
@Table(name = "suite_teste_sequencia", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({@NamedQuery(name = "SuiteTesteSequencia.findAll", query = "SELECT s FROM SuiteTesteSequencia s"), @NamedQuery(name = "SuiteTesteSequencia.findById", query = "SELECT s FROM SuiteTesteSequencia s WHERE s.id = :id"), @NamedQuery(name = "SuiteTesteSequencia.findByNome", query = "SELECT s FROM SuiteTesteSequencia s WHERE s.nome = :nome")})
public class SuiteTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "suite_teste_sequencia_id_seq", sequenceName = "suite_teste_sequencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "suite_teste_sequencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @ManyToMany(mappedBy = "suiteTesteSequenciaCollection")
    private Collection<CaracterizacaoTesteSequencia> caracterizacaoTesteSequenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSuite")
    private Collection<ExecucaoTesteSequencia> execucaoTesteSequenciaCollection;

    public SuiteTesteSequencia() {
    }

    public SuiteTesteSequencia(Long id) {
        this.id = id;
    }

    public SuiteTesteSequencia(Long id, String nome) {
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

    public Collection<CaracterizacaoTesteSequencia> getCaracterizacaoTesteSequenciaCollection() {
        return caracterizacaoTesteSequenciaCollection;
    }

    public void setCaracterizacaoTesteSequenciaCollection(Collection<CaracterizacaoTesteSequencia> caracterizacaoTesteSequenciaCollection) {
        this.caracterizacaoTesteSequenciaCollection = caracterizacaoTesteSequenciaCollection;
    }

    public Collection<ExecucaoTesteSequencia> getExecucaoTesteSequenciaCollection() {
        return execucaoTesteSequenciaCollection;
    }

    public void setExecucaoTesteSequenciaCollection(Collection<ExecucaoTesteSequencia> execucaoTesteSequenciaCollection) {
        this.execucaoTesteSequenciaCollection = execucaoTesteSequenciaCollection;
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
        if (!(object instanceof SuiteTesteSequencia)) {
            return false;
        }
        SuiteTesteSequencia other = (SuiteTesteSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.SuiteTesteSequencia[id=" + id + "]";
    }

}
