package br.org.fdte.persistence;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* MB */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author MB
 */
@Entity
@Table(name = "ativacao_teste_validacao", catalog = "test_tool", schema = "public")
@NamedQueries({
    @NamedQuery(name = "AtivacaoTesteValidacao.findAll", query = "SELECT a FROM AtivacaoTesteValidacao a"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findById", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.id = :id"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findBySequencial", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.sequencial = :sequencial"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findByTipo", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findByInicio", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findByTermino", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.termino = :termino"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findByResultado", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.resultado = :resultado"),
    @NamedQuery(name = "AtivacaoTesteValidacao.findByIdExec", query = "SELECT a FROM AtivacaoTesteValidacao a WHERE a.idExecucaoTesteValidacao = :idExecucaoTesteValidacao and a.resultado = :resultado"),
    @NamedQuery(name = "AtivacaoTesteValidacao.deleteByExecution", query = "DELETE FROM AtivacaoTesteValidacao e where e.idExecucaoTesteValidacao = :execution")})


public class AtivacaoTesteValidacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "ativacao_teste_validacao_id_seq", sequenceName = "ativacao_teste_validacao_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "ativacao_teste_validacao_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "sequencial", nullable = false)
    private int sequencial;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 2147483647)
    private String tipo;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;
    @Lob
    @Column(name = "documento_entrada")
    private byte[] documentoEntrada;
    @Lob
    @Column(name = "documento_saida")
    private byte[] documentoSaida;
    @Lob
    @Column(name = "screenshot")
    private byte[] screenShot;
    @Column(name = "resultado", length = 2147483647)
    private String resultado;
    @Column(name = "golden_compare", length = 2147483647)
    private String goldenCompare;
    @JoinColumn(name = "id_execucao_teste_validacao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ExecucaoTesteValidacao idExecucaoTesteValidacao;

    public AtivacaoTesteValidacao() {
    }

    public AtivacaoTesteValidacao(Long id) {
        this.id = id;
    }

    public AtivacaoTesteValidacao(Long id, int sequencial, String tipo) {
        this.id = id;
        this.sequencial = sequencial;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public byte[] getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(byte[] documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }

    public byte[] getDocumentoSaida() {
        return documentoSaida;
    }

    public void setDocumentoSaida(byte[] documentoSaida) {
        this.documentoSaida = documentoSaida;
    }

    public byte[] getScreenshot() {
        return screenShot;
    }

    public void setScreenshot(byte[] screenShot) {
        this.screenShot = screenShot;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ExecucaoTesteValidacao getIdExecucaoTesteValidacao() {
        return idExecucaoTesteValidacao;
    }

    public void setIdExecucaoTesteValidacao(ExecucaoTesteValidacao idExecucaoTesteValidacao) {
        this.idExecucaoTesteValidacao = idExecucaoTesteValidacao;
    }

    public String getGoldenCompare() {
        return goldenCompare;
    }

    public void setGoldenCompare(String goldenCompare) {
        this.goldenCompare = goldenCompare;
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
        if (!(object instanceof AtivacaoTesteValidacao)) {
            return false;
        }
        AtivacaoTesteValidacao other = (AtivacaoTesteValidacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.AtivacaoTesteValidacao[id=" + id + "]";
    }

}
