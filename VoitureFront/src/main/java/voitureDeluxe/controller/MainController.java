package voitureDeluxe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import voitureDeluxe.model.Voiture;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
        
        session .setAttribute("id_utilisateur", 1);

		String url = "http://localhost:8082/voitures";
        RestTemplate restTemplate = new RestTemplate();
        List<Voiture> voitureList = restTemplate.getForObject(url, List.class);
        model.addAttribute("voitures",voitureList);
		return "index";
	}


}
