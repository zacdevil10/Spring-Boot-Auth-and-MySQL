package uk.co.appsbystudio.rockets.rockets.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.appsbystudio.rockets.rockets.users.model.Session;

@Repository("sessionRepository")
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findSessionByPID(String pID);
}
