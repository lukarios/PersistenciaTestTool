/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
@Table(name = "parametro_passo", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "ParametroPasso.findAll", query = "SELECT p FROM ParametroPasso p"), @NamedQuery(name = "ParametroPasso.findById", query = "SELECT p FROM ParametroPasso p WHERE p.id = :id"), @NamedQuery(name = "ParametroPasso.findByTipoParametro", query = "SELECT p FROM ParametroPasso p WHERE p.tipoParametro = :tipoParametro"), @NamedQuery(name = "ParametroPasso.findByParametroConstante", query = "SELECT p FROM ParametroPasso p WHERE p.parametroConstante = :parametroConstante"), @NamedQuery(name = "ParametroPasso.findByParametroClasse", query = "SELECT p FROM ParametroPasso p WHERE p.parametroClasse = :parametroClasse")})
public class ParametroPasso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "parametro_passo_id_seq", sequenceName = "parametro_passo_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "parametro_passo_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo_parametro", nullable = false, length = 1)
    private String tipoParametro;
    @Lob
    @Column(name = "parametro_blob")
    private byte[] parametroBlob;
    @Column(name = "parametro_constante", length = 255)
    private String parametroConstante;
    @Column(name = "parametro_classe", length = 255)
    private String parametroClasse;
    @JoinColumn(name = "id_passo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Passo idPasso;

    public ParametroPasso() {
    }

    public ParametroPasso(Long id) {
        this.id = id;
    }

    public ParametroPasso(Long id, String tipoParametro) {
        this.id = id;
        this.tipoParametro = tipoParametro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }

    public byte[] getParametroBlob() {
        return parametroBlob;
    }

    public void setParametroBlob(byte[] parametroBlob) {
        this.parametroBlob = parametroBlob;
    }

    public String getParametroConstante() {
        return parametroConstante;
    }

    public void setParametroConstante(String parametroConstante) {
        this.parametroConstante = parametroConstante;
    }

    public String getParametroClasse() {
        return parametroClasse;
    }

    public void setParametroClasse(String parametroClasse) {
        this.parametroClasse = parametroClasse;
    }

    public Passo getIdPasso() {
        return idPasso;
    }

    public void setIdPasso(Passo idPasso) {
        this.idPasso = idPasso;
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
        if (!(object instanceof ParametroPasso)) {
            return false;
        }
        ParametroPasso other = (ParametroPasso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.ParametroPasso[id=" + id + "]";
    }

}
