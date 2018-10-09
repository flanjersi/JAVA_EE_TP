package fr.flanjersi.agenda.services;

import com.google.common.base.Joiner;
import fr.flanjersi.agenda.models.rendezvous.Rendezvous;
import fr.flanjersi.agenda.models.rendezvous.RendezvousDAO;
import fr.flanjersi.agenda.models.rendezvous.RendezvousDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The service of the rendezvous
 */
@Service
public class RendezvousService {

    private static final Logger logger = LoggerFactory.getLogger(RendezvousService.class);

    /**
     * DAO for the rendezvous bean
     */
    @Autowired
    private RendezvousDAO rendezvousDAO;


    public RendezvousService() { }

    /**
     * Add a rendezvous
     * @param rendezvous
     */
    public void addRendezvous(Rendezvous rendezvous){
        if (rendezvous == null) return;

        rendezvousDAO.create(rendezvous);
    }

    /**
     * Get the number of rendezvous
     * @return
     */
    public int getNumberOfRendezvous(){
        return rendezvousDAO.findAllRendezvous().size();
    }

    /**
     * Get the number of rendezvous
     * @return
     */
    public List<Rendezvous> getAllRendezvous(){
        return rendezvousDAO.findAllRendezvous();
    }

    /**
     * Get a list of rendezvous filter by their types
     * @param types list of rendezvous's types
     * @return
     */
    public List<Rendezvous> getRendezvousFilterByTypes(String ... types){
        if(types.length == 0) return new ArrayList<Rendezvous>();

        return rendezvousDAO.findRendezvousByTypes(types);
    }


    /**
     * Visualize all rendezvous in info logs
     */
    public void visualizeRendezvous(){
        List<String> lines = new ArrayList<>();

        for(Rendezvous rendezvous : getAllRendezvous()) lines.add(rendezvous.toString());

        logger.info(String.format("VISUALIZATION\n ===== BDD CONTENT ROWS =====\n %s", Joiner.on("\n=====\n").join(lines)));
    }

}
