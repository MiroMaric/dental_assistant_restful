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

/**
 *
 * @author MikoPC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tooth.getAll", query = "SELECT t FROM Tooth t"),
    @NamedQuery(name = "Tooth.getById", query = "SELECT t FROM Tooth t WHERE t.toothID = :id")
})
public class Tooth implements Serializable{
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toothID;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientID", referencedColumnName = "patientID", insertable = false, updatable = false)
    @Basic(optional = false)
    private Patient patient;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothLabelID", referencedColumnName = "toothLabelID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothLabel toothLabel;
    
    @OneToMany(mappedBy = "tooth")
    @Basic(optional = false)
    private List<ToothRoot> toothRoots;
    
    @OneToMany(mappedBy = "tooth")
    @Basic(optional = false)
    private List<ToothSide> toothSides;
    
    @OneToMany(mappedBy = "tooth")
    @Basic(optional = false)
    private List<ToothIntervention> toothInterventions;
    

    public Tooth() {
    }

    public Tooth(Long toothID, Patient patient, ToothLabel label) {
        this.toothID = toothID;
        this.patient = patient;
        this.toothLabel = label;
    }

    public Long getToothID() {
        return toothID;
    }

    public void setToothID(Long toothID) {
        this.toothID = toothID;
    }

    public Patient getPatient() {
        return patient;
    }

    @JsonIgnore
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ToothLabel getToothLabel() {
        return toothLabel;
    }

    public List<ToothRoot> getToothRoots() {
        return toothRoots;
    }

    public List<ToothSide> getToothSides() {
        return toothSides;
    }

    public void setToothLabel(ToothLabel toothLabel) {
        this.toothLabel = toothLabel;
    }

    public void setToothRoots(List<ToothRoot> toothRoots) {
        this.toothRoots = toothRoots;
    }

    public void setToothSides(List<ToothSide> toothSides) {
        this.toothSides = toothSides;
    }

    public List<ToothIntervention> getToothInterventions() {
        return toothInterventions;
    }

    public void setToothInterventions(List<ToothIntervention> toothInterventions) {
        this.toothInterventions = toothInterventions;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.toothID);
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
        final Tooth other = (Tooth) obj;
        return Objects.equals(this.toothID, other.toothID);
    }

    @Override
    public String toString() {
        return "Tooth{" + "toothID=" + toothID + ", patient=" + patient + ", label=" + toothLabel + '}';
    }
}
