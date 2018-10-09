package fr.flanjersi.agenda.services;

import fr.flanjersi.agenda.models.rendezvous.Rendezvous;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RendezvousServiceTest {

    @Test
    public void addRendezvous() {
        RendezvousService rendezvousService = new RendezvousService();

        Rendezvous rendezvous = new Rendezvous();

        rendezvousService.addRendezvous(rendezvous);

        assertEquals(1, rendezvousService.getNumberOfRendezvous());

        rendezvousService.addRendezvous(null);

        assertEquals(1, rendezvousService.getNumberOfRendezvous());
    }

    @Test
    public void getNumberOfRendezvous() {
        RendezvousService rendezvousService = new RendezvousService();

        Rendezvous rendezvous = new Rendezvous();

        rendezvousService.addRendezvous(rendezvous);

        assertEquals(1, rendezvousService.getNumberOfRendezvous());

        rendezvousService.addRendezvous(null);

        assertEquals(1, rendezvousService.getNumberOfRendezvous());
    }

    @Test
    public void getRendezvousFilterByTypes() {
        RendezvousService rendezvousService = new RendezvousService();

        Rendezvous rendezvousJobI = new Rendezvous();
        rendezvousJobI.setType("Job interview");

        Rendezvous rendezvousDate = new Rendezvous();
        rendezvousDate.setType("Date");

        Rendezvous rendezvousWithoutType = new Rendezvous();

        rendezvousService.addRendezvous(rendezvousJobI);

        assertEquals(1, rendezvousService.getRendezvousFilterByTypes("Job interview").size());
        assertEquals(0, rendezvousService.getRendezvousFilterByTypes("Job").size());

        rendezvousService.addRendezvous(rendezvousDate);

        assertEquals(1, rendezvousService.getRendezvousFilterByTypes("Job interview").size());
        assertEquals(2, rendezvousService.getRendezvousFilterByTypes("Job interview", "Date").size());

        rendezvousService.addRendezvous(rendezvousWithoutType);

        assertEquals(2, rendezvousService.getRendezvousFilterByTypes("Job interview", "Date").size());

        assertEquals(0, rendezvousService.getRendezvousFilterByTypes().size());
    }
}
