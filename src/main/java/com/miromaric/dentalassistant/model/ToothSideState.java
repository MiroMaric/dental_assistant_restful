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
 * Klasa predstavlja stanje u kome može biti strana zuba.
 *
 * @author Miro Marić
 * @see Tooth
 * @see SideIntervention
 * @see ToothSideLabel
 * 
 */
@Entity
@Table(name = "tooth_side_state")
@NamedQueries({
    @NamedQuery(name = "ToothSideState.getAll", query = "SELECT tss FROM ToothSideState tss"),
    @NamedQuery(name = "ToothSideState.getById", query = "SELECT tss FROM ToothSideState tss WHERE tss.toothSideStateID = :id")
})
public class ToothSideState implements Serializable{
    /**
     * Jedinstveni identifikator stanja.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Basic(optional = false)
    private Long toothSideStateID;
    
    /**
     * Naziv stanja.
     */
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv status je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    /**
     * Boja stanja(Grafička reprezentacija).
     */
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Boja statusa je obavezna")
    @Size(max = 20,message = "Naziv boje može imati najviše 20 karaktera")
    private String color;
    
    /**
     * Opis stanja strane zuba.
     */
    private String description;

    public ToothSideState() {
    }

    /**
     * 
     * @param toothSideStateID Jedinstveni identifikator stanja
     * @param name Naziv stanja
     * @param description Opis stanja strane zuba
     * @param color Boja stanja(grafička reprezentacija)
     */
    public ToothSideState(Long toothSideStateID, String name, String description, String color) {
        this.toothSideStateID = toothSideStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**
     * Vraća jedinstveni identifikator stanja.
     * @return Jedinstveni identifikator stanja
     */
    public Long getToothSideStateID() {
        return toothSideStateID;
    }

    /**
     * Postavlja jedinstveni identifikator stanja.
     * @param toothSideStateID Jedinstveni identifikator stanja
     */
    public void setToothSideStateID(Long toothSideStateID) {
        this.toothSideStateID = toothSideStateID;
    }

    /**
     * Vraća naziv stanja.
     * @return Naziv stanja
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja naziv stanja.
     * @param name Naziv stanja
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraća opis stanja strane zuba.
     * @return Opis stanja strane zuba
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis stanja strane zuba.
     * @param description Opis stanja strane zuba
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Vraća boju stanja.
     * @return Boja stanja
     */
    public String getColor() {
        return color;
    }

    /**
     * Postavlja Boju stanja.
     * @param color Boja stanja
     */
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
