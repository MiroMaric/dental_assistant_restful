package com.miromaric.dentalassistant.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author MikoPC
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
    ,
    @NamedQuery(name = "User.getByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
})
public class User {

    @Id
    @Pattern(regexp = "^((\\w){4,20})$",message = "Korisničko ime mora imati 4 - 20 karaktera")
    private String username;
    @NotNull
    @Pattern(regexp = "^((\\w){6,20})$",message = "Šifra mora imati 6-20 karaktera")
    private String password;
    @NotNull
    @Pattern(regexp = "^(([a-zA-Z\\d_\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?)$",message = "E-pošta mora biti valida, e.g. me@mydomain.com")
    private String email;
    @NotNull
    @Pattern(regexp = "^(([A-Za-z]){2,15})$",message = "Ime mora imati 2 - 15 karaktera")
    private String firstname;
    @NotNull
    @Pattern(regexp = "^(([A-Za-z]){2,15})$",message = "Prezime mora imati 2 - 15 karaktera")
    private String lastname;
    @Pattern(regexp = "^(([\\w, ]){4,20})$",message = "Adresa mora imati 4 - 20 karaktera")
    private String address;
    @Pattern(regexp = "^((\\d){7,10})$",message = "Telefon mora biti unet u ispravnom formatu")
    private String phone;

    public User() {
    }

    public User(String username, String password, String email, String firstname, String lastname, String address, String phone) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
