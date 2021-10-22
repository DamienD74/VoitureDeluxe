package APIvoitureDeluxe.dao;

import APIvoitureDeluxe.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer> {


}
