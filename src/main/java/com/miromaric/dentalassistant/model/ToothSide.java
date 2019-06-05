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
@Table(name = "tooth_side")
@NamedQueries({
    @NamedQuery(name = "ToothSide.getAll", query = "SELECT ts FROM ToothSide ts"),
    @NamedQuery(name = "ToothSide.getById", query = "SELECT ts FROM ToothSide ts WHERE ts.toothSideID = :id")
})
public class ToothSide implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long toothSideID;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID",insertable = false,updatable = false)
    @Basic(optional = false)
    private Tooth tooth;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideLabelID",referencedColumnName = "toothSideLabelID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothSideLabel sideLabel;
    
    @OneToMany(mappedBy = "toothSide")
    @Basic(optional = false)
    private List<SideIntervention> sideInterventions;

    public ToothSide() {
    }

    public ToothSide(Long toothSideID, Tooth tooth, ToothSideLabel label, List<SideIntervention> sideInterventions) {
        this.toothSideID = toothSideID;
        this.tooth = tooth;
        this.sideLabel = label;
        this.sideInterventions = sideInterventions;
    }

    public Long getToothSideID() {
        return toothSideID;
    }

    public void setToothSideID(Long toothSideID) {
        this.toothSideID = toothSideID;
    }

    public Tooth getTooth() {
        return tooth;
    }

    @JsonIgnore
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public ToothSideLabel getLabel() {
        return sideLabel;
    }

    public void setLabel(ToothSideLabel label) {
        this.sideLabel = label;
    }

    public List<SideIntervention> getSideInterventions() {
        return sideInterventions;
    }

    public void setSideInterventions(List<SideIntervention> sideInterventions) {
        this.sideInterventions = sideInterventions;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.toothSideID);
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
        final ToothSide other = (ToothSide) obj;
        return Objects.equals(this.toothSideID, other.toothSideID);
    }

    @Override
    public String toString() {
        return "ToothSide{" + "toothSideID=" + toothSideID + ", tooth=" + tooth + ", label=" + sideLabel + ", sideInterventions=" + sideInterventions + '}';
    }
    
}
