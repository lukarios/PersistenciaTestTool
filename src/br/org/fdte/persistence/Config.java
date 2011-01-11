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
    @NamedQuery(name = "Config.findByWorkflowdir", query = "SELECT c FROM Config c WHERE c.workflowdir = :workflowdir"),
    @NamedQuery(name = "Config.findById", query = "SELECT c FROM Config c WHERE c.id = :id"),
    @NamedQuery(name = "Config.findByTestecasedir", query = "SELECT c FROM Config c WHERE c.testecasedir = :testecasedir"),
    @NamedQuery(name = "Config.findByResultdir", query = "SELECT c FROM Config c WHERE c.resultdir = :resultdir")})
public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "workflowdir")
    private String workflowdir;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "testecasedir")
    private String testecasedir;
    @Basic(optional = false)
    @Column(name = "resultdir")
    private String resultdir;

    public Config() {
    }

    public Config(Long id) {
        this.id = id;
    }

    public Config(Long id, String workflowdir, String testecasedir, String resultdir) {
        this.id = id;
        this.workflowdir = workflowdir;
        this.testecasedir = testecasedir;
        this.resultdir = resultdir;
    }

    public String getWorkflowdir() {
        return workflowdir;
    }

    public void setWorkflowdir(String workflowdir) {
        this.workflowdir = workflowdir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestecasedir() {
        return testecasedir;
    }

    public void setTestecasedir(String testecasedir) {
        this.testecasedir = testecasedir;
    }

    public String getResultdir() {
        return resultdir;
    }

    public void setResultdir(String resultdir) {
        this.resultdir = resultdir;
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
