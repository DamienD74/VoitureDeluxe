package voitureDeluxe.form;

public class ClientForm {
    public int id;
    public String name;
    public String surname;
    public int data_of_birth ;
    public int number_driver_license;
    public int date_driver_license;

    public ClientForm() {
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
}
