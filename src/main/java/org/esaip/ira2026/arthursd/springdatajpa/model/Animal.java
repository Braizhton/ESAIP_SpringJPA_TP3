package org.esaip.ira2026.arthursd.springdatajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    public Animal() {}

    public Animal(Integer id, String color, String name, String sex, Species species) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.sex = sex;
        this.species = species;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    public String toString() {
        return this.getClass().getSimpleName().toUpperCase() + "> " + this.id + " | Name: " + this.name + " | Species: " + this.species.getCommonName();
    }
}