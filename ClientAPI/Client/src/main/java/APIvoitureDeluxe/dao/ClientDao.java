package APIvoitureDeluxe.dao;

import APIvoitureDeluxe.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDao extends CrudRepository<Client, Integer> {

    Optional<Client> findByEmailAndMdp(String email, String mdp );

    boolean existsByEmailAndMdp(String email, String mdp );

}
