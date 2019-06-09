package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "tooth_root")
@NamedQueries({
    @NamedQuery(name = "ToothRoot.getAll", query = "SELECT tr FROM ToothRoot tr"),
    @NamedQuery(name = "ToothRoot.getById", query = "SELECT tr FROM ToothRoot tr WHERE tr.toothRootID = :id")
})
public class ToothRoot implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long toothRootID;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID")
    private Tooth tooth;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootLabelID",referencedColumnName = "toothRootLabelID")
    @Basic(optional = false)
    private ToothRootLabel rootLabel;
    
    @OneToMany(mappedBy = "toothRoot")
    @Basic(optional = false)
    private List<RootIntervention> rootInterventions;

    public ToothRoot() {
    }

    public ToothRoot(Long toothRootID, Tooth tooth, ToothRootLabel rootLabel, List<RootIntervention> rootInterventions) {
        this.toothRootID = toothRootID;
        this.tooth = tooth;
        this.rootLabel = rootLabel;
        this.rootInterventions = rootInterventions;
    }

    public List<RootIntervention> getRootInterventions() {
        return rootInterventions;
    }

    public ToothRootLabel getRootLabel() {
        return rootLabel;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public Long getToothRootID() {
        return toothRootID;
    }

    public void setRootInterventions(List<RootIntervention> rootInterventions) {
        this.rootInterventions = rootInterventions;
    }

    public void setRootLabel(ToothRootLabel rootLabel) {
        this.rootLabel = rootLabel;
    }

    @JsonIgnore
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public void setToothRootID(Long toothRootID) {
        this.toothRootID = toothRootID;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.toothRootID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToothRoot other = (ToothRoot) obj;
        return Objects.equals(this.toothRootID, other.toothRootID);
    }

    @Override
    public String toString() {
        return "ToothRoot{" + "toothRootID=" + toothRootID + ", tooth=" + tooth + ", rootLabel=" + rootLabel + '}';
    }
    
}
