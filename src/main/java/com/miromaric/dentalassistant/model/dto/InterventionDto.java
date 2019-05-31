package com.miromaric.dentalassistant.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MikoPC
 */
public class InterventionDto implements Serializable{

    @NotNull(message = "Korisničko ime je obavezno")
    @Size(min = 4,max = 20,message = "Korisničko ime mora imati 4 - 20 karaktera")
    private String username;
    
    @NotNull(message = "Vreme intervencije je obavezano")
    private Date date;
    
    private String note;

    public InterventionDto() {
    }

    public InterventionDto(String username, Date date, String note) {
        this.username = username;
        this.date = date;
        this.note = note;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.note);
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
        final InterventionDto other = (InterventionDto) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "InterventionDto{" + "username=" + username + ", date=" + date + ", note=" + note + '}';
    }
}
