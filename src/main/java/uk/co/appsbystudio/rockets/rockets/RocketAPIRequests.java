package uk.co.appsbystudio.rockets.rockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.appsbystudio.rockets.rockets.rockets.Rocket;
import uk.co.appsbystudio.rockets.rockets.rockets.RocketRepository;

@Controller
@RequestMapping(path = "/api/rocket")
public class RocketAPIRequests {

    @Qualifier("rocketRepository")
    @Autowired
    public RocketRepository rocketRepository;

    /* RETRIEVE ALL ROCKETS */
    @GetMapping("/all")
    public @ResponseBody Iterable<Rocket> getAllRockets() {
        return rocketRepository.findAll();
    }

    /* RETRIEVE ROCKET BY ID */
    @GetMapping("/{id}")
    public @ResponseBody Rocket getRocketById(@PathVariable Integer id) {
        return rocketRepository.findRocketById(id);
    }

    /* RETRIEVE ROCKET BY NAME */
    @GetMapping("")
    public @ResponseBody Rocket getRocketByName(@Param(value = "name") String name) {
        return rocketRepository.findRocketByName(name);
    }

}
