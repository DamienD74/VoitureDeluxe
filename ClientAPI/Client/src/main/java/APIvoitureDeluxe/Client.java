package APIvoitureDeluxe;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue
    public int id;
    @Column
    public String name;
    @Column
    public String surname;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dateOfBirth;
    @Column
    public int numberdriverlicense;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dateDriverLicense;
    @Column
    public String email;
    @Column
    public String mdp;

    public Client() {
    }

    public Client(int id, String name, String surname, Date dateOfBirth, int numberdriverlicense, Date dateDriverLicense, String email, String mdp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberdriverlicense = numberdriverlicense;
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

    public int getNumberdriverlicense() {
        return numberdriverlicense;
    }

    public void setNumberdriverlicense(int numberdriverlicense) {
        this.numberdriverlicense = numberdriverlicense;
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
                ", numberdriverlicense=" + numberdriverlicense +
                ", dateDriverLicense=" + dateDriverLicense +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
