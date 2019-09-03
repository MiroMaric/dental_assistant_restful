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
 * Klasa predstavlja stanje u kome se može nalaziti zub.
 *
 * @author Miro Marić
 * @see Tooth
 * @see ToothIntervention
 * 
 */
@Entity
@Table(name = "tooth_state")
@NamedQueries({
    @NamedQuery(name = "ToothState.getAll", query = "SELECT ts FROM ToothState ts"),
    @NamedQuery(name = "ToothState.getById", query = "SELECT ts FROM ToothState ts WHERE ts.toothStateID = :id")
})
public class ToothState implements Serializable{

    /**
     * Jedinstveni identifikator stanja.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Basic(optional = false)
    private Long toothStateID;
    
    /**
     * Naziv stanja zuba.
     */
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv status je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    /**
     * Boja stanja(grafička reprezentacija).
     */
    @Column(nullable = false,length = 20)
    @Basic(optional = false)
    @NotNull(message = "Boja statusa je obavezna")
    @Size(max = 20,message = "Naziv boje može imati najviše 20 karaktera")
    private String color;
    
    /**
     * Opis stanja.
     */
    private String description;

    public ToothState() {
    }
    /**
     * 
     * @param toothStateID Jedinstveni identifikator stanja
     */
    public ToothState(Long toothStateID) {
        this.toothStateID = toothStateID;
    }

    /**
     * 
     * @param toothStateID Jedinstveni identifikator stanja
     * @param name Naziv stanja zuba
     * @param description Opis stanja
     * @param color Boja stanja
     */
    public ToothState(Long toothStateID, String name, String description, String color) {
        this.toothStateID = toothStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**
     * Vraća jedinstveni identifikator stanja.
     * @return Jedinstveni identifikator stanja
     */
    public Long getToothStateID() {
        return toothStateID;
    }

    /**
     * Postavlja jedinstveni identifikator stanja.
     * @param toothStateID Jedinstveni identifikator stanja.
     */
    public void setToothStateID(Long toothStateID) {
        this.toothStateID = toothStateID;
    }

    /**
     * Vraća naziv stanja zuba.
     * @return Naziv stanja zuba
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja naziv stanja zuba.
     * @param name Naziv stanja zuba
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraća opis stanja.
     * @return Opis stanja
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis stanja.
     * @param description Opis stanja
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
     * Postavlja boju stanja.
     * @param color Boja stanja
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.toothStateID);
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
        final ToothState other = (ToothState) obj;
        return Objects.equals(this.toothStateID, other.toothStateID);
    }

    @Override
    public String toString() {
        return "ToothState{" + "toothStateID=" + toothStateID + ", name=" + name + ", description=" + description + ", color=" + color + '}';
    }
    
    
}
