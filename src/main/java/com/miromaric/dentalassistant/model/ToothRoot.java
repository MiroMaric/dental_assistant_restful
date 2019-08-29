package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Klasa predstavlja koren zuba.
 *
 * @author Miro Marić
 * @see Tooth
 * @see ToothRootLabel
 * @see RootIntervention
 * 
 */
@Entity
@Table(name = "tooth_root")
@NamedQueries({
    @NamedQuery(name = "ToothRoot.getAll", query = "SELECT tr FROM ToothRoot tr"),
    @NamedQuery(name = "ToothRoot.getById", query = "SELECT tr FROM ToothRoot tr WHERE tr.toothRootID = :id")
})
public class ToothRoot implements Serializable{
    /**
     * Jedinstveni identifikator korena zuba.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long toothRootID;
    
    /**
     * Zub pacijenta
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothID",referencedColumnName = "toothID")
    @Basic(optional = false)
    private Tooth tooth;
    
    /**
     * Oznaka korena
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "toothRootLabelID",referencedColumnName = "toothRootLabelID")
    @Basic(optional = false)
    private ToothRootLabel rootLabel;
    
    /**
     * Intervencije na korenu.
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "toothRoot",fetch = FetchType.LAZY)
    @Basic(optional = false)
    private List<RootIntervention> rootInterventions;

    public ToothRoot() {
    }

    /**
     * 
     * @param toothRootID Jedinstveni identifikator korena
     * @param tooth Zub pacijenta
     * @param rootLabel Oznaka korena
     * @param rootInterventions Intervencije na korenu
     */
    public ToothRoot(Long toothRootID, Tooth tooth, ToothRootLabel rootLabel, List<RootIntervention> rootInterventions) {
        this.toothRootID = toothRootID;
        this.tooth = tooth;
        this.rootLabel = rootLabel;
        this.rootInterventions = rootInterventions;
    }

    /**
     * Vraća intervencije na korenu.
     * @return Intervencije na korenu
     */
    public List<RootIntervention> getRootInterventions() {
        return rootInterventions;
    }

    /**
     * Vraća oznaka korena.
     * @return Oznaka korena
     */
    public ToothRootLabel getRootLabel() {
        return rootLabel;
    }

    /**
     * Vraća zub pacijenta.
     * @return Zub pacijenta.
     */
    public Tooth getTooth() {
        return tooth;
    }

    /**
     * Vraća jedinstveni identifikator korena.
     * @return Jedinstveni identifikator korena
     */
    public Long getToothRootID() {
        return toothRootID;
    }

    /**
     * Postavlja intervencije na korenu.
     * @param rootInterventions Intervencije na korenu
     */
    public void setRootInterventions(List<RootIntervention> rootInterventions) {
        this.rootInterventions = rootInterventions;
    }

    /**
     * Postavlja oznaka korena.
     * @param rootLabel Oznaka korena
     */
    public void setRootLabel(ToothRootLabel rootLabel) {
        this.rootLabel = rootLabel;
    }

    /**
     * Postavlja zub pacijenta.
     * @param tooth Zub pacijenta
     */
    @JsonIgnore
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    /**
     * Postavlja jedinstveni identifikator korena.
     * @param toothRootID Jedinstveni identifikator korena.
     */
    public void setToothRootID(Long toothRootID) {
        this.toothRootID = toothRootID;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.toothRootID);
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
        final ToothRoot other = (ToothRoot) obj;
        return Objects.equals(this.toothRootID, other.toothRootID);
    }

    @Override
    public String toString() {
        return "ToothRoot{" + "toothRootID=" + toothRootID + ", tooth=" + tooth + ", rootLabel=" + rootLabel + '}';
    }
    
}
