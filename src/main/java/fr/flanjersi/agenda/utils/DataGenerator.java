package fr.flanjersi.agenda.utils;

import fr.flanjersi.agenda.models.rendezvous.Rendezvous;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static DataFactory dataFactory = new DataFactory();

    public static Rendezvous genereRendezvous(){
        List<String> types = new ArrayList<>(Arrays.asList("Data", "Job interview", "Doctor", "Meetup"));

        Rendezvous rendezvous = new Rendezvous();

        List<String> names = new ArrayList<>();

        Random random = new Random();

        for(int i = 0 ; i < random.nextInt(10) ; i++){
            names.add(dataFactory.getFirstName() + " " + dataFactory.getLastName());
        }

        rendezvous.setNames(names);
        rendezvous.setPlace(dataFactory.getAddress());

        String type = types.get(random.nextInt(types.size()));
        rendezvous.setType(type);
        rendezvous.setDuration(random.nextInt(180));

        return rendezvous;
    }

}
