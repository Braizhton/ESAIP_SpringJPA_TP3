package org.esaip.ira2026.arthursd.springdatajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SPECIES")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(64)", nullable = false)
    private String common_name;
    @Column(columnDefinition = "varchar(64)", nullable = false)
    private String latin_name;

    public Species() {

    }

    public Species(Integer id, String common_name, String latin_name) {
        this.id = id;
        this.common_name = common_name;
        this.latin_name = latin_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }

    public String toString() {
        return "Specie ID: " + this.id + "\n    Common name:" + this.common_name + "\n    Latin name:" + this.latin_name;
    }
}
