package com.miromaric.dentalassistant.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.miromaric.dentalassistant.model.json_view.JsonViews;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Klasa predstavlja pacijenta stomatološke ordinacije.
 *
 * @author Miro Marić
 * @see Tooth
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Patient.getAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.getById", query = "SELECT p FROM Patient p WHERE p.patientID = :id")
})
@JsonView(JsonViews.Flat.class)
public class Patient implements Serializable {

    /**
     * Jedinstveni identifikator pacijenta.
     */
    @Id
    @Column(nullable = false)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;
    /**
     * Ime pacijenta.
     */
    @Column(nullable = false,length = 15)
    @Basic(optional = false)
    @NotNull(message = "Ime je obavezno")
    @Size(min=2,max=15,message = "Ime mora imati 2 - 15 karaktera")
    private String firstname;
    /**
     * Prezime pacijenta.
     */
    @Column(nullable = false,length = 15)
    @Basic(optional = false)
    @Size(min=2,max=15,message = "Prezime mora imati 2 - 15 karaktera")
    @NotNull(message = "Prezime je obavezno")
    private String lastname;
    
    /**
     * Email adresa pacijenta.
     */
    @Email(message = "E-pošta mora biti valida, e.g. me@mydomain.com")
    private String email;
    
    /**
     * Adresa na kojoj stanuje pacijent.
     */
    @Column(length = 20)
    @Size(min=4,max=20,message = "Adresa mora imati 4 - 20 karaktera")
    private String address;
    /**
     * Pacijentov broj telefona.
     */
    @Column(length = 15)
    @Size(min=10,max=10,message = "Telefon mora biti unet u ispravnom formatu")
    private String phone;
    
    /**
     * Datum rodjenja pacijenta.
     */
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    /**
     * Datum otvaranja kartona.
     */
    @Column(nullable = false)
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Datum kreiranja kartona je obavezan")
    private Date cardboardDate;
    
    /**
     * Status kartona(aktiviran, deaktiviran).
     */
    @Column(nullable = false)
    @Basic(optional = false)
    @NotNull(message = "Status kartona je obavezan")
    private boolean deactivated;
    /**
     * Zubi pacijenta
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient",fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonView(JsonViews.Deep.class)
    private List<Tooth> teeth;

    public Patient() {
    }
    
    /**
     * 
     * @param patientID Jedinstveni identifikator pacijenta
     */
    public Patient(Long patientID) {
        this.patientID = patientID;
    }

    /**
     * 
     * @param patientID Jedinstveni identifikator pacijenta
     * @param firstname Ime pacijenta
     * @param lastname Prezime pacijenta
     * @param email Email adresa pacijenta
     * @param address Adresa na kojoj stanuje pacijent
     * @param phone Pacijentov broj telefon
     * @param birthDate Datum rodjenja pacijenta
     * @param cardboardDate Datum otvaranja kartona
     * @param deactivated Status kartona(aktiviran, deaktiviran)
     * @param teeth Zubi pacijenta
     */
    public Patient(Long patientID, String firstname, String lastname, String email, String address, String phone, Date birthDate, Date cardboardDate, boolean deactivated, List<Tooth> teeth) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.cardboardDate = cardboardDate;
        this.deactivated = deactivated;
        this.teeth = teeth;
    }
    
    /**
     * 
     * @param firstname Ime pacijenta
     * @param lastname Prezime pacijenta
     * @param email Email adresa pacijenta
     * @param address Adresa na kojoj stanuje pacijent
     * @param phone Pacijentov broj telefona
     * @param birthDate Datum rodjenja pacijenta
     * @param cardboardDate Datum otvaranja kartona
     * @param deactivated Status kartona(aktiviran, deaktiviran)
     */
    public Patient(String firstname, String lastname, String email, String address, String phone, Date birthDate, Date cardboardDate, boolean deactivated) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.cardboardDate = cardboardDate;
        this.deactivated = deactivated;
    }

    /**
     * Vraća jedinstveni identifikator pacijenta.
     * @return Jedinstveni identifikator pacijenta
     */
    public Long getPatientID() {
        return patientID;
    }

    /**
     * Postavlja jedinstveni identifikator pacijenta.
     * @param patientID Jedinstveni identifikator pacijenta
     */
    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    /**
     * Vraća ime pacijenta.
     * @return Ime pacijenta
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja ime pacijenta.
     * @param firstname Ime pacijenta
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Vraća prezime pacijenta.
     * @return Prezime pacijenta
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlja prezime pacijenta.
     * @param lastname Prezime pacijenta
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Vraća email adresu pacijenta.
     * @return Email adresa pacijenta
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email adresu pacijenta.
     * @param email Email adresa pacijenta
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraća adresu na kojoj stanuje pacijent.
     * @return Adresa na kojoj stanuje pacijent
     */
    public String getAddress() {
        return address;
    }

    /**
     * Postavlja adresu na kojoj stanuje pacijent.
     * @param address Adresa na kojoj stanuje pacijent
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Vraća pacijentov broj telefona.
     * @return Pacijentov broj telefona
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Postavlja pacijentov broj telefona.
     * @param phone Pacijentov broj telefona
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Vraća datum rodjenja pacijenta.
     * @return Datum rodjenja pacijenta
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Postavlja datum rodjenja pacijenta.
     * @param birthDate Datum rodjenja pacijenta
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Vraća datum otvaranja kartona.
     * @return Datum otvaranja kartona
     */
    public Date getCardboardDate() {
        return cardboardDate;
    }

    /**
     * Postavlja datum otvaranja kartona.
     * @param cardboardDate Datum otvaranja kartona
     */
    public void setCardboardDate(Date cardboardDate) {
        this.cardboardDate = cardboardDate;
    }

    /**
     * Vraća status kartona.
     * @return Status kartona
     */
    public boolean isDeactivated() {
        return deactivated;
    }

    /**
     * Postavlja status kartona.
     * @param deactivated Status kartona
     */
    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    /**
     * Vraća zube pacijenta.
     * @return Zubi pacijenta
     */
    public List<Tooth> getTeeth() {
        return teeth;
    }

    /**
     * Postavlja zube pacijenta.
     * @param teeth Zubi pacijenta
     */
    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
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
