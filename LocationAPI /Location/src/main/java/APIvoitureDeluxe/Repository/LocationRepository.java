package APIvoitureDeluxe.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import APIvoitureDeluxe.Entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
    
    boolean existsByIdClient(int id);
}
