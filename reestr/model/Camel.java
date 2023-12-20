package reestr.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Camel extends PackAnimal {

    private Integer numberOfHumps;

    public Camel(String type, String name, Date birthday, ArrayList<String> commands, Double bearingForce,
            Integer numberOfHumps) {
        super(type, name, birthday, commands, bearingForce);
        this.numberOfHumps = numberOfHumps;
    }

    public Camel(String type, String id, String name, Date birthday, ArrayList<String> commands, Double bearingForce,
            Integer numberOfHumps) {
        super(type, id, name, birthday, commands, bearingForce);
        this.numberOfHumps = numberOfHumps;
    }

    public Integer getNumberOfHumps() {
        return numberOfHumps;
    }

    @Override
    public String toString() {
        String com = commands.toString().substring(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(birthday);
        return type + "; " + id + "; " + name + "; " + date + "; " + com.substring(0, com.length() - 1)
                + "; " + bearingForce + "; " + numberOfHumps;
    }
}
