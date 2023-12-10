package reestr;

import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Animal {
    protected String name;
    protected Date birthday;
    protected ArrayList<String> commands;

    public Animal() throws IOException {
        String tempBirthday = null;
        String tempCommands = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя животного: ");
        name = bufferedReader.readLine();
        System.out.println("Введите дату рождения животного в формате yyyy-mm-dd (Н-р 2020-12-01): ");
        tempBirthday = bufferedReader.readLine();
        System.out.println("Введите команды, которые умеет выполнять животное через запятую и пробел (Н-р Сидеть, Лежать, Гавкать): ");
        tempCommands = bufferedReader.readLine(); 

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = format.parse(tempBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] str = tempCommands.split("[,\\s]+");
        this.commands = new ArrayList<>();
        for (String command: str) {
            this.commands.add(command);
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return birthday.toString();
    }
    public ArrayList<String> getCommands() {
        return commands;
    }
    public void newCommand(String command) {
        this.commands.add(command);
    }
    @Override
    public String toString() {
        return "name = " + name + ", birthday = " + birthday.toString() + ", commands = " + commands;
    }
}

