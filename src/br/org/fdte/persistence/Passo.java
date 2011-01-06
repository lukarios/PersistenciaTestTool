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
import javax.persistence.ManyToOne;
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
@Table(name = "passo", catalog = "test_tool", schema = "public")
@NamedQueries({@NamedQuery(name = "Passo.findAll", query = "SELECT p FROM Passo p"), @NamedQuery(name = "Passo.findById", query = "SELECT p FROM Passo p WHERE p.id = :id"), @NamedQuery(name = "Passo.findBySequencia", query = "SELECT p FROM Passo p WHERE p.sequencia = :sequencia")})
public class Passo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

/*MB */
    @SequenceGenerator( name = "passo_id_seq", sequenceName = "passo_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "passo_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "sequencia", nullable = false)
    private int sequencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPasso")
    private Collection<AtivacaoPasso> ativacaoPassoCollection;
    @JoinColumn(name = "id_caracterizacao_teste_sequencia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CaracterizacaoTesteSequencia idCaracterizacaoTesteSequencia;
    @JoinColumn(name = "id_tipo_comando", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoComando idTipoComando;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPasso")
    private Collection<ParametroPasso> parametroPassoCollection;

    public Passo() {
    }

    public Passo(Long id) {
        this.id = id;
    }

    public Passo(Long id, int sequencia) {
        this.id = id;
        this.sequencia = sequencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public Collection<AtivacaoPasso> getAtivacaoPassoCollection() {
        return ativacaoPassoCollection;
    }

    public void setAtivacaoPassoCollection(Collection<AtivacaoPasso> ativacaoPassoCollection) {
        this.ativacaoPassoCollection = ativacaoPassoCollection;
    }

    public CaracterizacaoTesteSequencia getIdCaracterizacaoTesteSequencia() {
        return idCaracterizacaoTesteSequencia;
    }

    public void setIdCaracterizacaoTesteSequencia(CaracterizacaoTesteSequencia idCaracterizacaoTesteSequencia) {
        this.idCaracterizacaoTesteSequencia = idCaracterizacaoTesteSequencia;
    }

    public TipoComando getIdTipoComando() {
        return idTipoComando;
    }

    public void setIdTipoComando(TipoComando idTipoComando) {
        this.idTipoComando = idTipoComando;
    }

    public Collection<ParametroPasso> getParametroPassoCollection() {
        return parametroPassoCollection;
    }

    public void setParametroPassoCollection(Collection<ParametroPasso> parametroPassoCollection) {
        this.parametroPassoCollection = parametroPassoCollection;
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
        if (!(object instanceof Passo)) {
            return false;
        }
        Passo other = (Passo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Passo[id=" + id + "]";
    }

}
