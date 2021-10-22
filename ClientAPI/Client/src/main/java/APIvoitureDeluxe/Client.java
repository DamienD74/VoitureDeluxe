package APIvoitureDeluxe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    public int data_of_birth ;
    @Column
    public int number_driver_license;
    @Column
    public int date_driver_license;

    public Client() {
    }

    public Client(int id, String name, String surname, int data_of_birth, int number_driver_license, int date_driver_license) {
        this.id = id;
        name = name;
        surname = surname;
        this.data_of_birth = data_of_birth;
        this.number_driver_license = number_driver_license;
        this.date_driver_license = date_driver_license;
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

    public int getData_of_birth() {
        return data_of_birth;
    }

    public void setData_of_birth(int data_of_birth) {
        this.data_of_birth = data_of_birth;
    }

    public int getNumber_driver_license() {
        return number_driver_license;
    }

    public void setNumber_driver_license(int number_driver_license) {
        this.number_driver_license = number_driver_license;
    }

    public int getDate_driver_license() {
        return date_driver_license;
    }

    public void setDate_driver_license(int date_driver_license) {
        this.date_driver_license = date_driver_license;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", data_of_birth=" + data_of_birth +
                ", number_driver_license=" + number_driver_license +
                ", date_driver_license=" + date_driver_license +
                '}';
    }
}
