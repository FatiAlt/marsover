package fr.demos.demoJPA.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="livre")
@PrimaryKeyJoinColumn(name="id")

public class Livre extends Article {
    private String titre;
    private String categorie;

    protected Livre() {
    }
    @JoinColumn(name="auteur")
    @ManyToOne()
    private Auteur auteur;


    public Livre(String titre, String categorie) {
        this.titre = titre;
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    @Override
    public String toString() {
        return "Livre{" +
                ", titre='" + titre + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
