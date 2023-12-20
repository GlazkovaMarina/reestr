package reestr.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hamster extends Pet {
    private String genus; // род

    public Hamster(String type, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName, String genus) {
        super(type, name, birthday, commands, ownersLastName, ownersFirstName);
        this.genus = genus;
    }

    public Hamster(String type, String id, String name, Date birthday, ArrayList<String> commands,
            String ownersLastName, String ownersFirstName, String genus) {
        super(type, id, name, birthday, commands, ownersLastName, ownersFirstName);
        this.genus = genus;
    }

    public String getGenus() {
        return genus;
    }

    @Override
    public String toString() {
        String com = commands.toString().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(birthday);
        return type + "; " + id + "; " + name + "; " + date + "; " + com.substring(0, com.length() - 1)
                + "; " + ownersLastName + "; " + ownersFirstName + "; "
                + genus;
    }
}
