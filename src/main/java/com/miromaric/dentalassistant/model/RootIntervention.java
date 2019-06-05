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
 *
 * @author MikoPC
 */
@Entity
@Table(name="root_intervention")
@NamedQueries({
    @NamedQuery(name = "RootIntervention.getAll", query = "SELECT ri FROM SideIntervention ri"),
    @NamedQuery(name = "RootIntervention.getById", query = "SELECT ri FROM RootIntervention ri WHERE ri.interventionItemID = :id")
})
public class RootIntervention extends InterventionItem{
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootID",referencedColumnName = "toothRootID",insertable = false,updatable = false)
    @Basic(optional = false)
    private ToothRoot toothRoot;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootStateID",referencedColumnName = "toothRootStateID")
    @Basic(optional = false)
    private ToothRootState toothRootState;

    public RootIntervention() {
    }

    public RootIntervention(ToothRoot toothRoot, ToothRootState toothRootState, Long itemID, Intervention intervention, String note) {
        super(itemID, intervention, note);
        this.toothRoot = toothRoot;
        this.toothRootState = toothRootState;
    }
    
    public ToothRoot getToothRoot() {
        return toothRoot;
    }

    @JsonIgnore
    public void setToothRoot(ToothRoot toothRoot) {
        this.toothRoot = toothRoot;
    }
    
    public ToothRootState getToothRootState() {
        return toothRootState;
    }

    public void setToothRootState(ToothRootState toothRootState) {
        this.toothRootState = toothRootState;
    }

    @Override
    public String toString() {
        return "RootIntervention{" + "toothRoot=" + toothRoot + ", toothRootState=" + toothRootState + '}';
    }
}
