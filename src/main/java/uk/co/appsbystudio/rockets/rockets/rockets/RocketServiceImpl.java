package uk.co.appsbystudio.rockets.rockets.rockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("rocketService")
public class RocketServiceImpl implements RocketService {

    @Qualifier("rocketRepository")
    @Autowired
    private RocketRepository rocketRepository;

    @Override
    public Rocket findRocketByName(String name) {
        return rocketRepository.findRocketByName(name);
    }

    @Override
    public void saveRocket(Rocket rocket) {
        rocketRepository.save(rocket);
    }
}
