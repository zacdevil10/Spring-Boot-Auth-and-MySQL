package uk.co.appsbystudio.rockets.rockets.rockets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rocketRepository")
public interface RocketRepository extends JpaRepository<Rocket, Long> {
    Rocket findRocketByName(String name);
}
