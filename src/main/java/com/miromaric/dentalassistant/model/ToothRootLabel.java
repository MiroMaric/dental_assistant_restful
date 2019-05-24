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
 *
 * @author MikoPC
 */
@Entity
@Table(name = "tooth_root_label")
@NamedQueries({
    @NamedQuery(name = "ToothRootLabel.getAll", query = "SELECT trl FROM ToothRootLabel trl"),
    @NamedQuery(name = "ToothRootLabel.getById", query = "SELECT trl FROM ToothRootLabel trl WHERE trl.toothRootLabelID = :id")
})
public class ToothRootLabel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false,length = 5)
    private Long toothRootLabelID;
    
    @Column(nullable = false, length = 20)
    @Basic(optional = false)
    @NotNull(message = "Naziv oznake je obavezan")
    @Size(max = 20,message = "Naziv može imati najviše 20 karaktera")
    private String name;
    
    @Size(max = 255,message = "Opis može imati najviše 255 karaktera")
    private String description;

    public ToothRootLabel() {
    }

    public ToothRootLabel(Long toothRootLabelID, String name, String description) {
        this.toothRootLabelID = toothRootLabelID;
        this.name = name;
        this.description = description;
    }

    public Long getToothRootLabelID() {
        return toothRootLabelID;
    }

    public void setToothRootLabelID(Long toothRootLabelID) {
        this.toothRootLabelID = toothRootLabelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.toothRootLabelID);
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
        final ToothRootLabel other = (ToothRootLabel) obj;
        if (!Objects.equals(this.toothRootLabelID, other.toothRootLabelID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ToothRootLabel{" + "toothRootLabelID=" + toothRootLabelID + ", name=" + name + ", description=" + description + '}';
    }
    
}
