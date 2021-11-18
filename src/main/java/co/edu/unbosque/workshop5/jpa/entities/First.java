package co.edu.unbosque.workshop5.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "First")
@PrimaryKeyJoinColumn
public class First extends Usuario {

    @Column(nullable = false)
    private String name;

    public First(String username, String password, String email, String name) {
        super(username, password, email, "first");
        this.name = name;
    }

    public First() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
