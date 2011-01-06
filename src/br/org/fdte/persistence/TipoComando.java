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
@Table(name = "tipo_comando", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "TipoComando.findAll", query = "SELECT t FROM TipoComando t"), @NamedQuery(name = "TipoComando.findById", query = "SELECT t FROM TipoComando t WHERE t.id = :id"), @NamedQuery(name = "TipoComando.findByNome", query = "SELECT t FROM TipoComando t WHERE t.nome = :nome"), @NamedQuery(name = "TipoComando.findByTipoParametro", query = "SELECT t FROM TipoComando t WHERE t.tipoParametro = :tipoParametro")})
public class TipoComando implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "tipo_comando_id_seq", sequenceName = "tipo_comando_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "tipo_comando_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false)
    private long nome;
    @Basic(optional = false)
    @Column(name = "tipo_parametro", nullable = false, length = 2147483647)
    private String tipoParametro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComando")
    private Collection<Passo> passoCollection;

    public TipoComando() {
    }

    public TipoComando(Long id) {
        this.id = id;
    }

    public TipoComando(Long id, long nome, String tipoParametro) {
        this.id = id;
        this.nome = nome;
        this.tipoParametro = tipoParametro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNome() {
        return nome;
    }

    public void setNome(long nome) {
        this.nome = nome;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }

    public Collection<Passo> getPassoCollection() {
        return passoCollection;
    }

    public void setPassoCollection(Collection<Passo> passoCollection) {
        this.passoCollection = passoCollection;
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
        if (!(object instanceof TipoComando)) {
            return false;
        }
        TipoComando other = (TipoComando) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.TipoComando[id=" + id + "]";
    }

}
