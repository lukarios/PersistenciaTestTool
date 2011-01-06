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
import javax.persistence.UniqueConstraint;

/* MB */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author MB
 */
@Entity
@Table(name = "classe_equivalencia", catalog = "test_tool", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({@NamedQuery(name = "ClasseEquivalencia.findAll", query = "SELECT c FROM ClasseEquivalencia c"), @NamedQuery(name = "ClasseEquivalencia.findById", query = "SELECT c FROM ClasseEquivalencia c WHERE c.id = :id"), @NamedQuery(name = "ClasseEquivalencia.findByNome", query = "SELECT c FROM ClasseEquivalencia c WHERE c.nome = :nome"), @NamedQuery(name = "ClasseEquivalencia.findByComentario", query = "SELECT c FROM ClasseEquivalencia c WHERE c.comentario = :comentario")})
public class ClasseEquivalencia implements Serializable, Comparable<ClasseEquivalencia> {

    private static final long serialVersionUID = 1L;
    @Id
/*MB */
    @SequenceGenerator( name = "classe_equivalencia_id_seq", sequenceName = "classe_equivalencia_id_seq", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "classe_equivalencia_id_seq" )

    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "comentario", length = 255)
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasseEquivalencia")
    private Collection<Atributo> atributoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasseEquivalencia")
    private Collection<Valor> valorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "heranca")
    private Collection<ClasseEquivalencia> classeEquivalenciaCollection;
    @JoinColumn(name = "heranca", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClasseEquivalencia heranca;
    @JoinColumn(name = "tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoClasseEquivalencia tipo;

    public ClasseEquivalencia() {
    }

    public ClasseEquivalencia(Long id) {
        this.id = id;
    }

    public ClasseEquivalencia(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<Atributo> getAtributoCollection() {
        return atributoCollection;
    }

    public void setAtributoCollection(Collection<Atributo> atributoCollection) {
        this.atributoCollection = atributoCollection;
    }

    public Collection<Valor> getValorCollection() {
        return valorCollection;
    }

    public void setValorCollection(Collection<Valor> valorCollection) {
        this.valorCollection = valorCollection;
    }

    public Collection<ClasseEquivalencia> getClasseEquivalenciaCollection() {
        return classeEquivalenciaCollection;
    }

    public void setClasseEquivalenciaCollection(Collection<ClasseEquivalencia> classeEquivalenciaCollection) {
        this.classeEquivalenciaCollection = classeEquivalenciaCollection;
    }

    public ClasseEquivalencia getHeranca() {
        return heranca;
    }

    public void setHeranca(ClasseEquivalencia heranca) {
        this.heranca = heranca;
    }

    public TipoClasseEquivalencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoClasseEquivalencia tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof ClasseEquivalencia)) {
            return false;
        }
        ClasseEquivalencia other = (ClasseEquivalencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.ClasseEquivalencia[id=" + id + "]";
    }

    /* LRB */
    public int compareTo(ClasseEquivalencia ce) {
        return nome.compareTo(ce.getNome());
    }

}
