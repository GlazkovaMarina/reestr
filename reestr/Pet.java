package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Pet extends Animal{
    protected String ownersLastName;
    protected String ownersFirstName;
    protected String type;

    public Pet(String type) throws IOException {
        super();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя хозяина: ");
        ownersFirstName = bufferedReader.readLine();
        System.out.println("Введите фамилию хозяина: ");
        ownersLastName = bufferedReader.readLine();
        this.type = type;
    }
    public String getOwnersLastName() {
        return ownersLastName;
    }
    public void setOwnersLastName(String ownersLastName) {
        this.ownersLastName = ownersLastName;
    }
    public String getOwnersFirstName() {
        return ownersFirstName;
    }
    public void setOwnersFirstName(String ownersFirstName) {
        this.ownersFirstName = ownersFirstName;
    }
    public String getType() {
        return type;
    }
} 