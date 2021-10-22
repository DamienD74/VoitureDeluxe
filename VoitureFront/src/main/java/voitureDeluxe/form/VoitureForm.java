package voitureDeluxe.form;

import voitureDeluxe.Enum.*;

public class VoitureForm {
    
    private long id;

    private String nom;

    private String immatriculation;

    //Enum
    private Categorie categorie;

    //Enum
    private Marque marque;

    private String modele;

    //Enum
    private Couleur couleur;
    
    private float prixReservation;

    private float prixKm;

    private int chevauxFiscaux;

    public VoitureForm()
    {

    }

    public VoitureForm(long id, String nom, String immatriculation, Categorie categorie, Marque marque, String modele, Couleur couleur, float prixReservation, float prixKm, int chevauxFiscaux)
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
