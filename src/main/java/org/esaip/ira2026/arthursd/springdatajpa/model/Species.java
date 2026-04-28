package org.esaip.ira2026.arthursd.springdatajpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "common_name", nullable = false, length = 64)
    private String commonName;
    @Column(name = "latin_name", nullable = false, length = 64)
    private String latinName;

    @OneToMany(mappedBy = "species")
    private List<Animal> animals = new ArrayList<>();

    public Species() {}

    public Species(Integer id, String commonName, String latinName) {
        this.id = id;
        this.commonName = commonName;
        this.latinName = latinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String common_name) {
        this.commonName = common_name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latin_name) {
        this.latinName = latin_name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String toString() {
        return this.getClass().getSimpleName().toUpperCase() + "> " + this.id + " | Common name: " + this.commonName + " | Latin name: " + this.latinName;
    }
}
