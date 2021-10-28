package voitureDeluxe.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LocationForm {
    
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeDebut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeFin;

    private int id_client;

    private long id_voiture;

    private int estimationKm;

    private int nombre_km_depart;

    public LocationForm()
    {

    }

    public LocationForm(long id, Date dateDeDebut, Date dateDeFin, int id_client, long id_voiture, int estimationKm, int nombre_km_depart)
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

    public void setId(long id)
    {
        this.id = id;
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
