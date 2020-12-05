package fr.catalogue.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(schema = "catalogue")
public class Panier implements Serializable {

    private static final long serialVersionUID = 2214863106348453650L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @OneToOne
    private Client client;

    @OneToMany
    private Collection<Produit> produits;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
}
