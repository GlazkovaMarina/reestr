package reestr;

import java.io.IOException;
import java.util.Scanner;

public abstract class PackAnimal  extends Animal{
    protected Double bearingForce;
    protected String type;

    public PackAnimal(String type) throws IOException {
        super();
        System.out.println("Введите грузоподъемность (разделитель - запятая): ");
        Scanner sc = new Scanner(System.in);
        this.bearingForce = sc.nextDouble();
        this.type = type;
    }
    public Double getBearingForce() {
        return bearingForce;
    }
    public void setBearingForce(Double bearingForce) {
        this.bearingForce = bearingForce;
    }
    public String getType() {
        return type;
    }
}
