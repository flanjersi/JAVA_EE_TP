package fr.flanjersi.agenda.models.rendezvous;

import java.util.List;

public interface RendezvousDAO {

    void create(Rendezvous rendezvous);

    void update(Rendezvous rendezvous);

    void delete(Rendezvous rendezvous);

    List<Rendezvous> findAllRendezvous();

    List<Rendezvous> findRendezvousByTypes(String ... types);
}
