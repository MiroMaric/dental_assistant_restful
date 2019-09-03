package com.miromaric.dentalassistant.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/**
 * Klasa predstavlja oznaku zuba.
 *
 * @author Miro Marić
 * @see Tooth
 * 
 */
@Entity
@Table(name = "tooth_label")
@NamedQueries({
    @NamedQuery(name = "ToothLabel.getAll", query = "SELECT tl FROM ToothLabel tl"),
    @NamedQuery(name = "ToothLabel.getById", query = "SELECT tl FROM ToothLabel tl WHERE tl.toothLabelID = :id")
})
public class ToothLabel implements Serializable{
    /**
     * Jedinstveni identifikator oznake zuba.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false,length = 5)
    private Long toothLabelID;
    
    /**
     * Broj zuba(1-8).
     */
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 8)
    private int number;
    
    /**
     * Kvadrant zuba(1-4).
     */
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 4)
    private int quadrant;
    /**
     * Broj korena(1-3).
     */
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 3)
    private int numOfRoots;
    
    /**
     * Opis zuba.
     */
    @Size(max = 255,message = "Opis može imati najviše 255 karaktera")
    private String description;

    public ToothLabel() {
    }
    /**
     * 
     * @param toothLabelID Jedinstveni identifikator oznake zuba
     */
    public ToothLabel(Long toothLabelID){
        this.toothLabelID = toothLabelID;
    }

    /**
     * 
     * @param toothLabelID Jedinstveni identifikator oznake zuba
     * @param number Broj zuba
     * @param quadrant Kvadrant zuba
     * @param numOfRoots Broj korena zuba
     * @param description Opis zuba
     */
    public ToothLabel(Long toothLabelID, int number, int quadrant, int numOfRoots, String description) {
        this.toothLabelID = toothLabelID;
        this.number = number;
        this.quadrant = quadrant;
        this.numOfRoots = numOfRoots;
        this.description = description;
    }

    /**
     * Vraća jedinstveni identifikator oznake zuba.
     * @return Jedinstveni identifikator oznake zuba
     */
    public Long getToothLabelID() {
        return toothLabelID;
    }

    /**
     * Postavlja jedinstveni identifikator oznake zuba.
     * @param toothLabelID Jedinstveni identifikator oznake zuba
     */
    public void setToothLabelID(Long toothLabelID) {
        this.toothLabelID = toothLabelID;
    }

    /**
     * Vraća broj zuba.
     * @return Broj zuba
     */
    public int getNumber() {
        return number;
    }

    /**
     * Postavlja broj zuba.
     * @param number Broj zuba
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Vraća kvadrant zuba.
     * @return Kvadrant zuba
     */
    public int getQuadrant() {
        return quadrant;
    }

    /**
     * Postavlja kvadrant zuba.
     * @param quadrant Kvadrant zuba
     */
    public void setQuadrant(int quadrant) {
        this.quadrant = quadrant;
    }

    /**
     * Vraća broj korena.
     * @return Broj korena
     */
    public int getNumOfRoots() {
        return numOfRoots;
    }

    /**
     * Postavlja broj korena.
     * @param numOfRoots Broj korena
     */
    public void setNumOfRoots(int numOfRoots) {
        this.numOfRoots = numOfRoots;
    }

    /**
     * Vraća opis zuba.
     * @return Opis zuba
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis zuba.
     * @param description Opis zuba
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.toothLabelID);
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
        final ToothLabel other = (ToothLabel) obj;
        if (!Objects.equals(this.toothLabelID, other.toothLabelID)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "ToothLabel{" + "toothLabelID=" + toothLabelID + '}';
    }
    
}
