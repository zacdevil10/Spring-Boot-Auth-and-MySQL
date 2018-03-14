package uk.co.appsbystudio.rockets.rockets.users;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Please provide a valid name")
    private String name;

    @Column(name = "email")
    @Email
    @NotEmpty(message = "Please provide a valid email")
    private String email;

    @Column(name = "password")
    @Length(min = 6, message = "Your password must have at least 6 characters")
    @NotEmpty(message = "Please provide a password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
