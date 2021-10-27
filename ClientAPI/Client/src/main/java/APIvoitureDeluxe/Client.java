package APIvoitureDeluxe;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public Client() {
    }

    public Client(int id, String name, String surname, Date dateOfBirth, int numberdriverlicense, Date dateDriverLicense) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberdriverlicense = numberdriverlicense;
        this.dateDriverLicense = dateDriverLicense;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", data_of_birth=" + dateOfBirth +
                ", number_driver_license=" + numberdriverlicense +
                ", date_driver_license=" + dateDriverLicense +
                '}';
    }
}
