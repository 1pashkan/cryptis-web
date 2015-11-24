package ru.cryptis.web.subscribe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {
    @Id
    @Column(unique = true)
    private String email;

    public Subscription() {
    }

    public Subscription(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "email='" + email + '\'' +
                '}';
    }
}
