package com.miromaric.dentalassistant.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name="side_intervention")
@NamedQueries({
    @NamedQuery(name = "SideIntervention.getAll", query = "SELECT si FROM SideIntervention si"),
    @NamedQuery(name = "SideIntervention.getById", query = "SELECT si FROM SideIntervention si WHERE si.interventionItemID = :id")
})
public class SideIntervention extends InterventionItem{
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideID",referencedColumnName = "toothSideID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothSide toothSide;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothSideStateID",referencedColumnName = "toothSideStateID")
    @Basic(optional = false)
    private ToothSideState toothSideState;
    
    public SideIntervention() {
        
    }

    public SideIntervention(ToothSide toothSide, ToothSideState toothSideState) {
        this.toothSide = toothSide;
        this.toothSideState = toothSideState;
    }

    public ToothSide getToothSide() {
        return toothSide;
    }

    public void setToothSide(ToothSide toothSide) {
        this.toothSide = toothSide;
    }

    public ToothSideState getToothSideState() {
        return toothSideState;
    }

    public void setToothSideState(ToothSideState toothSideState) {
        this.toothSideState = toothSideState;
    }

    @Override
    public String toString() {
        return "SideIntervention{" + "toothSide=" + toothSide + ", toothSideState=" + toothSideState + '}';
    }
}
