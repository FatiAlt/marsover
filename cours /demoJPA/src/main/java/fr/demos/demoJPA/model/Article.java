package fr.demos.demoJPA.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name = "article")
@Inheritance(strategy=InheritanceType.JOINED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;


    private String ref;
    private String designation;
    private double prixHT;
    private double tva = 0.2;



    protected Article() {
    }

    public Article(String ref, String designation, double prixHT) { //constructor
        this.ref = ref;
        this.designation = designation;
        this.prixHT = prixHT;
    }

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getDesignation() { //get et set permet de modifier les var
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixHT() {//method
        return prixHT;
    }

    public double getPrixTTC() {
        return prixHT * (1 + tva);
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", designation='" + designation + '\'' +
                ", prixHT=" + prixHT +
                ", tva=" + tva +
                '}';
    }
}


