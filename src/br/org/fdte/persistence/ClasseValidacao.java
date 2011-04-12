package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "classe_validacao")
@NamedQueries({@NamedQuery(name = "ClasseValidacao.findAll", query = "SELECT c FROM ClasseValidacao c"), @NamedQuery(name = "ClasseValidacao.findById", query = "SELECT c FROM ClasseValidacao c WHERE c.id = :id"), @NamedQuery(name = "ClasseValidacao.findByNome", query = "SELECT c FROM ClasseValidacao c WHERE c.nome = :nome")})
public class ClasseValidacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    public ClasseValidacao() {
    }

    public ClasseValidacao(Long id) {
        this.id = id;
    }

    public ClasseValidacao(Long id, String nome) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasseValidacao)) {
            return false;
        }
        ClasseValidacao other = (ClasseValidacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.ClasseValidacao[id=" + id + "]";
    }

}
