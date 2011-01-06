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
import javax.persistence.ManyToOne;
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
@Table(name = "caracterizacao_teste_validacao", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({@NamedQuery(name = "CaracterizacaoTesteValidacao.findAll", query = "SELECT c FROM CaracterizacaoTesteValidacao c"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findById", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.id = :id"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByNome", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.nome = :nome"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByClasseValidacaoSaidaPositiva", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.classeValidacaoSaidaPositiva = :classeValidacaoSaidaPositiva"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByXsdSaidaPositiva", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.xsdSaidaPositiva = :xsdSaidaPositiva"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByClasseValidacaoSaidaNegativa", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.classeValidacaoSaidaNegativa = :classeValidacaoSaidaNegativa"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByXsdSaidaNegativa", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.xsdSaidaNegativa = :xsdSaidaNegativa"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByCasosPositivos", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.casosPositivos = :casosPositivos"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByCasosNegativos", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.casosNegativos = :casosNegativos"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByCasosOpcionais", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.casosOpcionais = :casosOpcionais"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByCasosRepeticoes", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.casosRepeticoes = :casosRepeticoes"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByCasosRegras", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.casosRegras = :casosRegras"), @NamedQuery(name = "CaracterizacaoTesteValidacao.findByComentario", query = "SELECT c FROM CaracterizacaoTesteValidacao c WHERE c.comentario = :comentario")})

public class CaracterizacaoTesteValidacao implements Serializable, Comparable<CaracterizacaoTesteValidacao> {
    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "caracterizacao_teste_validacao_id_seq", sequenceName = "caracterizacao_teste_validacao_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "caracterizacao_teste_validacao_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 2147483647)
    private String nome;
    @Column(name = "classe_validacao_saida_positiva", length = 255)
    private String classeValidacaoSaidaPositiva;
    @Column(name = "xsd_saida_positiva", length = 255)
    private String xsdSaidaPositiva;
    @Column(name = "classe_validacao_saida_negativa", length = 255)
    private String classeValidacaoSaidaNegativa;
    @Column(name = "xsd_saida_negativa", length = 255)
    private String xsdSaidaNegativa;
    @Basic(optional = false)
    @Column(name = "casos_positivos", nullable = false)
    private int casosPositivos;
    @Basic(optional = false)
    @Column(name = "casos_negativos", nullable = false)
    private int casosNegativos;
    @Basic(optional = false)
    @Column(name = "casos_opcionais", nullable = false)
    private int casosOpcionais;
    @Basic(optional = false)
    @Column(name = "casos_repeticoes", nullable = false)
    private int casosRepeticoes;
    @Basic(optional = false)
    @Column(name = "casos_regras", nullable = false)
    private int casosRegras;
    @Column(name = "comentario", length = 255)
    private String comentario;
    /*lrb 20/05/2010 @JoinTable(name = "suite_validacao_por_caracterizacao_teste_validacao", joinColumns = {@JoinColumn(name = "id_caracterizacao_teste_validacao", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "id_suite_validacao", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<SuiteTesteValidacao> suiteTesteValidacaoCollection;*/
    @JoinTable(name = "suite_validacao_teste_validacao", joinColumns = {@JoinColumn(name = "id_caracterizacao_teste_validacao", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "id_suite_validacao", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<SuiteTesteValidacao> suiteTesteValidacaoCollection;
    @JoinColumn(name = "documento_entrada", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TemplateDocumento documentoEntrada;
    @JoinColumn(name = "documento_saida_positiva", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TemplateDocumento documentoSaidaPositiva;
    @JoinColumn(name = "documento_saida_negativa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TemplateDocumento documentoSaidaNegativa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracterizacaoTesteValidacao")
    private Collection<ExecucaoTesteValidacao> execucaoTesteValidacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracterizacaoTesteValidacao")
    private Collection<Especificos> especificosCollection;

    public CaracterizacaoTesteValidacao() {
    }

    public CaracterizacaoTesteValidacao(Long id) {
        this.id = id;
    }

    public CaracterizacaoTesteValidacao(Long id, String nome, int casosPositivos, int casosNegativos, int casosOpcionais, int casosRepeticoes, int casosRegras) {
        this.id = id;
        this.nome = nome;
        this.casosPositivos = casosPositivos;
        this.casosNegativos = casosNegativos;
        this.casosOpcionais = casosOpcionais;
        this.casosRepeticoes = casosRepeticoes;
        this.casosRegras = casosRegras;
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

    public String getClasseValidacaoSaidaPositiva() {
        return classeValidacaoSaidaPositiva;
    }

    public void setClasseValidacaoSaidaPositiva(String classeValidacaoSaidaPositiva) {
        this.classeValidacaoSaidaPositiva = classeValidacaoSaidaPositiva;
    }

    public String getXsdSaidaPositiva() {
        return xsdSaidaPositiva;
    }

    public void setXsdSaidaPositiva(String xsdSaidaPositiva) {
        this.xsdSaidaPositiva = xsdSaidaPositiva;
    }

    public String getClasseValidacaoSaidaNegativa() {
        return classeValidacaoSaidaNegativa;
    }

    public void setClasseValidacaoSaidaNegativa(String classeValidacaoSaidaNegativa) {
        this.classeValidacaoSaidaNegativa = classeValidacaoSaidaNegativa;
    }

    public String getXsdSaidaNegativa() {
        return xsdSaidaNegativa;
    }

    public void setXsdSaidaNegativa(String xsdSaidaNegativa) {
        this.xsdSaidaNegativa = xsdSaidaNegativa;
    }

    public int getCasosPositivos() {
        return casosPositivos;
    }

    public void setCasosPositivos(int casosPositivos) {
        this.casosPositivos = casosPositivos;
    }

    public int getCasosNegativos() {
        return casosNegativos;
    }

    public void setCasosNegativos(int casosNegativos) {
        this.casosNegativos = casosNegativos;
    }

    public int getCasosOpcionais() {
        return casosOpcionais;
    }

    public void setCasosOpcionais(int casosOpcionais) {
        this.casosOpcionais = casosOpcionais;
    }

    public int getCasosRepeticoes() {
        return casosRepeticoes;
    }

    public void setCasosRepeticoes(int casosRepeticoes) {
        this.casosRepeticoes = casosRepeticoes;
    }

    public int getCasosRegras() {
        return casosRegras;
    }

    public void setCasosRegras(int casosRegras) {
        this.casosRegras = casosRegras;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<SuiteTesteValidacao> getSuiteTesteValidacaoCollection() {
        return suiteTesteValidacaoCollection;
    }

    public void setSuiteTesteValidacaoCollection(Collection<SuiteTesteValidacao> suiteTesteValidacaoCollection) {
        this.suiteTesteValidacaoCollection = suiteTesteValidacaoCollection;
    }

    public TemplateDocumento getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(TemplateDocumento documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }

    public TemplateDocumento getDocumentoSaidaPositiva() {
        return documentoSaidaPositiva;
    }

    public void setDocumentoSaidaPositiva(TemplateDocumento documentoSaidaPositiva) {
        this.documentoSaidaPositiva = documentoSaidaPositiva;
    }

    public TemplateDocumento getDocumentoSaidaNegativa() {
        return documentoSaidaNegativa;
    }

    public void setDocumentoSaidaNegativa(TemplateDocumento documentoSaidaNegativa) {
        this.documentoSaidaNegativa = documentoSaidaNegativa;
    }

    public Collection<ExecucaoTesteValidacao> getExecucaoTesteValidacaoCollection() {
        return execucaoTesteValidacaoCollection;
    }

    public void setExecucaoTesteValidacaoCollection(Collection<ExecucaoTesteValidacao> execucaoTesteValidacaoCollection) {
        this.execucaoTesteValidacaoCollection = execucaoTesteValidacaoCollection;
    }

    public Collection<Especificos> getEspecificosCollection() {
        return especificosCollection;
    }

    public void setEspecificosCollection(Collection<Especificos> especificosCollection) {
        this.especificosCollection = especificosCollection;
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
        if (!(object instanceof CaracterizacaoTesteValidacao)) {
            return false;
        }
        CaracterizacaoTesteValidacao other = (CaracterizacaoTesteValidacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.CaracterizacaoTesteValidacao[id=" + id + "]";
    }

    /* LRB */
    public int compareTo(CaracterizacaoTesteValidacao tst) {
        return nome.compareTo(tst.getNome());
    }
}
