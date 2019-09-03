package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Klasa predstavlja zub pacijenta.
 *
 * @author Miro Marić
 * @see Patient
 * @see ToothRoot
 * @see ToothSide
 * @see ToothIntervention
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tooth.getAll", query = "SELECT t FROM Tooth t"),
    @NamedQuery(name = "Tooth.getById", query = "SELECT t FROM Tooth t WHERE t.toothID = :id")
})
public class Tooth implements Serializable{
    
    /**
     * Jedinstveni identifikator zuba.
     */
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toothID;
    
    /**
     * Pacijent.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientID", referencedColumnName = "patientID")
    @Basic(optional = false)
    private Patient patient;
    
    /**
     * Oznaka zuba.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothLabelID", referencedColumnName = "toothLabelID")
    @Basic(optional = false)
    private ToothLabel toothLabel;
    
    /**
     * Koreni zuba.
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tooth",fetch = FetchType.LAZY,orphanRemoval = true)
    @Basic(optional = false)
    private List<ToothRoot> toothRoots;
    /**
     * Strane zuba.
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tooth",fetch = FetchType.LAZY,orphanRemoval = true)
    @Basic(optional = false)
    private List<ToothSide> toothSides;
    
    /**
     * Intervencije na zubu.
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tooth",fetch = FetchType.LAZY)
    @Basic(optional = false)
    private List<ToothIntervention> toothInterventions;
    

    public Tooth() {
    }

    /**
     * 
     * @param toothID Jedinstveni identifikator zuba
     * @param patient Pacijent
     * @param label Oznaka zuba
     */
    public Tooth(Long toothID, Patient patient, ToothLabel label) {
        this.toothID = toothID;
        this.patient = patient;
        this.toothLabel = label;
    }

    /**
     * Vraća jedinstveni identifikator zuba.
     * @return Jedinstveni identifikator zuba
     */
    public Long getToothID() {
        return toothID;
    }

    /**
     * Postavlja jedinstveni identifikator zuba.
     * @param toothID Jedinstveni identifikator zuba
     */
    public void setToothID(Long toothID) {
        this.toothID = toothID;
    }

    /**
     * Vraća pacijenta
     * @return Pacijent
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Postavlja pacijenta
     * @param patient Pacijent
     */
    @JsonIgnore
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Vraća oznaku zuba.
     * @return Oznaka zuba
     */
    public ToothLabel getToothLabel() {
        return toothLabel;
    }

    /**
     * Vraća korene zuba.
     * @return Koreni zuba
     */
    public List<ToothRoot> getToothRoots() {
        return toothRoots;
    }
    /**
     * Vraća strane zuba.
     * @return Strane zuba
     */
    public List<ToothSide> getToothSides() {
        return toothSides;
    }

    /**
     * Postavlja oznaku zuba.
     * @param toothLabel Oznaka zuba
     */
    public void setToothLabel(ToothLabel toothLabel) {
        this.toothLabel = toothLabel;
    }

    /**
     * Postavlja korene zuba.
     * @param toothRoots Koreni zuba
     */
    public void setToothRoots(List<ToothRoot> toothRoots) {
        this.toothRoots = toothRoots;
    }

    /**
     * Postavlja strane zuba.
     * @param toothSides Strane zuba
     */
    public void setToothSides(List<ToothSide> toothSides) {
        this.toothSides = toothSides;
    }

    /**
     * Vraća intervencije na zubu
     * @return Intervencije na zubu
     */
    public List<ToothIntervention> getToothInterventions() {
        return toothInterventions;
    }

    /**
     * Postavlja intervencije na zubu.
     * @param toothInterventions Intervencije na zubu.
     */
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
