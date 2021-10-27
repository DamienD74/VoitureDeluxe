package APIvoitureDeluxe.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
    
    @Id
    @GeneratedValue
    private long id;

    @Column
    private Date date_de_debut;

    @Column
    private Date date_de_fin;

    @Column
    private int id_client;

    @Column
    private int id_voiture;

    @Column
    private int estimationKm;

    @Column
    private int nombre_km_depart;

    public Location()
    {

    }

    public Location(long id, Date date_de_debut, Date date_de_fin, int id_client, int id_voiture, int estimationKm, int nombre_km_depart)
    {
        this.id = id;
        this.date_de_debut = date_de_debut;
        this.date_de_fin = date_de_fin;
        this.id_client = id_client;
        this.id_voiture = id_voiture;
        this.estimationKm = estimationKm;
        this.nombre_km_depart = nombre_km_depart;
    }

    public long getId()
    {
        return id;
    }

    public Date getDateDeDebut()
    {
        return date_de_debut;
    }

    public void setDateDeDebut(Date date_de_debut)
    {
        this.date_de_debut = date_de_debut;
    }

    public Date getDateDeFin()
    {
        return date_de_fin;
    }

    public void setDateDeFin(Date date_de_fin)
    {
        this.date_de_fin = date_de_fin;
    }

    public int getIdClient()
    {
        return id_client;
    }

    public void setIdClient(int id_client)
    {
        this.id_client = id_client;
    }

    public int getIdVoiture()
    {
        return id_voiture;
    }

    public void setIdVoiture(int id_voiture)
    {
        this.id_voiture = id_voiture;
    }

    public int getEstimationKm()
    {
        return estimationKm;
    }

    public void setEstimationKm(int estimationKm)
    {
        this.estimationKm = estimationKm;
    }

    public int getNombreKmDepart()
    {
        return nombre_km_depart;
    }

    public void setNombreKmDepart(int nombre_km_depart)
    {
        this.nombre_km_depart = nombre_km_depart;
    }
}
