package uk.co.appsbystudio.rockets.rockets.rockets;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rocket")
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Please provide a valid name")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "Please provide a valid description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
