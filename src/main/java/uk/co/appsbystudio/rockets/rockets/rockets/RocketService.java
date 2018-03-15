package uk.co.appsbystudio.rockets.rockets.rockets;

public interface RocketService {
    Rocket findRocketByName(String name);
    void saveRocket(Rocket rocket);
}
