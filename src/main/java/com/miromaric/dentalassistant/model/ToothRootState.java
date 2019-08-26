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
 * Klasa predstavlja stanje u kome se može nalaziti koren zuba.
 *
 * @author Miro Marić
 * @see ToothRoot
 * @see RootIntervention
 * 
 */
@Entity
@Table(name = "tooth_root_state")
@NamedQueries({
    @NamedQuery(name = "ToothRootState.getAll", query = "SELECT trs FROM ToothRootState trs"),
    @NamedQuery(name = "ToothRootState.getById", query = "SELECT trs FROM ToothRootState trs WHERE trs.toothRootStateID = :id")
})
public class ToothRootState implements Serializable{
    /**
     * Jedinstveni identifikator stanja korena.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Basic(optional = false)
    private Long toothRootStateID;
    
    /**
     * Naziv stanja.
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

    public ToothRootState() {
    }

    /**
     * 
     * @param toothRootStateID Jedinstveni identifikator stanja korena
     * @param name Naziv stanja
     * @param description Opis stanja
     * @param color Boja stanja
     */
    public ToothRootState(Long toothRootStateID, String name, String description, String color) {
        this.toothRootStateID = toothRootStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**
     * Vraća jedinstveni identifikator stanja korena.
     * @return Jedinstveni identifikator stanja korena
     */
    public Long getToothRootStateID() {
        return toothRootStateID;
    }

    /**
     * Postavlja jedinstveni identifikator stanja korena.
     * @param toothRootStateID Jedinstveni identifikator stanja korena
     */
    public void setToothRootStateID(Long toothRootStateID) {
        this.toothRootStateID = toothRootStateID;
    }

    /**
     * Vraća naziv stanja.
     * @return Naziv stanja.
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
     * Vraća opis stanja.
     * @return Opis stanja
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis stanja.
     * @param description Opis stanja.
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.toothRootStateID);
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
        final ToothRootState other = (ToothRootState) obj;
        if (!Objects.equals(this.toothRootStateID, other.toothRootStateID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ToothRootState{" + "toothRootStateID=" + toothRootStateID + ", name=" + name + ", description=" + description + ", color=" + color + '}';
    }
    
}
