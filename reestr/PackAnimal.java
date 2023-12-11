package reestr;

import java.io.IOException;
import java.util.Scanner;

public abstract class PackAnimal  extends Animal{
    protected Double bearingForce;
    protected String type;

    public PackAnimal(String type) throws IOException {
        super();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("Введите грузоподъемность (разделитель - запятая): ");
            if (sc.hasNextDouble()){
                this.bearingForce = sc.nextDouble();
                flag = false;
            } 
            else {
                System.out.println("Некорректный ввод! Введите число! Если оно дробное, то разделитель - запятая!");
                sc.nextLine();
            }
        } while (flag);
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
