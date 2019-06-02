package com.miromaric.dentalassistant.model;

import java.io.Serializable;
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
@Table(name="tooth_intervention")
@NamedQueries({
    @NamedQuery(name = "ToothIntervention.getAll", query = "SELECT ti FROM ToothIntervention ti"),
    @NamedQuery(name = "ToothIntervention.getById", query = "SELECT ti FROM ToothIntervention ti WHERE ti.interventionItemID = :id")
})
public class ToothIntervention extends InterventionItem implements Serializable{
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID",insertable = false,updatable = false)
    @Basic(optional = false)
    private Tooth tooth;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothStateID",referencedColumnName = "toothStateID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothState toothState;

    public ToothIntervention() {
    }

    public ToothIntervention(Tooth tooth, ToothState toothState) {
        this.tooth = tooth;
        this.toothState = toothState;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public ToothState getToothState() {
        return toothState;
    }

    public void setToothState(ToothState toothState) {
        this.toothState = toothState;
    }

    @Override
    public String toString() {
        return "ToothIntervention{" + "tooth=" + tooth + ", toothState=" + toothState + '}';
    }
    
}
