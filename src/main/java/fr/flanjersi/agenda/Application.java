package fr.flanjersi.agenda;

import fr.flanjersi.agenda.services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Application implements ApplicationRunner {

    @Autowired
    private RendezvousService rendezvousService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        //rendezvousService.addRendezvous(DataGenerator.genereRendezvous());
        //rendezvousService.visualizeRendezvous();
    }
}
