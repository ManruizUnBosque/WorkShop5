package co.edu.unbosque.workshop5.jpa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vet")
@PrimaryKeyJoinColumn
public class Veterinario extends Usuario {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visita> visitas;

    public Veterinario(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "veterinario");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Veterinario() {}

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

    public List<Visita> getVisits() {
        return visitas;
    }

    public void setVisits(List<Visita> visitas) {
        this.visitas = visitas;
    }
}
