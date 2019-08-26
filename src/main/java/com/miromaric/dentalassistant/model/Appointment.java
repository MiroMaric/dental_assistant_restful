package com.miromaric.dentalassistant.model;

import com.miromaric.dentalassistant.model.pk.AppointmentPK;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Klasa predstavlja zakazan termin kod stomatologa
 *
 * @author Miro Marić
 * @see Patient
 * @see User
 */
@Entity
@IdClass(AppointmentPK.class)
@NamedQueries({
    @NamedQuery(name = "Appointment.getAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.getById", query = "SELECT a FROM Appointment a WHERE a.appointmentID = :appointmentID")
})
public class Appointment implements Serializable {

    /*
    Problem za generesinjem tabele u bazi zbog @GenerateValue!
    Ovde baca exception prilikom ubacivanja novog entiteta u bazu.
    Privremeno resen problem u metodi save
     */
    /**
     * Jedinstveni identifikator zakazanog termina.
     */
    @Id
    //(odkomentarisati prilikom kreiranja seme baze podataka)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;
    /**
     * Doktor(korisnik sistema) kod koga je pacijent rezervisao termin.
     */
    @Id
    @Basic(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username", updatable = false, insertable = false)
    @ManyToOne(optional = false)
    private User user;
    /**
     * Pacijent koji je rezervisao termin.
     */
    @Id
    @Basic(optional = false)
    @JoinColumn(name = "patientID", referencedColumnName = "patientID", updatable = false, insertable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    /**
     * Vremenski trenutak u kome počinje zakazani termin.
     */
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    /**
     * Vremenski trenutak u kome se završava zakazani termin.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(nullable = false)
    private Date endTime;
    /**
     * Napomena uz zakazani termin.
     */
    private String description;

    public Appointment() {
    }

    /**
     *
     * @param appointmentID Jedinstveni identifikator zakazanog termina
     * @param user Doktor(korisnik sistema) kod koga je pacijent rezervisao
     * termin
     * @param patient Pacijent koji je rezervisao termin
     * @param startTime Vremenski trenutak u kome počinje zakazani termin
     * @param endTime Vremenski trenutak u kome se završava zakazani termin
     * @param description Napomena uz zakazani termin
     */
    public Appointment(Long appointmentID, User user, Patient patient, Date startTime, Date endTime, String description) {
        this.appointmentID = appointmentID;
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    /**
     *
     * @param user Doktor(korisnik sistema) kod koga je pacijent rezervisao
     * termin
     * @param patient Pacijent koji je rezervisao termin
     * @param startTime Vremenski trenutak u kome počinje zakazani termin
     * @param endTime Vremenski trenutak u kome se završava zakazani termin
     * @param description Napomena uz zakazani termin
     */
    public Appointment(User user, Patient patient, Date startTime, Date endTime, String description) {
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    /**
     * Vraća identifikator zakazanog termina.
     * @return Identifikator zakazanog termina
     */
    public Long getAppointmentID() {
        return appointmentID;
    }

    
    /**
     * Postavlja identifikator zakazanog termina.
     * @param appointmentID Identifikator zakazanog termina
     */
    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * Vraća doktora(korisnik sistema) kod koga je pacijent rezervisao termin.
     * @return Doktor(korisnik sistema) kod koga je pacijent rezervisao termin
     */
    public User getUser() {
        return user;
    }

    /**
     * Postavlja doktora(korisnika sistema) kod koga je pacijent rezervisao
     * termin.
     * @param user Doktor(korisnik sistem) kod koga je pacijent rezervisao
     * termin
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Vraća pacijenta koji je rezervisao termin.
     * @return Pacijent koji je rezervisao termin
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Postvlja pacijenta koji je rezervisao termin.
     * @param patient Pacijent koji je rezervisao termin
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Vraća vremenski trenutak u kome počinje zakazani termin.
     * @return Vremenski trenutak u kome počinje zakazani termin
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Postavlja vremenski trenutak u kome počinje zakazani termin.
     * @param startTime Vremenski trenutak u kome počinje zakazani termin
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Vraća vremenski trenutak u kome se završava zakazani termin.
     * @return Vremenski trenutak u kome se završava zakazani termin
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Postavlja vremenski trenutak u kome se završava zakazani termin.
     * @param endTime Vremenski trenutak u kome se završava zakazani termin
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Vraća napomenu uz zakazani termin.
     * @return Napomena uz zakazani termin
     */
    public String getDescription() {
        return description;
    }

    /**
     * Postavlja napomenu uz zakazani termin.
     * @param description Napomena uz zakazani termin
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.appointmentID);
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + Objects.hashCode(this.patient);
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
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.appointmentID, other.appointmentID)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentID=" + appointmentID + ", user=" + user + ", patient=" + patient + '}';
    }

}
