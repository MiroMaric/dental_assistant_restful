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
 *
 * @author MikoPC
 */
@Entity
@Table(name = "intervention_item")
@Inheritance(strategy = InheritanceType.JOINED)
//@IdClass(InterventionItemPK.class)
public abstract class InterventionItem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    @Basic(optional = false)
    protected Long interventionItemID;
    
    //@Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "interventionID", referencedColumnName = "interventionID")
    @Basic(optional = false)
    protected Intervention intervention;
    
    protected String note;

    public InterventionItem() {
    }

    public InterventionItem(Long itemID, Intervention intervention, String note) {
        this.interventionItemID = itemID;
        this.intervention = intervention;
        this.note = note;
    }

    public Long getItemID() {
        return interventionItemID;
    }

    public void setItemID(Long itemID) {
        this.interventionItemID = itemID;
    }

    @JsonIgnore
    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public String getNote() {
        return note;
    }

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
