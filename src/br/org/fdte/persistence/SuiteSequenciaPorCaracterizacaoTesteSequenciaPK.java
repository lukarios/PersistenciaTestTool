/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Luciana
 */
@Embeddable
public class SuiteSequenciaPorCaracterizacaoTesteSequenciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_suite_sequencia")
    private long idSuiteSequencia;
    @Basic(optional = false)
    @Column(name = "id_caracterizacao_teste_sequencia")
    private long idCaracterizacaoTesteSequencia;

    public SuiteSequenciaPorCaracterizacaoTesteSequenciaPK() {
    }

    public SuiteSequenciaPorCaracterizacaoTesteSequenciaPK(long idSuiteSequencia, long idCaracterizacaoTesteSequencia) {
        this.idSuiteSequencia = idSuiteSequencia;
        this.idCaracterizacaoTesteSequencia = idCaracterizacaoTesteSequencia;
    }

    public long getIdSuiteSequencia() {
        return idSuiteSequencia;
    }

    public void setIdSuiteSequencia(long idSuiteSequencia) {
        this.idSuiteSequencia = idSuiteSequencia;
    }

    public long getIdCaracterizacaoTesteSequencia() {
        return idCaracterizacaoTesteSequencia;
    }

    public void setIdCaracterizacaoTesteSequencia(long idCaracterizacaoTesteSequencia) {
        this.idCaracterizacaoTesteSequencia = idCaracterizacaoTesteSequencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSuiteSequencia;
        hash += (int) idCaracterizacaoTesteSequencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuiteSequenciaPorCaracterizacaoTesteSequenciaPK)) {
            return false;
        }
        SuiteSequenciaPorCaracterizacaoTesteSequenciaPK other = (SuiteSequenciaPorCaracterizacaoTesteSequenciaPK) object;
        if (this.idSuiteSequencia != other.idSuiteSequencia) {
            return false;
        }
        if (this.idCaracterizacaoTesteSequencia != other.idCaracterizacaoTesteSequencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.SuiteSequenciaPorCaracterizacaoTesteSequenciaPK[idSuiteSequencia=" + idSuiteSequencia + ", idCaracterizacaoTesteSequencia=" + idCaracterizacaoTesteSequencia + "]";
    }

}
