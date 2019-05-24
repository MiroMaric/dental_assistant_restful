package com.miromaric.dentalassistant.model;

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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Tatjana
 */
@Entity
@Table(name = "tooth_label")
@NamedQueries({
    @NamedQuery(name = "ToothLabel.getAll", query = "SELECT tl FROM ToothLabel tl")
    ,
    @NamedQuery(name = "ToothLabel.getById", query = "SELECT tl FROM ToothLabel tl WHERE tl.toothLabelID = :id")
})
public class ToothLabel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false,length = 5)
    private int toothLabelID;
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 8)
    private int number;
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 4)
    private int quadrant;
    @Basic(optional = false)
    @Column(nullable = false)
    @Range(min = 1,max = 3)
    private int numOfRoots;
    
    @Size(max = 255,message = "Opis može imati najviše 255 karaktera")
    private String description;

    public ToothLabel() {
    }
    
    public ToothLabel(int toothLabelID){
        this.toothLabelID = toothLabelID;
    }

    public ToothLabel(int toothLabelID, int number, int quadrant, int numOfRoots, String description) {
        this.toothLabelID = toothLabelID;
        this.number = number;
        this.quadrant = quadrant;
        this.numOfRoots = numOfRoots;
        this.description = description;
    }

    public int getToothLabelID() {
        return toothLabelID;
    }

    public void setToothLabelID(int toothLabelID) {
        this.toothLabelID = toothLabelID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(int quadrant) {
        this.quadrant = quadrant;
    }

    public int getNumOfRoots() {
        return numOfRoots;
    }

    public void setNumOfRoots(int numOfRoots) {
        this.numOfRoots = numOfRoots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.toothLabelID;
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
        return this.toothLabelID == other.toothLabelID;
    }

    @Override
    public String toString() {
        return "ToothLabel{" + "toothLabelID=" + toothLabelID + '}';
    }
    
}
