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
 * Klasa predstavlja intervenciju stomatologa.
 *
 * @author Miro Marić
 * @see User
 * @see InterventionItem
 */
@Entity
@Table(name = "intervention")
@NamedQueries({
    @NamedQuery(name = "Intervention.getAll", query = "SELECT a FROM Intervention a"),
    @NamedQuery(name = "Intervention.getById", query = "SELECT a FROM Intervention a WHERE a.interventionID = :id")
})
public class Intervention implements Serializable {

    /**
     * Jedinstveni identifikator intervencije.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Basic(optional = false)
    private Long interventionID;

    /**
     * Vremenski trenutak u kome je obavljena intervencija.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Basic(optional = false)
    private Date date;

    /**
     * Doktor(korisnik sistema) koji je obavio intervenciju.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username")
    @Basic(optional = false)
    private User user;

    /**
     * Stavke intervencije.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private List<InterventionItem> items;

    /**
     * Napomena uz intervenciju.
     */
    private String note;

    public Intervention() {
    }

    /**
     * 
     * @param interventionID Jedinstveni identifikator intervencije
     * @param date Vremenski trenutak u kome je obavljena intervencija
     * @param note Napomena uz intervenciju
     * @param user Doktor(korisnik sistema) koji je obavio intervenciju
     */
    public Intervention(Long interventionID, Date date, String note, User user) {
        this.interventionID = interventionID;
        this.date = date;
        this.note = note;
        this.user = user;
    }

    /**
     * 
     * @param date Vremenski trenutak u kome je obavljena intervencija
     * @param note Napomena uz intervenciju
     * @param user Doktor(korisnik sistema) koji je obavio intervenciju
     */
    public Intervention(Date date, String note, User user) {
        this.date = date;
        this.note = note;
        this.user = user;
    }

    /**
     * Vraća jedinstveni identifikator intervencije.
     *
     * @return Jedinstveni identifikator intervencije
     */
    public Long getInterventionID() {
        return interventionID;
    }

    /**
     * Postvlja jedinstveni identifikator intervencije.
     *
     * @param interventionID Jedinstveni identifikator intervencije
     */
    public void setInterventionID(Long interventionID) {
        this.interventionID = interventionID;
    }

    /**
     * Vraća vremenski trenutak u kome je obavljena intervencija.
     *
     * @return Vremenski trenutak u kome je obavljena intervencija
     */
    public Date getDate() {
        return date;
    }

    /**
     * Postavlja vremenski trenutak u kome je obavljena intervencija.
     *
     * @param date Vremenski trenutak u kome je obavljena intervencija
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Vraća napomenu uz intervenciju.
     * @return Napomena uz intervenciju
     */
    public String getNote() {
        return note;
    }

    /**
     * Postavlja napomenu uz intervenciju.
     * @param note Napomena uz intervenciju
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Vraća doktora(korisnika sistema) koji je obavio intervenciju.
     *
     * @return Doktor(korisnik sistema) koji je obavio intervenciju
     */
    public User getUser() {
        return user;
    }

    /**
     * Postavlja doktora(korisnika sistema) koji je obavio intervenciju.
     *
     * @param user Doktor(korisnik sistema) koji je obavio intervenciju
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Vraća stavke intervencije.
     *
     * @return Stavke intervencije
     */
    public List<InterventionItem> getItems() {
        return items;
    }
    /**
     * Postavlja stavke intervencije.
     *
     * @param items Stavke intervencije
     */
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
