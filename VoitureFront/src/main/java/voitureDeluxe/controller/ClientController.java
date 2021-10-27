package voitureDeluxe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import voitureDeluxe.form.ClientForm;
import voitureDeluxe.model.Client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {



    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = { "/listClient"}, method = RequestMethod.GET)
    public String listClient(Model model) {

        String url = "http://localhost:8081/Clients";
        RestTemplate restTemplate = new RestTemplate();
        Client[] clientList = restTemplate.getForObject(url, Client[].class);
        model.addAttribute("clients", clientList);

        return "listClient";
    }
    @RequestMapping(value = {"/addClient"}, method = RequestMethod.GET)
    public String addClient(Model model){
        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm" , clientForm);

        return "addClient";
    }

        @RequestMapping(value = {"/addClient"}, method = RequestMethod.POST)
    public String saveClient(Model model, @ModelAttribute("clientForm") ClientForm clientForm) {
        String url = "http://localhost:8081/Clients";

        String name = clientForm.getName();
        String surname = clientForm.getSurname();
        Date dateOfBirth = clientForm.getDateOfBirth();
        int number = clientForm.getNumberDriverLicense();
        Date dateDriver = clientForm.getDateDriverLicense();

        if (name != null && name.length() > 0 ) {
            Client newClient = new Client(name, surname, dateOfBirth, number, dateDriver);
            new RestTemplate().postForObject("http://localhost:8081/Clients", newClient, Client.class);

            return "redirect:/listClient";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addClient";
    }
    @RequestMapping(value = {"/deleteClient/{id}"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable int id){
        new RestTemplate().delete("http://localhost:8081/Client/"+id);

        return "redirect:/listClient";    }

    @RequestMapping (value={"/updateClient/{id}"}, method = RequestMethod.GET)
    public String update (@PathVariable int id, Model model){
        ClientForm clientForm = new ClientForm();
        Client client = new RestTemplate().getForObject("http://localhost:8081/Client/"+id, Client.class);
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        clientForm.setSurname(client.getSurname());
        clientForm.setDateOfBirth(client.getDateOfBirth());
        clientForm.setNumberDriverLicense(client.getNumberDriverLicense());
        clientForm.setDateDriverLicense(client.getDateDriverLicense());

        model.addAttribute("clientForm" , clientForm);


        return "updateClient";
    }
    @RequestMapping (value = {"/updateClient/{id}"}, method = RequestMethod.POST)
    public String updateClient (@PathVariable int id, @ModelAttribute("clientForm") ClientForm clientForm ){

        String url = "http://localhost:8081/Clients";
        Client[] clients = new RestTemplate().getForObject(url, Client[].class);

        for (Client client : clients){
            if (client.getId() == id){
                client.setName(clientForm.getName());
                client.setSurname(clientForm.getSurname());
                client.setDateOfBirth(clientForm.getDateOfBirth());
                client.setNumberDriverLicense(clientForm.getNumberDriverLicense());
                client.setDateDriverLicense(clientForm.getDateDriverLicense());

                new RestTemplate().put("http://localhost:8081/Client/" + client.getId(), client, Client.class);
                return "redirect:/listClient";
            }
        }
        return "updateClient";
    }
}
