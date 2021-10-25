package voitureDeluxe.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import voitureDeluxe.form.VoitureForm;
import voitureDeluxe.model.Voiture;

@Controller
public class VoitureController {
    
    @RequestMapping(value = {"/voitures"}, method = RequestMethod.GET)
    public String voitures (Model model)
    {   
        String url = "http://localhost:8082/voitures";
        RestTemplate restTemplate = new RestTemplate();
        List<Voiture> voitureList = restTemplate.getForObject(url, List.class);
        model.addAttribute("voitures",voitureList);

        return "admin_listeVoiture";
    }

    @RequestMapping(value = {"/voiture/{id}"}, method = RequestMethod.GET)
    public String voiture (Model model, @PathVariable final Long id)
    {   
        String url = "http://localhost:8082/voitures/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Voiture voiture = restTemplate.getForObject(url, Voiture.class);
        model.addAttribute("voiture",voiture);

        return "information_voiture";
    }

    @RequestMapping(value = "/ajouterVoiture", method = RequestMethod.GET)
    public String voirAjouterVoiture(Model model)
    {
        VoitureForm voitureForm = new VoitureForm();
        model.addAttribute("voitureForm", voitureForm);
        
        return "ajouterVoiture";
    }

    @RequestMapping(value = "/ajouterVoiture", method = RequestMethod.POST)
    public String ajouterVoiture(
    @ModelAttribute("voitureForm") VoitureForm voitureForm)
    {
        String url = "http://localhost:8082/voitures";
        RestTemplate restTemplate = new RestTemplate();
        List<Voiture> listeVoiture = restTemplate.getForObject(url, List.class);

        Voiture voiture = new Voiture(voitureForm.getId(), voitureForm.getNom(), voitureForm.getImmatriculation(),
                voitureForm.getCategorie(), voitureForm.getMarque(), voitureForm.getModele(), voitureForm.getCouleur(),
                voitureForm.getPrixReservation(), voitureForm.getPrixKm(), voitureForm.getChevauxFiscaux(), voitureForm.getUrlImage());

        listeVoiture.add(voiture);

        restTemplate.postForObject(url, voiture, Voiture.class);

        return "redirect:/voitures";
    }

    @RequestMapping(value = "/modifierVoiture/{id}", method = RequestMethod.GET)
    public String voirModifierVoiture(Model model, @PathVariable final Long id)
    {
        String url = "http://localhost:8082/voitures/"+ id +"";
        RestTemplate restTemplate = new RestTemplate();
        Voiture voiture = restTemplate.getForObject(url, Voiture.class);

        VoitureForm voitureForm = new VoitureForm(voiture.getId(), voiture.getNom(), voiture.getImmatriculation(),
        voiture.getCategorie(), voiture.getMarque(), voiture.getModele(), voiture.getCouleur(),
        voiture.getPrixReservation(), voiture.getPrixKm(), voiture.getChevauxFiscaux(), voiture.getUrlImage());
       
        model.addAttribute("voitureForm", voitureForm);
        
        return "modifierVoiture";
    }

    @RequestMapping(value = "/modifierVoiture", method = RequestMethod.POST)
    public String modifierVoiture(
    @ModelAttribute("voitureForm") VoitureForm voitureForm)
    {
        String url = "http://localhost:8082/voitures";
        RestTemplate restTemplate = new RestTemplate();

        Voiture voiture = new Voiture(voitureForm.getId(), voitureForm.getNom(), voitureForm.getImmatriculation(),
        voitureForm.getCategorie(), voitureForm.getMarque(), voitureForm.getModele(), voitureForm.getCouleur(),
        voitureForm.getPrixReservation(), voitureForm.getPrixKm(), voitureForm.getChevauxFiscaux(), voitureForm.getUrlImage());

        restTemplate.put(url, voiture, Voiture.class);

        return "redirect:/voitures";
    }

    @RequestMapping(value = "/supprimerVoiture/{id}", method = RequestMethod.GET)
    public String supprimerVoiture(@PathVariable final Long id)
    {
        String url = "http://localhost:8082/voitures/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);

        return "redirect:/voitures";
    }
}
