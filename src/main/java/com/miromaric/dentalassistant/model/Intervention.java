package com.miromaric.dentalassistant.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "intervention")
@NamedQueries({
    @NamedQuery(name = "Intervention.getAll", query = "SELECT a FROM Intervention a"),
    @NamedQuery(name = "Intervention.getById", query = "SELECT a FROM Intervention a WHERE a.interventionID = :id")
})
public class Intervention implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Basic(optional = false)
    private Long interventionID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Basic(optional = false)
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username")
    @Basic(optional = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private List<InterventionItem> items;
    
    private String note;

    public Intervention() {
    }

    public Intervention(Long interventionID, Date date, String note, User user) {
        this.interventionID = interventionID;
        this.date = date;
        this.note = note;
        this.user = user;
    }

    public Intervention(Date date, String note, User user) {
        this.date = date;
        this.note = note;
        this.user = user;
    }

    public Long getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(Long interventionID) {
        this.interventionID = interventionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<InterventionItem> getItems() {
        return items;
    }

    public void setItems(List<InterventionItem> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.interventionID);
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
        final Intervention other = (Intervention) obj;
        return Objects.equals(this.interventionID, other.interventionID);
    }

    @Override
    public String toString() {
        return "Intervention{" + "interventionID=" + interventionID + ", date=" + date + ", note=" + note + ", user=" + user + '}';
    }

}
