/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.org.fdte.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "config")
@NamedQueries({
    @NamedQuery(name = "Config.findAll", query = "SELECT c FROM Config c"),
    @NamedQuery(name = "Config.findByWorflowDir", query = "SELECT c FROM Config c WHERE c.worflowDir = :worflowDir"),
    @NamedQuery(name = "Config.findById", query = "SELECT c FROM Config c WHERE c.id = :id"),
    @NamedQuery(name = "Config.findByTesteCaseDir", query = "SELECT c FROM Config c WHERE c.testeCaseDir = :testeCaseDir"),
    @NamedQuery(name = "Config.findByResultDir", query = "SELECT c FROM Config c WHERE c.resultDir = :resultDir")})
public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "worflowDir")
    private String worflowDir;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "testeCaseDir")
    private String testeCaseDir;
    @Basic(optional = false)
    @Column(name = "resultDir")
    private String resultDir;

    public Config() {
    }

    public Config(Long id) {
        this.id = id;
    }

    public Config(Long id, String worflowDir, String testeCaseDir, String resultDir) {
        this.id = id;
        this.worflowDir = worflowDir;
        this.testeCaseDir = testeCaseDir;
        this.resultDir = resultDir;
    }

    public String getWorflowDir() {
        return worflowDir;
    }

    public void setWorflowDir(String worflowDir) {
        this.worflowDir = worflowDir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTesteCaseDir() {
        return testeCaseDir;
    }

    public void setTesteCaseDir(String testeCaseDir) {
        this.testeCaseDir = testeCaseDir;
    }

    public String getResultDir() {
        return resultDir;
    }

    public void setResultDir(String resultDir) {
        this.resultDir = resultDir;
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
        if (!(object instanceof Config)) {
            return false;
        }
        Config other = (Config) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.fdte.persistence.Config[id=" + id + "]";
    }

}
