package voitureDeluxe.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Client {
    public int id;
    public String name;
    public String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dateOfBirth;
    public int numberDriverLicense;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dateDriverLicense;
    public String email;
    public String mdp;

    public Client() {
    }

    public Client(int id, String name, String surname, Date dateOfBirth, int numberDriverLicense, Date dateDriverLicense , String email , String mdp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberDriverLicense = numberDriverLicense;
        this.dateDriverLicense = dateDriverLicense;
        this.email = email;
        this.mdp = mdp;
    }

    public Client(String name, String surname, Date dateOfBirth, int numberDriverLicense, Date dateDriverLicense, String email, String mdp) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberDriverLicense = numberDriverLicense;
        this.dateDriverLicense = dateDriverLicense;
        this.email = email;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberDriverLicense() {
        return numberDriverLicense;
    }

    public void setNumberDriverLicense(int numberDriverLicense) {
        this.numberDriverLicense = numberDriverLicense;
    }

    public Date getDateDriverLicense() {
        return dateDriverLicense;
    }

    public void setDateDriverLicense(Date dateDriverLicense) {
        this.dateDriverLicense = dateDriverLicense;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", numberDriverLicense=" + numberDriverLicense +
                ", dateDriverLicense=" + dateDriverLicense +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}

