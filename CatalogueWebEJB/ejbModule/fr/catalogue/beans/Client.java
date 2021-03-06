package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(schema = "catalogue")
public class Client implements Serializable {

    private static final long serialVersionUID = 570269912778275353L;

    public Client() {
        super();
    }

    public Client(String nom, String email, String adresse, String telephone) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;


    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String adresse;

    @OneToMany
    private Collection<Commande> commandes;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
}
