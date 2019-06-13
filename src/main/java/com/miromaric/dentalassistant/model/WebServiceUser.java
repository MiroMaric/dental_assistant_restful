package com.miromaric.dentalassistant.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "service_user")
@NamedQueries({
    @NamedQuery(name = "WebServiceUser.getAll", query = "SELECT u FROM WebServiceUser u"),
    @NamedQuery(name = "WebServiceUser.getByUsername", query = "SELECT u FROM WebServiceUser u WHERE u.username = :username")
})
public class WebServiceUser implements Serializable{
    
    @Id
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public WebServiceUser() {
    }

    public WebServiceUser(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.password);
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
        final WebServiceUser other = (WebServiceUser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    
}
