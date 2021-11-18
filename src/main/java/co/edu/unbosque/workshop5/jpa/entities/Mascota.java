package co.edu.unbosque.workshop5.jpa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Mascota")
public class Mascota {
    @Id
    @Column(name = "Mascota_id")
    private Integer petId;

    @Column(unique = true)
    private String microchip;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String sex;

    @Column
    private String picture;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Dueño dueño;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Caso_mascota> Caso_mascotas;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Visita> visitas;

    public Mascota() {}

    public Mascota(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture) {
        this.petId = petId;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Mascota(Integer petId, String microchip, String name, String species, String race, String size, String sex, String picture, Owner owner) {
        this.petId = petId;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.dueño = dueño;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner() {
        return Dueño;
    }

    public void setOwner(Dueño dueño) {
        this.dueño = dueño;
    }

    public List<Caso_mascota> getPetCases() {
        return Caso_mascotas;
    }

    public void setPetCases(List<Caso_mascota> Caso_mascota) {
        this.Caso_mascotas = Caso_mascota;
    }

    public List<Visita> getVisits() {
        return visitas;
    }

    public void setVisits(List<Visita> visits) {
        this.visitas = visits;
    }
}
