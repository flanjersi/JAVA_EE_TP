package fr.flanjersi.agenda.controllers;

import fr.flanjersi.agenda.services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;

@Controller
public class MonController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    RendezvousService rendezvousService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String add(){
        return "index";
    }


}
