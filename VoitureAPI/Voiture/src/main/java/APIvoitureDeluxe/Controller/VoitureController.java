package APIvoitureDeluxe.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIvoitureDeluxe.Entity.Voiture;
import APIvoitureDeluxe.Repository.VoitureRepository;

@RestController
public class VoitureController {
    
    @Autowired
    private VoitureRepository voitureRepository;

    @GetMapping("/voitures")
    public Iterable<Voiture> voitures ()
    {
        return voitureRepository.findAll();
    }

    @RequestMapping(value = "/voitures/{id}", method = RequestMethod.GET)
    public Optional<Voiture> voiture(@PathVariable final Long id)
    {
        Optional <Voiture> voiture = voitureRepository.findById(id);

        return voiture;
    }

    @RequestMapping(value = "/voitures", method = RequestMethod.POST)
    public void ajouterVoiture(@RequestBody Voiture voiture)
    {
        voitureRepository.save(voiture);
    }

    @RequestMapping(value = "/voitures", method = RequestMethod.PUT)
    public void modifierVoiture(@RequestBody Voiture voiture)
    {
        Voiture voitureTable = voitureRepository.findById(voiture.getId()).get();
        voitureTable.setNom(voiture.getNom());
        voitureTable.setImmatriculation(voiture.getImmatriculation());
        voitureTable.setCategorie(voiture.getCategorie());
        voitureTable.setMarque(voiture.getMarque());
        voitureTable.setModele(voiture.getModele());
        voitureTable.setCouleur(voiture.getCouleur());
        voitureTable.setPrixReservation(voiture.getPrixReservation());
        voitureTable.setPrixKm(voiture.getPrixKm());
        voitureTable.setChevauxFiscaux(voiture.getChevauxFiscaux());
        voitureRepository.save(voitureTable);
    }

    @RequestMapping(value = "/voitures/{id}", method = RequestMethod.DELETE)
    public void deletevoiture(@PathVariable final Long id)
    {
        voitureRepository.deleteById(id);
    }
}
