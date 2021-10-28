package voitureDeluxe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import voitureDeluxe.form.LocationForm;
import voitureDeluxe.model.Location;
import voitureDeluxe.model.Voiture;

@Controller
public class LocationController {
    
    @RequestMapping(value = "/ajouterLocation/{id}", method = RequestMethod.GET)
    public String voirAjouterVoiture(Model model, @PathVariable final Long id)
    {
        String url = "http://localhost:8082/voitures/"+ id +"";
        RestTemplate restTemplate = new RestTemplate();
        Voiture voiture = restTemplate.getForObject(url, Voiture.class);

        LocationForm locationForm = new LocationForm();
        locationForm.setIdVoiture(voiture.getId());
        locationForm.setNombreKmDepart(voiture.getNombreKm());
        model.addAttribute("locationForm", locationForm);

        return "ajouterLocation";
    }

    @RequestMapping(value = "/ajouterLocation", method = RequestMethod.POST)
    public String ajouterVoiture(
    @ModelAttribute("locationForm") LocationForm locationForm, HttpServletRequest request)
    {
        int session = (int)request.getSession().getAttribute("id_utilisateur");

        String url = "http://localhost:8083/locations";
        RestTemplate restTemplate = new RestTemplate();
        List<Location> listeLocation = restTemplate.getForObject(url, List.class);

        Location location = new Location(locationForm.getId(), locationForm.getDateDeDebut(), locationForm.getDateDeFin(),
        session, locationForm.getIdVoiture(), locationForm.getEstimationKm(), locationForm.getNombreKmDepart());

        listeLocation.add(location);

        restTemplate.postForObject(url, location, LocationForm.class);

        return "redirect:/";
    }
}
