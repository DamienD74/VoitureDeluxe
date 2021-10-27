package APIvoitureDeluxe.VoitureDeluxe;

import APIvoitureDeluxe.Client;
import APIvoitureDeluxe.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientController{

    @Autowired
    public ClientDao clientDao ;

    @GetMapping(value = "Client/{id}")
        public Optional<Client> afficherClient(@PathVariable int id){

        return clientDao.findById(id);
    }

    @GetMapping(value = "Clients")
    public Iterable<Client> afficherListClient(){

        return clientDao.findAll();
    }

    @PostMapping(value = "Clients")
    public void ajouterClient(@RequestBody Client client){

        clientDao.save(client);

    }

    @PutMapping ( value = "Client/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable int id){
        client.setId(id);
        clientDao.save(client);

    }

    @DeleteMapping(value = "Client/{id}")
    public void deleteClient(@PathVariable int id){

        clientDao.deleteById(id);
    }

    @PostMapping(value = "verificationClient")
    public boolean verificationClient(@RequestBody Client client){

        return clientDao.existsByEmailAndMdp(client.getEmail(), client.getMdp());
    }

    @PostMapping(value = "connexion")
    public Optional<Client> connexion(@RequestBody Client client){

        return clientDao.findByEmailAndMdp(client.getEmail(), client.getMdp());
    }
}