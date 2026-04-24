package org.esaip.ira2026.arthursd.springdatajpa.model;

import jakarta.persistence.*;

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

    public Species() {

    }

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

    public String toString() {
        return "Specie ID: " + this.id + "\n    Common name:" + this.commonName + "\n    Latin name:" + this.latinName;
    }
}
