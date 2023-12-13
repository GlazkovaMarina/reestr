package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Donkey extends PackAnimal {
    private String stock;

    public Donkey(String type) throws IOException {
        super(type);

        System.out.println("Введите род: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.stock = bufferedReader.readLine();
    }

    public String getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Тип = " + type + ", имя = " + name + ", день рождения = " + birthday + ", команды = " + commands
                + ", грузоподъемность = " + bearingForce + ", род =  " + stock;
    }
}
