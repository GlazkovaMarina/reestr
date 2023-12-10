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
}
