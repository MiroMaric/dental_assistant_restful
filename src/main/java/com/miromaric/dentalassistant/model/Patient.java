package com.miromaric.dentalassistant.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MikoPC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.getAll", query = "SELECT p FROM Patient p")
    ,
    @NamedQuery(name = "Patient.getById", query = "SELECT p FROM Patient u WHERE p.id = :id")
})
public class Patient implements Serializable {

    @Id
    @Column(nullable = false)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientID;
    @Column(nullable = false,length = 15)
    @Basic(optional = false)
    @Pattern(regexp = "^(([A-Za-z]){2,15})$", message = "Ime mora imati 2 - 15 karaktera")
    private String firstname;
    @Column(nullable = false,length = 15)
    @Basic(optional = false)
    @Pattern(regexp = "^(([A-Za-z]){2,15})$", message = "Prezime mora imati 2 - 15 karaktera")
    private String lastname;
    @Pattern(regexp = "^(([a-zA-Z\\d_\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?)$", message = "E-pošta mora biti valida, e.g. me@mydomain.com")
    private String email;
    @Column(length = 20)
    @Pattern(regexp = "^(([\\w, ]){4,20})$", message = "Adresa mora imati 4 - 20 karaktera")
    private String address;
    @Column(length = 15)
    @Pattern(regexp = "^((\\d){7,15})$", message = "Telefon mora biti unet u ispravnom formatu")
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(nullable = false)
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date cardboardDate;
    @Column(nullable = false)
    @Basic(optional = false)
    private boolean deactivated;

    public Patient() {
    }

    public Patient(int patientID, String firstname, String lastname, String email, String address, String phone, Date birthDate, Date cardboardDate, boolean deactivated) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.cardboardDate = cardboardDate;
        this.deactivated = deactivated;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCardboardDate() {
        return cardboardDate;
    }

    public void setCardboardDate(Date cardboardDate) {
        this.cardboardDate = cardboardDate;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.patientID);
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
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientID=" + patientID + '}';
    }

}
