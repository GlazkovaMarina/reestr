package reestr.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Horse extends PackAnimal {
    private String kind;

    public Horse(String type, String name, Date birthday, ArrayList<String> commands, Double bearingForce,
            String kind) {
        super(type, name, birthday, commands, bearingForce);
        this.kind = kind;
    }

    public Horse(String type, String id, String name, Date birthday, ArrayList<String> commands, Double bearingForce,
            String kind) {
        super(type, id, name, birthday, commands, bearingForce);
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        String com = commands.toString().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(birthday);
        return type + "; " + id + "; " + name + "; " + date + "; " + com.substring(0, com.length() - 1)
                + "; " + bearingForce + "; " + kind;
    }
}
