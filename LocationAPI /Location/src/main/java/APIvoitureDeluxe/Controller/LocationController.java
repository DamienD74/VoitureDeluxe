package APIvoitureDeluxe.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIvoitureDeluxe.Entity.Location;
import APIvoitureDeluxe.Repository.LocationRepository;

@RestController
public class LocationController {
    
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations")
    public Iterable<Location> location ()
    {
        return locationRepository.findAll();
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.GET)
    public Optional<Location> location(@PathVariable final Long id)
    {
        Optional <Location> location = locationRepository.findById(id);

        return location;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    public void ajouterLocation(@RequestBody Location location)
    {
        locationRepository.save(location);
    }

    @RequestMapping(value = "/locations", method = RequestMethod.PUT)
    public void modifierLocation(@RequestBody Location location)
    {
        Location locationTable = locationRepository.findById(location.getId()).get();
        locationTable.setDateDeDebut(location.getDateDeDebut());
        locationTable.setDateDeFin(location.getDateDeFin());
        locationTable.setIdClient(location.getIdClient());
        locationTable.setIdVoiture(location.getIdVoiture());
        locationTable.setEstimationKm(location.getEstimationKm());
        locationTable.setNombreKmDepart(location.getNombreKmDepart());
        locationRepository.save(locationTable);
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable final Long id)
    {
        locationRepository.deleteById(id);
    }
}
