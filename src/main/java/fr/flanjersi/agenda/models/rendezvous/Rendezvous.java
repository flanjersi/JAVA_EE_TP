package fr.flanjersi.agenda.models.rendezvous;

import java.util.List;

/**
 * Bean to storage information about a rendezvous
 */
public class Rendezvous {

    /**
     * Id of the rendezvous
     */
    private int id;

    /**
     * The duration of the rendezvous
     */
    private int duration;

    /**
     * List of people's name who take part in the rendezvous
     */
    private List<String> names;

    /**
     * The place where the rendezvous is happening
     */
    private String place;

    /**
     * The type of the rendezvous
     */
    private String type;

    public Rendezvous() { }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the number of people who take part in the rendezvous
     * @return
     */
    public int getNumberOfPeople(){
        if(names == null) return 0;

        return names.size();
    }

    @Override
    public String toString() {
        return "Rendezvous{" +
                "id=" + id +
                ", duration=" + duration +
                ", names=" + names +
                ", place='" + place + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
