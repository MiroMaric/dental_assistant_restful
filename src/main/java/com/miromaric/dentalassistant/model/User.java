package com.miromaric.dentalassistant.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Klasa predstavlja zubara(korisnika sistema).
 *
 * @author Miro Marić
 * @see Intervention
 * @see Appointment
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.getByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
})
public class User implements Serializable{

    /**
     * Korisničko ime zubara potrebno za autentifikaciju prilikom korišćenja sistema.
     */
    @Id
    @Basic(optional = false)
    @Column(nullable = false,length = 20)
    @NotNull(message = "Korisničko ime je obavezno")
    @Size(min = 4,max = 20,message = "Korisničko ime mora imati 4 - 20 karaktera")
    private String username;
    
    /**
     * Šifra zubara potrebna za autentifikaciju prilikom korišćenja sistema.
     */
    @Basic(optional = false)
    @Column(nullable = false,length = 20)
    @NotNull(message = "Šifra je obavezna")
    @Size(min = 6,max = 20,message = "Šifra mora imati 6-20 karaktera")
    private String password;
    
    /**
     * Email adresa zubara.
     */
    @Basic(optional = false)
    @Column(nullable = false)
    @NotNull(message = "E-pošta je obavezna")
    @Email(message = "E-pošta mora biti valida, e.g. me@mydomain.com")
    private String email;
    
    /**
     * Ime zubara.
     */
    @Basic(optional = false)
    @Column(nullable = false,length = 15)
    @NotNull(message = "Ime je obavezno")
    @Size(min=2,max=15,message = "Ime mora imati 2 - 15 karaktera")
    private String firstname;
    
    /**
     * Prezime zubara.
     */
    @Basic(optional = false)
    @Column(nullable = false,length = 15)
    @Size(min=2,max=15,message = "Prezime mora imati 2 - 15 karaktera")
    @NotNull(message = "Prezime je obavezno")
    private String lastname;
    
    /**
     * Adresa na kojoj zubar stanuje.
     */
    @Column(length = 20)
    @Size(min=4,max=20,message = "Adresa mora imati 4 - 20 karaktera")
    private String address;
    
    /**
     * Telefon zubara.
     */
    @Column(length = 15)
    @Size(min=10,max=10,message = "Telefon mora biti unet u ispravnom formatu")
    private String phone;

    public User() {
    }
    
    /**
     * 
     * @param username Korisničko ime zubara
     */
    public User(String username) {
        this.username = username;
    }

    /**
     * 
     * @param username Korisničko ime zubara
     * @param password Šifra zubara
     * @param email Email adresa zubara
     * @param firstname Ime zubara
     * @param lastname Prezime zubara
     * @param address Adresa na kojoj zubar stanuje
     * @param phone Telefon zubara
     */
    public User(String username, String password, String email, String firstname, String lastname, String address, String phone) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Vraća korisničko ime zubara.
     * @return Korisničko ime zubara
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja korisničko ime zubara.
     * @param username Korisničko ime zubara
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Vraća šifru zubara.
     * @return Šifra zubara
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja šifru zubara.
     * @param password Šifra zubara
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Vraća ime zubara.
     * @return Ime zubara
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja ime zubara.
     * @param firstname Ime zubara
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Vraća prezime zubara.
     * @return Prezime zubara
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlja prezime zubara.
     * @param lastname Prezime zubara
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Vraća email adresu zubara.
     * @return Email adresa zubara
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email adresu zubara.
     * @param email Email adresa zubara
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraća adresu na kojoj zubar stanuje.
     * @return Adresa na kojoj zubar stanuje
     */
    public String getAddress() {
        return address;
    }

    /**
     * Postavlja adresu na kojoj zubar stanuje.
     * @param address Adresa na kojoj zubar stanuje
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Vraća broj telefona zubara.
     * @return Telefon zubara
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Postavlja broj telefona zubara.
     * @param phone Telefon zubara
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.username);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + '}';
    }

}
