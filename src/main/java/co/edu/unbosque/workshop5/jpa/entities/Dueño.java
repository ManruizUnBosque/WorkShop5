package co.edu.unbosque.workshop5.jpa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dueño")
@PrimaryKeyJoinColumn
public class Dueño extends Usuario {

    @Column(name = "person_id", unique = true, nullable = false, updatable = false)
    @GeneratedValue
    private Long personId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "dueño", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Pet> pets;

    public Dueño(String username, String password, String email, Long personId, String name, String address, String neighborhood) {
        super(username, password, email, "dueño");
        this.personId = personId;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Dueño() {}

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Mascota> getPets() {
        return Mascotas;
    }

    public void setPets(List<Mascota> pets) {
        this.mascotas = mascotas;
    }
}
