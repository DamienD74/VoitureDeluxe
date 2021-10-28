package APIvoitureDeluxe.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Location {
    
    @Id
    @GeneratedValue
    private long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeDebut;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeFin;

    @Column
    private int id_client;

    @Column
    private long id_voiture;

    @Column
    private int estimationKm;

    @Column
    private int nombre_km_depart;

    public Location()
    {

    }

    public Location(long id, Date dateDeDebut, Date dateDeFin, int id_client, long id_voiture, int estimationKm, int nombre_km_depart)
    {
        this.id = id;
        this.dateDeDebut = dateDeDebut;
        this.dateDeFin = dateDeFin;
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
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut)
    {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin()
    {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin)
    {
        this.dateDeFin = dateDeFin;
    }

    public int getIdClient()
    {
        return id_client;
    }

    public void setIdClient(int id_client)
    {
        this.id_client = id_client;
    }

    public long getIdVoiture()
    {
        return id_voiture;
    }

    public void setIdVoiture(long id_voiture)
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
