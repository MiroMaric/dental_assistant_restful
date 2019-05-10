package com.miromaric.dentalassistant.model.pk;

import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.User;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MikoPC
 */
public class AppointmentPK implements Serializable {
    public int appointmentID;
    private Patient patient;
    private User user;

    public AppointmentPK() {
    }

    public AppointmentPK(int appointmentID, Patient patient, User user) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.user = user;
    }
    
    public AppointmentPK(Patient patient, User user) {
        this.patient = patient;
        this.user = user;
    }
    
    
    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.appointmentID;
        hash = 71 * hash + Objects.hashCode(this.patient);
        hash = 71 * hash + Objects.hashCode(this.user);
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
        final AppointmentPK other = (AppointmentPK) obj;
        if (this.appointmentID != other.appointmentID) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AppointmentPK{" + "appointmentID=" + appointmentID + ", patient=" + patient + ", user=" + user + '}';
    }

}
