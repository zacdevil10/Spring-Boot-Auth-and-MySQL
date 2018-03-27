package uk.co.appsbystudio.rockets.rockets.users.sessionservice;

import uk.co.appsbystudio.rockets.rockets.users.model.Session;
import uk.co.appsbystudio.rockets.rockets.users.model.User;

public interface SessionService {

    Session findSessionByPID(String pID);

    String createSession(User User);

}
