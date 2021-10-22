package voitureDeluxe.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import voitureDeluxe.form.ClientForm;
import voitureDeluxe.model.Client;

import java.util.ArrayList;
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
        List<Client> clientList = restTemplate.getForObject(url, List.class);
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
        List<Client> clients = new RestTemplate().getForObject(url, List.class);

        String name = clientForm.getName();
        String surname = clientForm.getSurname();
        int date_of_birth = clientForm.getData_of_birth();
        int number = clientForm.getNumber_driver_license();
        int date_driver = clientForm.getDate_driver_license();

        if (name != null && name.length() > 0 ) {
            Client newClient = new Client(name, surname, date_of_birth, number, date_driver);
            new RestTemplate().postForObject("http://localhost:8081/Clients", newClient, Client.class);

            return "redirect:/index";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addClient";
    }
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable int id){
        new RestTemplate().delete("http://localhost:8081/Character/"+id);

        return "redirect:/listClient";    }

    @RequestMapping (value={"/updateClient/{id}"}, method = RequestMethod.GET)
    public String update (@PathVariable int id, Model model){
        ClientForm clientForm = new ClientForm();
        Client client = new RestTemplate().getForObject("http://localhost:8081/Client/"+id, Client.class);
        clientForm.setName(client.getName());
        clientForm.setSurname(client.getSurname());
        clientForm.setData_of_birth(client.getData_of_birth());
        clientForm.setNumber_driver_license(client.getNumber_driver_license());
        clientForm.setDate_driver_license(client.getDate_driver_license());

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
                client.setData_of_birth(clientForm.getData_of_birth());
                client.setNumber_driver_license(clientForm.getNumber_driver_license());
                client.setDate_driver_license(clientForm.getDate_driver_license());

                new RestTemplate().put("http://localhost:8081/Client/" + client.getId(), client, Client.class);
                return "redirect:/listClient";
            }
        }
        return "updateClient";
    }
}
