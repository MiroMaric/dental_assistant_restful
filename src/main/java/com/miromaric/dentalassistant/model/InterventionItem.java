package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Klasa predstavlja stravku intervencije.
 *
 * @author Miro Marić
 * @see Intervention
 * @see SideIntervention
 * @see ToothIntervention
 * @see RootIntervention
 * @see User
 *
 */
@Entity
@Table(name = "intervention_item")
@Inheritance(strategy = InheritanceType.JOINED)
//@IdClass(InterventionItemPK.class)
public abstract class InterventionItem implements Serializable {

    /**
     * Jedinstveni identifikator stavke intervencije.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Basic(optional = false)
    protected Long interventionItemID;
    /**
     * Intervencija.
     */
    //@Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "interventionID", referencedColumnName = "interventionID")
    @Basic(optional = false)
    protected Intervention intervention;

    /**
     * Opis stavke.
     */
    protected String note;

    public InterventionItem() {
    }

    /**
     *
     * @param itemID Jedinstveni identifikator stavke intervencije
     * @param intervention Intervencija
     * @param note Opis stavke
     */
    public InterventionItem(Long itemID, Intervention intervention, String note) {
        this.interventionItemID = itemID;
        this.intervention = intervention;
        this.note = note;
    }

    /**
     * Vraća jedinstveni identifikator stavke intervencije.
     *
     * @return Jedinstveni identifikator stavke intervencije
     */
    public Long getItemID() {
        return interventionItemID;
    }

    /**
     * Postavlja jedinstveni identifikator stavke intervencije.
     *
     * @param itemID Jedinstveni identifikator stavke intervencije
     */
    public void setItemID(Long itemID) {
        this.interventionItemID = itemID;
    }

    /**
     * Vraća intervenciju kojoj pripada navedena stavka.
     *
     * @return Intervencija
     */
    //@JsonIgnore
    public Intervention getIntervention() {
        return intervention;
    }

    /**
     * Postavlja intervenciju kojoj pripada navedena stavka.
     *
     * @param intervention Intervencija
     */
    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    /**
     * Vraća opis stavke.
     * @return Opis stavke.
     */
    public String getNote() {
        return note;
    }

    /**
     * Postavlja opis stavke.
     * @param note Opis stavke
     */
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.interventionItemID);
        hash = 37 * hash + Objects.hashCode(this.intervention);
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
        final InterventionItem other = (InterventionItem) obj;
        if (!Objects.equals(this.interventionItemID, other.interventionItemID)) {
            return false;
        }
        return Objects.equals(this.intervention, other.intervention);
    }

}
