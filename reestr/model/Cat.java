package reestr.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cat extends Pet {
    private String color;

    public Cat(String type, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName, String color) {
        super(type, name, birthday, commands, ownersLastName, ownersFirstName);
        this.color = color;
    }

    public Cat(String type, String id, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName, String color) {
        super(type, id, name, birthday, commands, ownersLastName, ownersFirstName);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String com = commands.toString().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(birthday);
        return type + "; " + id + "; " + name + "; " + date + "; "
                + com.substring(0, com.length() - 1)
                + "; " + ownersLastName + "; " + ownersFirstName + "; "
                + color;
    }
}
