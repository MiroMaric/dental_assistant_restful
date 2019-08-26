package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 * Klasa predstavlja stranu zuba.
 *
 * @author Miro Marić
 * @see Tooth
 * @see SideIntervention
 * @see ToothSideLabel
 * 
 */
@Entity
@Table(name = "tooth_side")
@NamedQueries({
    @NamedQuery(name = "ToothSide.getAll", query = "SELECT ts FROM ToothSide ts"),
    @NamedQuery(name = "ToothSide.getById", query = "SELECT ts FROM ToothSide ts WHERE ts.toothSideID = :id")
})
public class ToothSide implements Serializable{
    /**
     * Jedinstveni identifikator strane zuba.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long toothSideID;
    /**
     * Zub pacijenta.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID")
    @Basic(optional = false)
    private Tooth tooth;
    
    /**
     * Oznaka strane.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideLabelID",referencedColumnName = "toothSideLabelID")
    @Basic(optional = false)
    private ToothSideLabel sideLabel;
    
    /**
     * Intervencije na strani zuba.
     */
    @OneToMany(mappedBy = "toothSide",fetch = FetchType.EAGER)
    @Basic(optional = false)
    private List<SideIntervention> sideInterventions;

    public ToothSide() {
    }

    /**
     * 
     * @param toothSideID Jedinstveni identifikator strane zuba
     * @param tooth Zub pacijenta
     * @param label Oznaka strane
     * @param sideInterventions Intervencije na strani zuba
     */
    public ToothSide(Long toothSideID, Tooth tooth, ToothSideLabel label, List<SideIntervention> sideInterventions) {
        this.toothSideID = toothSideID;
        this.tooth = tooth;
        this.sideLabel = label;
        this.sideInterventions = sideInterventions;
    }

    /**
     * Vraća jedinstveni identifikator strane zuba.
     * @return Jedinstveni identifikator strane zuba
     */
    public Long getToothSideID() {
        return toothSideID;
    }

    /**
     * Postavlja jedinstveni identifikator strane zuba.
     * @param toothSideID Jedinstveni identifikator strane zuba.
     */
    public void setToothSideID(Long toothSideID) {
        this.toothSideID = toothSideID;
    }

    /**
     * Vraća zub pacijenta.
     * @return Zub pacijenta
     */
    public Tooth getTooth() {
        return tooth;
    }

    /**
     * Postavlja zub pacijenta.
     * @param tooth Zub pacijenta.
     */
    @JsonIgnore
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    /**
     * Vraća oznaku strane.
     * @return Oznaka strane
     */
    public ToothSideLabel getSideLabel() {
        return sideLabel;
    }

    /**
     * Postavlja oznaka strane.
     * @param sideLabel Oznaka strane
     */
    public void setSideLabel(ToothSideLabel sideLabel) {
        this.sideLabel = sideLabel;
    }

    /**
     * Vraća intervencije na strani zuba.
     * @return Intervencije na strani zuba
     */
    public List<SideIntervention> getSideInterventions() {
        return sideInterventions;
    }

    /**
     * Postavlja intervencije na strani zuba.
     * @param sideInterventions Intervencije na strani zuba.
     */
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
