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
public class SuiteValidacaoTesteValidacaoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_suite_validacao")
    private long idSuiteValidacao;
    @Basic(optional = false)
    @Column(name = "id_caracterizacao_teste_validacao")
    private long idCaracterizacaoTesteValidacao;

    /*@author Luciana*/
    public SuiteValidacaoTesteValidacaoPK(){

    }

    public SuiteValidacaoTesteValidacaoPK(long idSuiteValidacao, long idCaracterizacaoTesteValidacao) {
        this.idSuiteValidacao = idSuiteValidacao;
        this.idCaracterizacaoTesteValidacao = idCaracterizacaoTesteValidacao;
    }

    public long getIdSuiteValidacao() {
        return idSuiteValidacao;
    }

    public void setIdSuiteValidacao(long idSuiteValidacao) {
        this.idSuiteValidacao = idSuiteValidacao;
    }

    public long getIdCaracterizacaoTesteValidacao() {
        return idCaracterizacaoTesteValidacao;
    }

    public void setIdCaracterizacaoTesteValidacao(long idCaracterizacaoTesteValidacao) {
        this.idCaracterizacaoTesteValidacao = idCaracterizacaoTesteValidacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSuiteValidacao;
        hash += (int) idCaracterizacaoTesteValidacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuiteValidacaoTesteValidacaoPK)) {
            return false;
        }
        SuiteValidacaoTesteValidacaoPK other = (SuiteValidacaoTesteValidacaoPK) object;
        if (this.idSuiteValidacao != other.idSuiteValidacao) {
            return false;
        }
        if (this.idCaracterizacaoTesteValidacao != other.idCaracterizacaoTesteValidacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.SuiteValidacaoTesteValidacaoPK[idSuiteValidacao=" + idSuiteValidacao + ", idCaracterizacaoTesteValidacao=" + idCaracterizacaoTesteValidacao + "]";
    }

}
