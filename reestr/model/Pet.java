package reestr.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pet extends Animal {
    protected String ownersLastName;
    protected String ownersFirstName;

    public Pet(String type, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName) {
        super(type, name, birthday, commands);
        this.ownersLastName = ownersLastName;
        this.ownersFirstName = ownersFirstName;
    }

    public Pet(String type, String id, String name, Date birthday, ArrayList<String> commands, String ownersLastName,
            String ownersFirstName) {
        super(type, id, name, birthday, commands);
        this.ownersLastName = ownersLastName;
        this.ownersFirstName = ownersFirstName;
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
}