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
 * Klasa predstavlja intervenciju na korenu zuba.
 *
 * @author Miro Marić
 * @see InterventionItem
 * @see ToothRoot
 * @see ToothRootState
 *
 */
@Entity
@Table(name = "root_intervention")
@NamedQueries({
    @NamedQuery(name = "RootIntervention.getAll", query = "SELECT ri FROM SideIntervention ri"),
    @NamedQuery(name = "RootIntervention.getById", query = "SELECT ri FROM RootIntervention ri WHERE ri.interventionItemID = :id")
})
public class RootIntervention extends InterventionItem {

    /**
     * Koren zuba na kome se vrši intervencija.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootID", referencedColumnName = "toothRootID")
    @Basic(optional = false)
    private ToothRoot toothRoot;

    /**
     * Novo stanje korena.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootStateID", referencedColumnName = "toothRootStateID")
    @Basic(optional = false)
    private ToothRootState toothRootState;

    public RootIntervention() {
    }

    /**
     *
     * @param toothRoot Koren zuba na kome se vrši intervencija
     * @param toothRootState Novo stanje korena
     * @param itemID Jedinstveni identifikator stavke intervencije
     * @param intervention Intervencija
     * @param note Opis stavke
     */
    public RootIntervention(ToothRoot toothRoot, ToothRootState toothRootState, Long itemID, Intervention intervention, String note) {
        super(itemID, intervention, note);
        this.toothRoot = toothRoot;
        this.toothRootState = toothRootState;
    }

    /**
     * Vraća koren zuba na kome se vrši intervencija.
     *
     * @return Koren zuba na kome se vrši intervencija
     */
    public ToothRoot getToothRoot() {
        return toothRoot;
    }

    /**
     * Postavlja koren zuba na kome se vrši intervencija.
     *
     * @param toothRoot Koren zuba na kome se vrši intervencija
     */
    @JsonIgnore
    public void setToothRoot(ToothRoot toothRoot) {
        this.toothRoot = toothRoot;
    }

    /**
     * Vraća novo stanje korena.
     *
     * @return Novo stanje korena
     */
    public ToothRootState getToothRootState() {
        return toothRootState;
    }

    /**
     * Postavlja novo stanje korena.
     *
     * @param toothRootState Novo stanje korena
     */
    public void setToothRootState(ToothRootState toothRootState) {
        this.toothRootState = toothRootState;
    }

    @Override
    public String toString() {
        return "RootIntervention{" + "toothRoot=" + toothRoot + ", toothRootState=" + toothRootState + '}';
    }
}
