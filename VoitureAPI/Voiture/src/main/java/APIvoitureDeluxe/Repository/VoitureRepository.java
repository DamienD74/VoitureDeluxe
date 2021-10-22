package APIvoitureDeluxe.Repository;

import org.springframework.data.repository.CrudRepository;

import APIvoitureDeluxe.Entity.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Long>{
    
}
