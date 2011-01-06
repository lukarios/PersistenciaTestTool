/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Luciana
 */
@Entity
@Table(name = "suite_validacao_teste_validacao")
@NamedQueries({@NamedQuery(name = "SuiteValidacaoTesteValidacao.findAll", query = "SELECT s FROM SuiteValidacaoTesteValidacao s"), @NamedQuery(name = "SuiteValidacaoTesteValidacao.findByOrderId", query = "SELECT s FROM SuiteValidacaoTesteValidacao s WHERE s.orderId = :orderId"), @NamedQuery(name = "SuiteValidacaoTesteValidacao.findByIdSuiteValidacao", query = "SELECT s FROM SuiteValidacaoTesteValidacao s WHERE s.suiteValidacaoTesteValidacaoPK.idSuiteValidacao = :idSuiteValidacao"), @NamedQuery(name = "SuiteValidacaoTesteValidacao.findByIdCaracterizacaoTesteValidacao", query = "SELECT s FROM SuiteValidacaoTesteValidacao s WHERE s.suiteValidacaoTesteValidacaoPK.idCaracterizacaoTesteValidacao = :idCaracterizacaoTesteValidacao")})
public class SuiteValidacaoTesteValidacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuiteValidacaoTesteValidacaoPK suiteValidacaoTesteValidacaoPK;
    @Basic(optional = false)
    @Column(name = "order_id")
    private long orderId;
    @JoinColumn(name = "id_caracterizacao_teste_validacao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteValidacao caracterizacaoTesteValidacao;
    @JoinColumn(name = "id_suite_validacao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SuiteTesteValidacao suiteTesteValidacao;

    public SuiteValidacaoTesteValidacao() {
    }

    public SuiteValidacaoTesteValidacao(SuiteValidacaoTesteValidacaoPK suiteValidacaoTesteValidacaoPK) {
        this.suiteValidacaoTesteValidacaoPK = suiteValidacaoTesteValidacaoPK;
    }

    public SuiteValidacaoTesteValidacao(SuiteValidacaoTesteValidacaoPK suiteValidacaoTesteValidacaoPK, long orderId) {
        this.suiteValidacaoTesteValidacaoPK = suiteValidacaoTesteValidacaoPK;
        this.orderId = orderId;
    }

    public SuiteValidacaoTesteValidacao(long idSuiteValidacao, long idCaracterizacaoTesteValidacao) {
        this.suiteValidacaoTesteValidacaoPK = new SuiteValidacaoTesteValidacaoPK(idSuiteValidacao, idCaracterizacaoTesteValidacao);
    }

    public SuiteValidacaoTesteValidacaoPK getSuiteValidacaoTesteValidacaoPK() {
        return suiteValidacaoTesteValidacaoPK;
    }

    public void setSuiteValidacaoTesteValidacaoPK(SuiteValidacaoTesteValidacaoPK suiteValidacaoTesteValidacaoPK) {
        this.suiteValidacaoTesteValidacaoPK = suiteValidacaoTesteValidacaoPK;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public CaracterizacaoTesteValidacao getCaracterizacaoTesteValidacao() {
        return caracterizacaoTesteValidacao;
    }

    public void setCaracterizacaoTesteValidacao(CaracterizacaoTesteValidacao caracterizacaoTesteValidacao) {
        this.caracterizacaoTesteValidacao = caracterizacaoTesteValidacao;
    }

    public SuiteTesteValidacao getSuiteTesteValidacao() {
        return suiteTesteValidacao;
    }

    public void setSuiteTesteValidacao(SuiteTesteValidacao suiteTesteValidacao) {
        this.suiteTesteValidacao = suiteTesteValidacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suiteValidacaoTesteValidacaoPK != null ? suiteValidacaoTesteValidacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuiteValidacaoTesteValidacao)) {
            return false;
        }
        SuiteValidacaoTesteValidacao other = (SuiteValidacaoTesteValidacao) object;
        if ((this.suiteValidacaoTesteValidacaoPK == null && other.suiteValidacaoTesteValidacaoPK != null) || (this.suiteValidacaoTesteValidacaoPK != null && !this.suiteValidacaoTesteValidacaoPK.equals(other.suiteValidacaoTesteValidacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.SuiteValidacaoTesteValidacao[suiteValidacaoTesteValidacaoPK=" + suiteValidacaoTesteValidacaoPK + "]";
    }

}
