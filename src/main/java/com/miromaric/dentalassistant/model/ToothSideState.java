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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "tooth_side_state")
@NamedQueries({
    @NamedQuery(name = "ToothSideState.getAll", query = "SELECT tss FROM ToothSideState tss"),
    @NamedQuery(name = "ToothSideState.getById", query = "SELECT tss FROM ToothSideState tss WHERE tss.toothSideStateID = :id")
})
public class ToothSideState implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Basic(optional = false)
    private Long toothSideStateID;
    
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv status je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Boja statusa je obavezna")
    @Size(max = 20,message = "Naziv boje može imati najviše 20 karaktera")
    private String color;
    
    private String description;

    public ToothSideState() {
    }

    public ToothSideState(Long toothSideStateID, String name, String description, String color) {
        this.toothSideStateID = toothSideStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public Long getToothSideStateID() {
        return toothSideStateID;
    }

    public void setToothSideStateID(Long toothSideStateID) {
        this.toothSideStateID = toothSideStateID;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.toothSideStateID);
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
        final ToothSideState other = (ToothSideState) obj;
        if (!Objects.equals(this.toothSideStateID, other.toothSideStateID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ToothSideState{" + "toothSideStateID=" + toothSideStateID + ", name=" + name + ", description=" + description + ", color=" + color + '}';
    }
    
    
}
