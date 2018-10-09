package fr.flanjersi.agenda.utils.formatter;

import fr.flanjersi.agenda.models.rendezvous.Rendezvous;

public class HTMLRendezvousFormatter implements RendezvousFormatter {

    @Override
    public String format(Rendezvous rendezvous) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<div>");

        stringBuilder.append("<p>Type : " + rendezvous.getType() + "</p>");
        stringBuilder.append("<p>Duration : " + rendezvous.getDuration() + "</p>");
        stringBuilder.append("<p>Place : " + rendezvous.getPlace() + "</p>");
        stringBuilder.append("<p>Number of people : " + rendezvous.getNumberOfPeople() + "</p>");
        stringBuilder.append("<p>Names</p>");

        for(String name : rendezvous.getNames()){
            stringBuilder.append("<p>" + name + "</p>");
        }

        stringBuilder.append("</div>");

        return stringBuilder.toString();
    }

}
