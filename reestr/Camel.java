package reestr;

import java.io.IOException;
import java.util.Scanner;

public class Camel extends PackAnimal{
    
    private Integer numberOfHumps;

    public Camel(String type) throws IOException {
        super(type);
        System.out.println("Введите количество горбов: ");
        try (Scanner sc = new Scanner(System.in)) {
            this.numberOfHumps = sc.nextInt();
        }
    }
    public Integer getNumberOfHumps() {
        return numberOfHumps;
    }
    public void setNumberOfHumps(Integer numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
    }
}
