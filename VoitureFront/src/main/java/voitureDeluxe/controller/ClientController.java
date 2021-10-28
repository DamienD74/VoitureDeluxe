package voitureDeluxe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import voitureDeluxe.form.ClientForm;
import voitureDeluxe.model.Client;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ClientController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/listClient" }, method = RequestMethod.GET)
    public String listClient(Model model) {

        String url = "http://localhost:8081/Clients";
        RestTemplate restTemplate = new RestTemplate();
        Client[] clientList = restTemplate.getForObject(url, Client[].class);
        model.addAttribute("clients", clientList);

        return "listClient";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.GET)
    public String addClient(Model model) {
        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);

        return "addClient";
    }

    @RequestMapping(value = { "/addClient" }, method = RequestMethod.POST)
    public String saveClient(HttpSession session ,Model model, @ModelAttribute("clientForm") ClientForm clientForm) {
        String url = "http://localhost:8081/Clients";

        String name = clientForm.getName();
        String surname = clientForm.getSurname();
        Date dateOfBirth = clientForm.getDateOfBirth();
        int number = clientForm.getNumberDriverLicense();
        Date dateDriver = clientForm.getDateDriverLicense();
        String email = clientForm.getEmail();
        String mdp = clientForm.getMdp();

        if (name != null && name.length() > 0) {
            Client newClient = new Client(name, surname, dateOfBirth, number, dateDriver, email, mdp);
            new RestTemplate().postForObject(url, newClient, Client.class);
            String url2 = "http://localhost:8081/connexion";
            Client clientRecuperer = new RestTemplate().postForObject(url2, newClient, Client.class);
            session .setAttribute("id_utilisateur", clientRecuperer.getId());



            return "redirect:/";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addClient";
    }

    @RequestMapping(value = { "/deleteClient/{id}" }, method = RequestMethod.GET)
    public String deleteClient(@PathVariable int id) {
        new RestTemplate().delete("http://localhost:8081/Client/" + id);

        return "redirect:/listClient";
    }

    @RequestMapping(value = { "/updateClient/{id}" }, method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        ClientForm clientForm = new ClientForm();
        Client client = new RestTemplate().getForObject("http://localhost:8081/Client/" + id, Client.class);
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        clientForm.setSurname(client.getSurname());
        clientForm.setDateOfBirth(client.getDateOfBirth());
        clientForm.setNumberDriverLicense(client.getNumberDriverLicense());
        clientForm.setDateDriverLicense(client.getDateDriverLicense());

        model.addAttribute("clientForm", clientForm);

        return "updateClient";
    }

    @RequestMapping(value = { "/updateClient/{id}" }, method = RequestMethod.POST)
    public String updateClient(@PathVariable int id, @ModelAttribute("clientForm") ClientForm clientForm) {

        String url = "http://localhost:8081/Client/" + id;
        Client client = new RestTemplate().getForObject(url, Client.class);

        client.setName(clientForm.getName());
        client.setSurname(clientForm.getSurname());
        client.setDateOfBirth(clientForm.getDateOfBirth());
        client.setNumberDriverLicense(clientForm.getNumberDriverLicense());
        client.setDateDriverLicense(clientForm.getDateDriverLicense());

        new RestTemplate().put(url, client, Client.class);
        return "redirect:/listClient";
    }

    @RequestMapping(value = {"/connexionClient"}, method = RequestMethod.GET)
    public String connexion(HttpSession session, Model model){
        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);

        System.out.println(session.getAttribute("id_utilisateur"));

        return "connexionClient";

    }

    @RequestMapping(value = {"/connexionClient"}, method = RequestMethod.POST)
    public String connexion(HttpSession session, @ModelAttribute("clientForm") ClientForm clientForm){
        String url = "http://localhost:8081/verificationClient";
        Client client = new Client();
        client.setEmail(clientForm.getEmail());
        client.setMdp(clientForm.getMdp());

        if (new RestTemplate().postForObject(url, client, Boolean.class))
        {
            String url2 = "http://localhost:8081/connexion";
            Client clientRecuperer = new RestTemplate().postForObject(url2, client, Client.class);
            session .setAttribute("id_utilisateur", clientRecuperer.getId());
        }
        else
        {
            session .setAttribute("id_utilisateur", null);
        }

        return "redirect:/";
    }
}
