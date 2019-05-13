package com.miromaric.dentalassistant.model.dto;

import com.miromaric.dentalassistant.model.Appointment;
import com.miromaric.dentalassistant.model.Patient;
import com.miromaric.dentalassistant.model.User;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 *
 * @author MikoPC
 */
public class AppointmentReq implements DTO<Appointment>{

    @NotNull(message = "Korisničko ime je obavezno")
    @Size(min = 4,max = 20,message = "Korisničko ime mora imati 4 - 20 karaktera")
    private String username;
    @Positive(message = "Identifikator pacijenta mora biti pozitivna vrednost")
    private int patientID;
    @NotNull(message = "Vreme početka je obavezano")
    private Date startTime;
    @NotNull(message = "Vreme završetka je obavezano")
    private Date endTime;
    private String description;

    public AppointmentReq() {
    }

    public AppointmentReq(String username, int patientID, Date startTime, Date endTime, String description) {
        this.username = username;
        this.patientID = patientID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
    @Override
    public Appointment getModel(){
        return new Appointment(new User(username), new Patient(patientID), startTime, endTime, description);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
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
    public String toString() {
        return "AppointmentReq{" + "username=" + username + ", patientID=" + patientID + ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description + '}';
    }

}
