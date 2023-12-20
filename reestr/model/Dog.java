package reestr.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dog extends Pet {
    private String stock; // порода

    public Dog(String type, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName, String stock) {
        super(type, name, birthday, commands, ownersLastName, ownersFirstName);
        this.stock = stock;
    }

    public Dog(String type, String id, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName, String stock) {
        super(type, id, name, birthday, commands, ownersLastName, ownersFirstName);
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    @Override
    public String toString() {
        String com = commands.toString().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(birthday);
        return type + "; " + id + "; " + name + "; " + date + "; " + com.substring(0, com.length() - 1)
                + "; " + ownersLastName + "; " + ownersFirstName + "; "
                + stock;
    }
}
