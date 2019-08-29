package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Klasa predstavlja intervenciju na strani zuba.
 *
 * @author Miro Marić
 * @see InterventionItem
 * @see ToothSide
 * @see ToothSideState
 *
 */
@Entity
@Table(name="side_intervention")
@NamedQueries({
    @NamedQuery(name = "SideIntervention.getAll", query = "SELECT si FROM SideIntervention si"),
    @NamedQuery(name = "SideIntervention.getById", query = "SELECT si FROM SideIntervention si WHERE si.interventionItemID = :id")
})
public class SideIntervention extends InterventionItem{
    /**
     * Strana zuba na kojoj se vrši intervencija.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideID",referencedColumnName = "toothSideID")
    @Basic(optional = false)
    private ToothSide toothSide;
    
    /**
     * Novo stanje strane zuba.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideStateID",referencedColumnName = "toothSideStateID")
    @Basic(optional = false)
    private ToothSideState toothSideState;
    
    public SideIntervention() {
        
    }

    /**
     * 
     * @param toothSide Strana zuba na kojoj se vrši intervencija
     * @param toothSideState Novo stanje strane zuba
     */
    public SideIntervention(ToothSide toothSide, ToothSideState toothSideState) {
        this.toothSide = toothSide;
        this.toothSideState = toothSideState;
    }

    /**
     * 
     * @param toothSide Strana zuba na kojoj se vrši intervencija
     * @param toothSideState Novo stanje strane zuba
     * @param itemID Jedinstveni identifikator stavke intervencije
     * @param intervention Intervencija
     * @param note Opis stavke
     */
    public SideIntervention(ToothSide toothSide, ToothSideState toothSideState, Long itemID, Intervention intervention, String note) {
        super(itemID, intervention, note);
        this.toothSide = toothSide;
        this.toothSideState = toothSideState;
    }

    /**
     * Vraća stranu zuba na kojoj se vrši intervencija.
     * @return Strana zuba na kojoj se vrši intervencija
     */
    public ToothSide getToothSide() {
        return toothSide;
    }

    /**
     * Postavlja strana zuba na kojoj se vrši intervencija.
     * @param toothSide Strana zuba na kojoj se vrši intervencija
     */
    @JsonIgnore
    public void setToothSide(ToothSide toothSide) {
        this.toothSide = toothSide;
    }

    /**
     * Vraća novo stanje strane zuba.
     * @return Novo stanje strane zuba
     */
    public ToothSideState getToothSideState() {
        return toothSideState;
    }

    /**
     * Postavlja novo stanje strane zuba.
     * @param toothSideState Novo stanje strane zuba
     */
    public void setToothSideState(ToothSideState toothSideState) {
        this.toothSideState = toothSideState;
    }

    @Override
    public String toString() {
        return "SideIntervention{" + "toothSide=" + toothSide + ", toothSideState=" + toothSideState + '}';
    }
}
