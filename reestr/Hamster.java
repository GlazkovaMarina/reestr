package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hamster extends Pet {
    private String genus; // род

    public Hamster(String type) throws IOException {
        super(type);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите род: ");
        this.genus = bufferedReader.readLine();
    }

    public String getGenus() {
        return genus;
    }

    @Override
    public String toString() {
        return "Тип = " + type + ", имя = " + name + ", день рождения = " + birthday + ", команды = " + commands
                + ", фамилия хозяина = " + ownersLastName + ", имя хозяина = " + ownersFirstName + ", род =  "
                + genus;
    }
}
