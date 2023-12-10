package reestr;

import java.io.IOException;
import java.util.Scanner;

public class Camel extends PackAnimal{
    
    @Override
    public String toString() {
        return "type = " + type + ", name = " + name + ", birthday = " + birthday + ", commands = " + commands + ", bearingForce = " + bearingForce +", numberOfHumps =  " + numberOfHumps;
    }
    private Integer numberOfHumps;

    public Camel(String type) throws IOException {
        super(type);
        System.out.println("Введите количество горбов: ");
        Scanner sc = new Scanner(System.in);
        this.numberOfHumps = sc.nextInt();
    }
    public Integer getNumberOfHumps() {
        return numberOfHumps;
    }
    public void setNumberOfHumps(Integer numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
    }
}
