package com.miromaric.dentalassistant.model;

import com.miromaric.dentalassistant.model.pk.AppointmentPK;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MikoPC
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
    @Id
    //@GeneratedValue
    private int appointmentID;
    @Id
    @Basic(optional = false)
    @JoinColumn(name = "username",referencedColumnName = "username",updatable = false,insertable = false)
    @ManyToOne(optional = false)
    private User user;
    @Id
    @Basic(optional = false)
    @JoinColumn(name = "patientID",referencedColumnName = "patientID",updatable = false,insertable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(nullable = false)
    private Date endTime;
    private String description;

    public Appointment() {
    }

    public Appointment(int appointmentID,User user, Patient patient, Date startTime, Date endTime, String description) {
        this.appointmentID = appointmentID;
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
    public Appointment(User user, Patient patient, Date startTime, Date endTime, String description) {
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
    

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.appointmentID;
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.patient);
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
        if (this.appointmentID != other.appointmentID) {
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
