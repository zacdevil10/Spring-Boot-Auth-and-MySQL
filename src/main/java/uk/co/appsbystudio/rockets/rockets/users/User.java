package uk.co.appsbystudio.rockets.rockets.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @JsonProperty(value = "username")
    @Column(name = "username")
    @NotEmpty(message = "Please provide a valid username")
    private String name;

    @Column(name = "email")
    @JsonProperty(value = "email")
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Column(name = "pass_hash")
    @JsonProperty(value = "pass_hash")
    @Length(min = 6, message = "Your password must have at least 6 characters")
    @NotEmpty(message = "Please provide a password")
    private String password;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;

    @Column(name = "modified")
    private String modified;

    @Column(name = "pic_uri")
    private String pictureUri;

    @Column(name = "find_by_email")
    private int findByEmail;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUrl) {
        this.pictureUri = pictureUrl;
    }

    public int getFindByEmail() {
        return findByEmail;
    }

    public void setFindByEmail(int findByEmail) {
        this.findByEmail = findByEmail;
    }
}
