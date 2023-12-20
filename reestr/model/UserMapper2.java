package reestr.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserMapper2 implements UserMapper {

    public String map(Animal animal) {
        return animal.toString();
    }

    public Animal map(String line) {
        String[] lines = line.split("; ");

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date birthdate = null;
        try {
            birthdate = format.parse(lines[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] str = lines[4].split("[,\\s]+");
        ArrayList<String> commands = new ArrayList<>();
        for (String command : str) {
            commands.add(command);
        }
        if (lines[0].equals("DOG")) {
            return new Dog(lines[0], lines[1], lines[2], birthdate, commands, lines[5], lines[6], lines[7]);
        } else if (lines[0].equals("CAT")) {
            return new Cat(lines[0], lines[1], lines[2], birthdate, commands, lines[5], lines[6], lines[7]);
        } else if (lines[0].equals("HAMSTER")) {
            return new Hamster(lines[0], lines[1], lines[2], birthdate, commands, lines[5], lines[6], lines[7]);
        } else if (lines[0].equals("HORSE")) {
            return new Horse(lines[0], lines[1], lines[2], birthdate, commands, Double.parseDouble((lines[5])),
                    lines[6]);
        } else if (lines[0].equals("CAMEL")) {
            return new Camel(lines[0], lines[1], lines[2], birthdate, commands, Double.parseDouble((lines[5])),
                    Integer.parseInt(lines[6]));
        } else if (lines[0].equals("DONKEY")) {
            return new Donkey(lines[0], lines[1], lines[2], birthdate, commands, Double.parseDouble((lines[5])),
                    lines[6]);
        }
        return null;
    }
}
