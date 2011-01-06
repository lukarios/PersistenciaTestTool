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
import javax.persistence.Lob;
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
@Table(name = "execucao_teste_sequencia", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "ExecucaoTesteSequencia.findAll", query = "SELECT e FROM ExecucaoTesteSequencia e"), @NamedQuery(name = "ExecucaoTesteSequencia.findById", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.id = :id"), @NamedQuery(name = "ExecucaoTesteSequencia.findByModoAtivacao", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.modoAtivacao = :modoAtivacao"), @NamedQuery(name = "ExecucaoTesteSequencia.findByInicio", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.inicio = :inicio"), @NamedQuery(name = "ExecucaoTesteSequencia.findByTermino", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.termino = :termino"), @NamedQuery(name = "ExecucaoTesteSequencia.findByStatus", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.status = :status"), @NamedQuery(name = "ExecucaoTesteSequencia.findByComentario", query = "SELECT e FROM ExecucaoTesteSequencia e WHERE e.comentario = :comentario")})
public class ExecucaoTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "execucao_teste_sequencia_id_seq", sequenceName = "execucao_teste_sequencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "execucao_teste_sequencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "modo_ativacao", nullable = false, length = 2147483647)
    private String modoAtivacao;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;
    @Column(name = "status", length = 2147483647)
    private String status;
    @Lob
    @Column(name = "relatorio")
    private byte[] relatorio;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExecucaoTesteSequencia")
    private Collection<AtivacaoTesteSequencia> ativacaoTesteSequenciaCollection;
    @JoinColumn(name = "id_suite", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SuiteTesteSequencia idSuite;

    public ExecucaoTesteSequencia() {
    }

    public ExecucaoTesteSequencia(Long id) {
        this.id = id;
    }

    public ExecucaoTesteSequencia(Long id, String modoAtivacao) {
        this.id = id;
        this.modoAtivacao = modoAtivacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModoAtivacao() {
        return modoAtivacao;
    }

    public void setModoAtivacao(String modoAtivacao) {
        this.modoAtivacao = modoAtivacao;
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

    public byte[] getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(byte[] relatorio) {
        this.relatorio = relatorio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<AtivacaoTesteSequencia> getAtivacaoTesteSequenciaCollection() {
        return ativacaoTesteSequenciaCollection;
    }

    public void setAtivacaoTesteSequenciaCollection(Collection<AtivacaoTesteSequencia> ativacaoTesteSequenciaCollection) {
        this.ativacaoTesteSequenciaCollection = ativacaoTesteSequenciaCollection;
    }

    public SuiteTesteSequencia getIdSuite() {
        return idSuite;
    }

    public void setIdSuite(SuiteTesteSequencia idSuite) {
        this.idSuite = idSuite;
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
        if (!(object instanceof ExecucaoTesteSequencia)) {
            return false;
        }
        ExecucaoTesteSequencia other = (ExecucaoTesteSequencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.ExecucaoTesteSequencia[id=" + id + "]";
    }

}
