package APIvoitureDeluxe.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import APIvoitureDeluxe.Enum.*;

@Entity
public class Voiture {
    
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nom;

    @Column
    private String immatriculation;

    @Column //Enum
    private Categorie categorie;

    @Column //Enum
    private Marque marque;

    @Column
    private String modele;

    @Column //Enum
    private Couleur couleur;
    
    @Column
    private float prixReservation;

    @Column
    private float prixKm;

    @Column
    private int chevauxFiscaux;

    public Voiture()
    {

    }

    public Voiture (long id, String nom, String immatriculation, Categorie categorie, Marque marque, String modele, Couleur couleur, float prixReservation, float prixKm, int chevauxFiscaux)
    {
        this.id = id;
        this.nom = nom;
        this.immatriculation = immatriculation;
        this.categorie = categorie;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.prixReservation = prixReservation;
        this.prixKm = prixKm;
        this.chevauxFiscaux = chevauxFiscaux;
    }

    public long getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getImmatriculation()
    {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation)
    {
        this.immatriculation = immatriculation;
    }

    public Categorie getCategorie()
    {
        return categorie;
    }

    public void setCategorie(Categorie categorie)
    {
        this.categorie = categorie;
    }

    public Marque getMarque()
    {
        return marque;
    }

    public void setMarque(Marque marque)
    {
        this.marque = marque;
    }

    public String getModele()
    {
        return modele;
    }

    public void setModele(String modele)
    {
        this.modele = modele;
    }

    public Couleur getCouleur()
    {
        return couleur;
    }

    public void setCouleur(Couleur couleur)
    {
        this.couleur = couleur;
    }

    public float getPrixReservation()
    {
        return prixReservation;
    }

    public void setPrixReservation(float prixReservation)
    {
        this.prixReservation = prixReservation;
    }

    public float getPrixKm()
    {
        return prixKm;
    }

    public void setPrixKm(float prixKm)
    {
        this.prixKm = prixKm;
    }

    public int getChevauxFiscaux()
    {
        return chevauxFiscaux;
    }

    public void setChevauxFiscaux(int chevauxFiscaux)
    {
        this.chevauxFiscaux = chevauxFiscaux;
    }
}
