package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dog extends Pet{
    private String stock; // порода
    
    public Dog(String type) throws IOException {
        super(type);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название породы: ");
        this.stock = bufferedReader.readLine();
    }
    public String getStock() {
        return stock;
    }
    @Override
    public String toString() {
        return "type = " + type + ", name = " + name + ", birthday = " + birthday + ", commands = " + commands + ", ownersLastName = " + ownersLastName + ", ownersFirstName = " + ownersFirstName + ", stock =  " + stock;
    }
}
