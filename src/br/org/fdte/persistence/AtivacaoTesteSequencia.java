/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "ativacao_teste_sequencia", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "AtivacaoTesteSequencia.findAll", query = "SELECT a FROM AtivacaoTesteSequencia a"), @NamedQuery(name = "AtivacaoTesteSequencia.findById", query = "SELECT a FROM AtivacaoTesteSequencia a WHERE a.id = :id"), @NamedQuery(name = "AtivacaoTesteSequencia.findByInicio", query = "SELECT a FROM AtivacaoTesteSequencia a WHERE a.inicio = :inicio"), @NamedQuery(name = "AtivacaoTesteSequencia.findByTermino", query = "SELECT a FROM AtivacaoTesteSequencia a WHERE a.termino = :termino"), @NamedQuery(name = "AtivacaoTesteSequencia.findByStatus", query = "SELECT a FROM AtivacaoTesteSequencia a WHERE a.status = :status")})
public class AtivacaoTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "ativacao_teste_sequencia_id_seq", sequenceName = "ativacao_teste_sequencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "ativacao_teste_sequencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;
    @Column(name = "status", length = 2147483647)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtivacaoTesteSequencia")
    private Collection<AtivacaoPasso> ativacaoPassoCollection;
    @JoinColumn(name = "id_caracterizacao_teste_sequencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteSequencia idCaracterizacaoTesteSequencia;
    @JoinColumn(name = "id_execucao_teste_sequencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ExecucaoTesteSequencia idExecucaoTesteSequencia;

    public AtivacaoTesteSequencia() {
    }

    public AtivacaoTesteSequencia(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<AtivacaoPasso> getAtivacaoPassoCollection() {
        return ativacaoPassoCollection;
    }

    public void setAtivacaoPassoCollection(Collection<AtivacaoPasso> ativacaoPassoCollection) {
        this.ativacaoPassoCollection = ativacaoPassoCollection;
    }

    public CaracterizacaoTesteSequencia getIdCaracterizacaoTesteSequencia() {
        return idCaracterizacaoTesteSequencia;
    }

    public void setIdCaracterizacaoTesteSequencia(CaracterizacaoTesteSequencia idCaracterizacaoTesteSequencia) {
        this.idCaracterizacaoTesteSequencia = idCaracterizacaoTesteSequencia;
    }

    public ExecucaoTesteSequencia getIdExecucaoTesteSequencia() {
        return idExecucaoTesteSequencia;
    }

    public void setIdExecucaoTesteSequencia(ExecucaoTesteSequencia idExecucaoTesteSequencia) {
        this.idExecucaoTesteSequencia = idExecucaoTesteSequencia;
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
        if (!(object instanceof AtivacaoTesteSequencia)) {
            return false;
        }
        AtivacaoTesteSequencia other = (AtivacaoTesteSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.AtivacaoTesteSequencia[id=" + id + "]";
    }

}
