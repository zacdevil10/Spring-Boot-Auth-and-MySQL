package uk.co.appsbystudio.rockets.rockets.rockets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("rocketRepository")
public interface RocketRepository extends CrudRepository<Rocket, Long> {
    Rocket findRocketById(Integer id);
    Rocket findRocketByName(String name);
}
