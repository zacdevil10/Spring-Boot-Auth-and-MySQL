package uk.co.appsbystudio.rockets.rockets.users.sessionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.co.appsbystudio.rockets.rockets.users.SessionRepository;
import uk.co.appsbystudio.rockets.rockets.users.model.Session;
import uk.co.appsbystudio.rockets.rockets.users.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

    @Qualifier("sessionRepository")
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Session findSessionByPID(String pID) {
        return sessionRepository.findSessionByPID(pID);
    }

    @Override
    public String createSession(User user) {
        Session session = new Session();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 12);

        UUID uuid = UUID.randomUUID();

        session.setpID(uuid.toString());
        session.setUserID(user.getId());
        session.setCreated(new Date());
        session.setExpires(calendar.getTime());

        sessionRepository.save(session);

        return session.getpID();
    }
}
