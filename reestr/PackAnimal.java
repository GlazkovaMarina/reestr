package reestr;

import java.io.IOException;
import java.util.Scanner;

public class PackAnimal  extends Animal{
    private Double bearingForce;
    private String type;

    public PackAnimal(String type) throws IOException {
        super();
        System.out.println("Введите грузоподъемность (разделитель - запятая): ");
        try (Scanner sc = new Scanner(System.in)) {
            this.bearingForce = sc.nextDouble();
        }
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
