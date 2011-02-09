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
@Table(name = "tipo_classe_equivalencia", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"tipo_classe_equivalencia"}), @UniqueConstraint(columnNames = {"id", "tipo_classe_equivalencia"})})
@NamedQueries({@NamedQuery(name = "TipoClasseEquivalencia.findAll", query = "SELECT t FROM TipoClasseEquivalencia t"), @NamedQuery(name = "TipoClasseEquivalencia.findById", query = "SELECT t FROM TipoClasseEquivalencia t WHERE t.id = :id"), @NamedQuery(name = "TipoClasseEquivalencia.findByTipoClasseEquivalencia", query = "SELECT t FROM TipoClasseEquivalencia t WHERE t.tipoClasseEquivalencia = :tipoClasseEquivalencia")})
public class TipoClasseEquivalencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id


/*MB */
    @SequenceGenerator( name = "tipo_classe_equivalencia_id_seq", sequenceName = "tipo_classe_equivalencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "tipo_classe_equivalencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "tipo_classe_equivalencia", nullable = false, length = 10)
    private String tipoClasseEquivalencia;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<ClasseEquivalencia> classeEquivalenciaCollection;*/

    public TipoClasseEquivalencia() {
    }

    public TipoClasseEquivalencia(Long id) {
        this.id = id;
    }

    public TipoClasseEquivalencia(Long id, String tipoClasseEquivalencia) {
        this.id = id;
        this.tipoClasseEquivalencia = tipoClasseEquivalencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoClasseEquivalencia() {
        return tipoClasseEquivalencia;
    }

    public void setTipoClasseEquivalencia(String tipoClasseEquivalencia) {
        this.tipoClasseEquivalencia = tipoClasseEquivalencia;
    }
/*
    public Collection<ClasseEquivalencia> getClasseEquivalenciaCollection() {
        return classeEquivalenciaCollection;
    }

    public void setClasseEquivalenciaCollection(Collection<ClasseEquivalencia> classeEquivalenciaCollection) {
        this.classeEquivalenciaCollection = classeEquivalenciaCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClasseEquivalencia)) {
            return false;
        }
        TipoClasseEquivalencia other = (TipoClasseEquivalencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.TipoClasseEquivalencia[id=" + id + "]";
    }

}
