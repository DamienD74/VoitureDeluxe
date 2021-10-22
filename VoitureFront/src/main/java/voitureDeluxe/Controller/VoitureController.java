package voitureDeluxe.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import voitureDeluxe.model.Voiture;

@Controller
public class VoitureController {
    
    @RequestMapping(value = {"/voitures"}, method = RequestMethod.GET)
    public String personnages (Model model)
    {   
        String url = "http://localhost:8082/voitures";
        RestTemplate restTemplate = new RestTemplate();
        List<Voiture> voitureList = restTemplate.getForObject(url, List.class);
        model.addAttribute("voitures",voitureList);

        return "admin_listeVoiture";
    }
}
