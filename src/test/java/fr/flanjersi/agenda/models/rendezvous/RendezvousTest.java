package fr.flanjersi.agenda.models.rendezvous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RendezvousTest {

    @Test
    public void getNumberOfPeople() {
        Rendezvous rendezvous = new Rendezvous();

        assertEquals(0, rendezvous.getNumberOfPeople());

        rendezvous.setNames(new ArrayList<>(Arrays.asList("Jérémy", "Anthony", "Florian", "Simon")));

        assertEquals(4, rendezvous.getNumberOfPeople());
    }
}
