package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cat extends Pet{
    private String color;

    public Cat(String type) throws IOException {
        super(type);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите окрас: ");
        this.color = bufferedReader.readLine();
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "type = " + type + ", name = " + name + ", birthday = " + birthday + ", commands = " + commands + ", ownersLastName = " + ownersLastName + ", ownersFirstName = " + ownersFirstName + ", color =  " + color;
    }
}
