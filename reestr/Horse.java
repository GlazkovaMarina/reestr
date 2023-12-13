package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Horse extends PackAnimal {
    private String kind;

    public Horse(String type) throws IOException {
        super(type);
        System.out.println("Введите род: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.kind = bufferedReader.readLine();
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "Тип = " + type + ", имя = " + name + ", день рождения = " + birthday + ", команды = " + commands
                + ", грузоподъемность = " + bearingForce + ", род =  " + kind;
    }
}
