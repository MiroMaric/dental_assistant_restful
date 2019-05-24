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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "tooth_side_label")
@NamedQueries({
    @NamedQuery(name = "ToothSideLabel.getAll", query = "SELECT tsl FROM ToothSideLabel tsl"),
    @NamedQuery(name = "ToothSideLabel.getById", query = "SELECT tsl FROM ToothSideLabel tsl WHERE tsl.toothSideLabelID = :id")
})
public class ToothSideLabel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false,length = 5)
    private int toothSideLabelID;
    
    @Column(nullable = false, length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv ozneke je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    @Size(max = 255,message = "Opis može imati najviše 255 karaktera")
    private String description;

    public ToothSideLabel() {
    }

    public ToothSideLabel(int toothSideLabelID, String name, String description) {
        this.toothSideLabelID = toothSideLabelID;
        this.name = name;
        this.description = description;
    }

    public int getToothSideLabelID() {
        return toothSideLabelID;
    }

    public void setToothSideLabelID(int toothSideLabelID) {
        this.toothSideLabelID = toothSideLabelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.toothSideLabelID;
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
        final ToothSideLabel other = (ToothSideLabel) obj;
        return this.toothSideLabelID == other.toothSideLabelID;
    }

    @Override
    public String toString() {
        return "ToothSideLabel{" + "toothSideLabelID=" + toothSideLabelID + ", name=" + name + ", description=" + description + '}';
    }

}
