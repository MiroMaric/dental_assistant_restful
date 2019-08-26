package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Klasa predstavlja intervenciju zubu.
 *
 * @author Miro Marić
 * @see InterventionItem
 * @see Tooth
 * @see ToothState
 *
 */
@Entity
@Table(name="tooth_intervention")
@NamedQueries({
    @NamedQuery(name = "ToothIntervention.getAll", query = "SELECT ti FROM ToothIntervention ti"),
    @NamedQuery(name = "ToothIntervention.getById", query = "SELECT ti FROM ToothIntervention ti WHERE ti.interventionItemID = :id")
})
public class ToothIntervention extends InterventionItem implements Serializable{
    
    /**
     * Zub na kome se vrši intervencija.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID",insertable = false,updatable = false)
    @Basic(optional = false)
    private Tooth tooth;
    /**
     * Novo stanje zuba.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothStateID",referencedColumnName = "toothStateID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothState toothState;

    public ToothIntervention() {
    }

    /**
     * 
     * @param tooth Zub na kome se vrši intervencija
     * @param toothState Novo stanje zuba
     */
    public ToothIntervention(Tooth tooth, ToothState toothState) {
        this.tooth = tooth;
        this.toothState = toothState;
    }

    /**
     * Vraća zub na kome se vrši intervencija.
     * @return Zub na kome se vrši intervencija
     */
    public Tooth getTooth() {
        return tooth;
    }

    /**
     * Postavlja zub na kome se vrši intervencija.
     * @param tooth Zub na kome se vrši intervencija
     */
    @JsonIgnore
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    /**
     * Vraća novo stanje zuba.
     * @return Novo stanje zuba
     */
    public ToothState getToothState() {
        return toothState;
    }

    /**
     * Postavlja novo stanje zuba.
     * @param toothState Novo stanje zuba
     */
    public void setToothState(ToothState toothState) {
        this.toothState = toothState;
    }

    @Override
    public String toString() {
        return "ToothIntervention{" + "tooth=" + tooth + ", toothState=" + toothState + '}';
    }
    
}
