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
 * Klasa predstavlja oznaku strane zuba.
 *
 * @author Miro Marić
 * @see ToothSide
 * 
 */
@Entity
@Table(name = "tooth_side_label")
@NamedQueries({
    @NamedQuery(name = "ToothSideLabel.getAll", query = "SELECT tsl FROM ToothSideLabel tsl"),
    @NamedQuery(name = "ToothSideLabel.getById", query = "SELECT tsl FROM ToothSideLabel tsl WHERE tsl.toothSideLabelID = :id")
})
public class ToothSideLabel implements Serializable {

    /**
     * Jedinstveni identifikator oznake strane zuba.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false,length = 5)
    private Long toothSideLabelID;
    
    /**
     * Naziv oznake.
     */
    @Column(nullable = false, length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv oznake je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    /**
     * Opis strane zuba.
     */
    @Size(max = 255,message = "Opis može imati najviše 255 karaktera")
    private String description;

    public ToothSideLabel() {
    }

    /**
     * 
     * @param toothSideLabelID Jedinstveni identifikator oznake strane zuba
     * @param name Naziv oznake
     * @param description Opis strane zuba
     */
    public ToothSideLabel(Long toothSideLabelID, String name, String description) {
        this.toothSideLabelID = toothSideLabelID;
        this.name = name;
        this.description = description;
    }

    /**
     * Vraća jedinstveni identifikator oznake strane zuba.
     * @return Jedinstveni identifikator oznake strane zuba
     */
    public Long getToothSideLabelID() {
        return toothSideLabelID;
    }

    /**
     * Postavlja jedinstveni identifikator oznake strane zuba.
     * @param toothSideLabelID Jedinstveni identifikator oznake strane zuba
     */
    public void setToothSideLabelID(Long toothSideLabelID) {
        this.toothSideLabelID = toothSideLabelID;
    }

    /**
     * Vraća naziv oznake.
     * @return Naziv oznake.
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja naziv oznake.
     * @param name Naziv oznake
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vraća opis strane zuba.
     * @return Opis strane zuba.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja opis strane zuba.
     * @param description Opis strane zuba
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.toothSideLabelID);
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
        if (!Objects.equals(this.toothSideLabelID, other.toothSideLabelID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ToothSideLabel{" + "toothSideLabelID=" + toothSideLabelID + ", name=" + name + ", description=" + description + '}';
    }

}
