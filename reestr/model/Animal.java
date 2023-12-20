package reestr.model;

import java.util.Date;
import java.util.ArrayList;

public abstract class Animal {
    protected String type;
    protected String id;
    protected String name;
    protected Date birthday;
    protected ArrayList<String> commands;

    public Animal(String type, String id, String name, Date birthday, ArrayList<String> commands) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        this.id = id;
    }

    public Animal(String type, String name, Date birthday, ArrayList<String> commands) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void newCommand(String command) {
        this.commands.add(command);
    }

    public String getType() {
        return type;
    }
}
