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

@Entity
@Table(name = "execucao_teste_validacao", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "ExecucaoTesteValidacao.findAll", 
                           query = "SELECT e FROM ExecucaoTesteValidacao e"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findBySuite",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.idSuite = :idSuite"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findById",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.id = :id"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByModoAtivacao",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.modoAtivacao = :modoAtivacao"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByInicio",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.inicio = :inicio"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByTermino",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.termino = :termino"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByCasosSucesso",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.casosSucesso = :casosSucesso"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByCasosFalha",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.casosFalha = :casosFalha"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByCasosTimeout",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.casosTimeout = :casosTimeout"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findByComentario",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.comentario = :comentario"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findGoldenExecution",
                           query = "SELECT e FROM ExecucaoTesteValidacao e where e.modoAtivacao = :modoAtivacao and e.idCaracterizacaoTesteValidacao = :idCaractTstValidacao and e.idSuite = :idSuite"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findAllExecutions",
                           query = "SELECT e FROM ExecucaoTesteValidacao e where e.idCaracterizacaoTesteValidacao = :idCaracTstValid"),
               @NamedQuery(name = "ExecucaoTesteValidacao.findMaxIdGrupoExecPerSuite",
                           query = "SELECT max(e.idGrupoExec) FROM ExecucaoTesteValidacao e WHERE e.idSuite.id = :idSuite group by e.idSuite.id "),
               @NamedQuery(name = "ExecucaoTesteValidacao.findBySuiteOrderByGroup",
                           query = "SELECT e FROM ExecucaoTesteValidacao e WHERE e.idSuite = :idSuite order by e.idGrupoExec")

})


public class ExecucaoTesteValidacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "execucao_teste_validacao_id_seq", sequenceName = "execucao_teste_validacao_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "execucao_teste_validacao_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "modo_ativacao", length = 2147483647)
    private String modoAtivacao;
    @Lob 
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "relatorio")
    private byte[] relatorio;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;
    @Column(name = "casos_sucesso")
    private Integer casosSucesso;
    @Column(name = "casos_falha")
    private Integer casosFalha;
    @Column(name = "casos_timeout")
    private Integer casosTimeout;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @Column(name = "id_grupo_exec")
    private Integer idGrupoExec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExecucaoTesteValidacao")
    private Collection<AtivacaoTesteValidacao> ativacaoTesteValidacaoCollection;
    @JoinColumn(name = "id_caracterizacao_teste_validacao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteValidacao idCaracterizacaoTesteValidacao;
    @JoinColumn(name = "id_suite", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SuiteTesteValidacao idSuite;


    public ExecucaoTesteValidacao() {
    }

    public ExecucaoTesteValidacao(Long id) {
        this.id = id;
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

    public byte[] getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(byte[] relatorio) {
        this.relatorio = relatorio;
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

    public Integer getCasosSucesso() {
        return casosSucesso;
    }

    public void setCasosSucesso(Integer casosSucesso) {
        this.casosSucesso = casosSucesso;
    }

    public Integer getCasosFalha() {
        return casosFalha;
    }

    public void setCasosFalha(Integer casosFalha) {
        this.casosFalha = casosFalha;
    }

    public Integer getCasosTimeout() {
        return casosTimeout;
    }

    public void setCasosTimeout(Integer casosTimeout) {
        this.casosTimeout = casosTimeout;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<AtivacaoTesteValidacao> getAtivacaoTesteValidacaoCollection() {
        return ativacaoTesteValidacaoCollection;
    }

    public void setAtivacaoTesteValidacaoCollection(Collection<AtivacaoTesteValidacao> ativacaoTesteValidacaoCollection) {
        this.ativacaoTesteValidacaoCollection = ativacaoTesteValidacaoCollection;
    }

    public CaracterizacaoTesteValidacao getIdCaracterizacaoTesteValidacao() {
        return idCaracterizacaoTesteValidacao;
    }

    public void setIdCaracterizacaoTesteValidacao(CaracterizacaoTesteValidacao idCaracterizacaoTesteValidacao) {
        this.idCaracterizacaoTesteValidacao = idCaracterizacaoTesteValidacao;
    }

    public SuiteTesteValidacao getIdSuite() {
        return idSuite;
    }

    public void setIdSuite(SuiteTesteValidacao idSuite) {
        this.idSuite = idSuite;
    }

    public  void setIdGrupoExec(Integer idGrupoExec) {
        this.idGrupoExec = idGrupoExec;
    }

    public Integer getIdGrupoExec() {
        return idGrupoExec;
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
        if (!(object instanceof ExecucaoTesteValidacao)) {
            return false;
        }
        ExecucaoTesteValidacao other = (ExecucaoTesteValidacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.ExecucaoTesteValidacao[id=" + id + "]";
    }
}


