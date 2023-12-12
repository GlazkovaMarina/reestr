package reestr;

import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        // name
        System.out.println("Введите имя животного: ");
        name = bufferedReader.readLine();

        // birthday
        boolean flag = true;
        do {
            System.out.println("Введите дату рождения животного в формате dd-MM-yyyy (Н-р 01-12-2020): ");
            tempBirthday = bufferedReader.readLine();
            if (Validation.isDateValid(tempBirthday)) {
                flag = false;
            } else {
                System.out.println("Некорректный формат даты рождения или введена несуществующая дата!");
            }
        } while (flag);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.birthday = format.parse(tempBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // commands
        System.out.println(
                "Введите команды, которые умеет выполнять животное через запятую и пробел (Н-р Сидеть, Лежать, Гавкать): ");
        tempCommands = bufferedReader.readLine();
        String[] str = tempCommands.split("[,\\s]+");
        this.commands = new ArrayList<>();
        for (String command : str) {
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
}
