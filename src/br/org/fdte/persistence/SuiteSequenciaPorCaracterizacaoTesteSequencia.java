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
@Table(name = "suite_sequencia_por_caracterizacao_teste_sequencia")
@NamedQueries({@NamedQuery(name = "SuiteSequenciaPorCaracterizacaoTesteSequencia.findAll", query = "SELECT s FROM SuiteSequenciaPorCaracterizacaoTesteSequencia s"), @NamedQuery(name = "SuiteSequenciaPorCaracterizacaoTesteSequencia.findByIdSuiteSequencia", query = "SELECT s FROM SuiteSequenciaPorCaracterizacaoTesteSequencia s WHERE s.suiteSequenciaPorCaracterizacaoTesteSequenciaPK.idSuiteSequencia = :idSuiteSequencia"), @NamedQuery(name = "SuiteSequenciaPorCaracterizacaoTesteSequencia.findByIdCaracterizacaoTesteSequencia", query = "SELECT s FROM SuiteSequenciaPorCaracterizacaoTesteSequencia s WHERE s.suiteSequenciaPorCaracterizacaoTesteSequenciaPK.idCaracterizacaoTesteSequencia = :idCaracterizacaoTesteSequencia"), @NamedQuery(name = "SuiteSequenciaPorCaracterizacaoTesteSequencia.findByOrderId", query = "SELECT s FROM SuiteSequenciaPorCaracterizacaoTesteSequencia s WHERE s.orderId = :orderId")})
public class SuiteSequenciaPorCaracterizacaoTesteSequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuiteSequenciaPorCaracterizacaoTesteSequenciaPK suiteSequenciaPorCaracterizacaoTesteSequenciaPK;
    @Basic(optional = false)
    @Column(name = "order_id")
    private long orderId;
    @JoinColumn(name = "id_caracterizacao_teste_sequencia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteSequencia caracterizacaoTesteSequencia;
    @JoinColumn(name = "id_caracterizacao_teste_sequencia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteSequencia caracterizacaoTesteSequencia1;
    @JoinColumn(name = "id_suite_sequencia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SuiteTesteSequencia suiteTesteSequencia;
    @JoinColumn(name = "id_suite_sequencia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SuiteTesteSequencia suiteTesteSequencia1;

    public SuiteSequenciaPorCaracterizacaoTesteSequencia() {
    }

    public SuiteSequenciaPorCaracterizacaoTesteSequencia(SuiteSequenciaPorCaracterizacaoTesteSequenciaPK suiteSequenciaPorCaracterizacaoTesteSequenciaPK) {
        this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK = suiteSequenciaPorCaracterizacaoTesteSequenciaPK;
    }

    public SuiteSequenciaPorCaracterizacaoTesteSequencia(SuiteSequenciaPorCaracterizacaoTesteSequenciaPK suiteSequenciaPorCaracterizacaoTesteSequenciaPK, long orderId) {
        this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK = suiteSequenciaPorCaracterizacaoTesteSequenciaPK;
        this.orderId = orderId;
    }

    public SuiteSequenciaPorCaracterizacaoTesteSequencia(long idSuiteSequencia, long idCaracterizacaoTesteSequencia) {
        this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK = new SuiteSequenciaPorCaracterizacaoTesteSequenciaPK(idSuiteSequencia, idCaracterizacaoTesteSequencia);
    }

    public SuiteSequenciaPorCaracterizacaoTesteSequenciaPK getSuiteSequenciaPorCaracterizacaoTesteSequenciaPK() {
        return suiteSequenciaPorCaracterizacaoTesteSequenciaPK;
    }

    public void setSuiteSequenciaPorCaracterizacaoTesteSequenciaPK(SuiteSequenciaPorCaracterizacaoTesteSequenciaPK suiteSequenciaPorCaracterizacaoTesteSequenciaPK) {
        this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK = suiteSequenciaPorCaracterizacaoTesteSequenciaPK;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public CaracterizacaoTesteSequencia getCaracterizacaoTesteSequencia() {
        return caracterizacaoTesteSequencia;
    }

    public void setCaracterizacaoTesteSequencia(CaracterizacaoTesteSequencia caracterizacaoTesteSequencia) {
        this.caracterizacaoTesteSequencia = caracterizacaoTesteSequencia;
    }

    public CaracterizacaoTesteSequencia getCaracterizacaoTesteSequencia1() {
        return caracterizacaoTesteSequencia1;
    }

    public void setCaracterizacaoTesteSequencia1(CaracterizacaoTesteSequencia caracterizacaoTesteSequencia1) {
        this.caracterizacaoTesteSequencia1 = caracterizacaoTesteSequencia1;
    }

    public SuiteTesteSequencia getSuiteTesteSequencia() {
        return suiteTesteSequencia;
    }

    public void setSuiteTesteSequencia(SuiteTesteSequencia suiteTesteSequencia) {
        this.suiteTesteSequencia = suiteTesteSequencia;
    }

    public SuiteTesteSequencia getSuiteTesteSequencia1() {
        return suiteTesteSequencia1;
    }

    public void setSuiteTesteSequencia1(SuiteTesteSequencia suiteTesteSequencia1) {
        this.suiteTesteSequencia1 = suiteTesteSequencia1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suiteSequenciaPorCaracterizacaoTesteSequenciaPK != null ? suiteSequenciaPorCaracterizacaoTesteSequenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuiteSequenciaPorCaracterizacaoTesteSequencia)) {
            return false;
        }
        SuiteSequenciaPorCaracterizacaoTesteSequencia other = (SuiteSequenciaPorCaracterizacaoTesteSequencia) object;
        if ((this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK == null && other.suiteSequenciaPorCaracterizacaoTesteSequenciaPK != null) || (this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK != null && !this.suiteSequenciaPorCaracterizacaoTesteSequenciaPK.equals(other.suiteSequenciaPorCaracterizacaoTesteSequenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.SuiteSequenciaPorCaracterizacaoTesteSequencia[suiteSequenciaPorCaracterizacaoTesteSequenciaPK=" + suiteSequenciaPorCaracterizacaoTesteSequenciaPK + "]";
    }

}
