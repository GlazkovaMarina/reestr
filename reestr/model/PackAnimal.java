package reestr.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class PackAnimal extends Animal {
    protected Double bearingForce;

    public PackAnimal(String type, String name, Date birthday, ArrayList<String> commands, Double bearingForce) {
        super(type, name, birthday, commands);
        this.bearingForce = bearingForce;
    }

    public PackAnimal(String type, String id, String name, Date birthday, ArrayList<String> commands,
            Double bearingForce) {
        super(type, id, name, birthday, commands);
        this.bearingForce = bearingForce;
    }

    public Double getBearingForce() {
        return bearingForce;
    }

    public void setBearingForce(Double bearingForce) {
        this.bearingForce = bearingForce;
    }
}
