package reestr;

import java.io.IOException;
import java.util.Scanner;

public class Camel extends PackAnimal {

    @Override
    public String toString() {
        return "type = " + type + ", name = " + name + ", birthday = " + birthday + ", commands = " + commands
                + ", bearingForce = " + bearingForce + ", numberOfHumps =  " + numberOfHumps;
    }

    private Integer numberOfHumps;

    public Camel(String type) throws IOException {
        super(type);
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Введите количество горбов: ");
            if (sc.hasNextInt()) {
                this.numberOfHumps = sc.nextInt();
                flag = false;
            } else {
                System.out.println("Некорректный ввод! Введите целое число!");
                sc.nextLine();
            }
        } while (flag);
    }

    public Integer getNumberOfHumps() {
        return numberOfHumps;
    }
}
