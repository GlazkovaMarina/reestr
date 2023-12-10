package reestr;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static Object WhoIs(int number) throws IOException {
        switch (number) {
            case 0:
                Dog dog = new Dog("Собака");
                return dog;
            case 1:
                Cat cat = new Cat("Кошка");
                return cat;
            case 2:
                Hamster hamster = new Hamster("Хомяк");
                return hamster;
            case 3:
                Horse horse = new Horse("Лошадь");
                return horse;
            case 4:
                Camel camel = new Camel("Верблюд");
                return camel;
            case 5:
                Donkey donkey = new Donkey("Осел");
                return donkey;
        }
        return null;
    }

    public static void AddAnimal(ArrayList<Object> reestr) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number = -1;
        while (number < 0 || number > 5) {
            System.out.println(
                    "Введите цифру животного, которое хотели бы добавить (0 - Собака, 1 - Кошка, 2 - Хомяк, 3 - Лошадь, 4 - Верблюд, 5 -Осел): ");
            number = sc.nextInt();
            if (number < 0 || number > 5) {
                System.out.println("ОШИБКА! Некoрректный ввод!");
            } else {
                reestr.add(WhoIs(number));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList reestr = new ArrayList<Object>();

        Scanner sc = new Scanner(System.in);
        int number = -1;
        while (number != 1 || number != 2 || number != 0) {
            System.out.println(
                    "Это реестр животных!\nВыберите действие:\n1 - завести новое животное;\n2 - вывести список животных в реестре;\n0 - завершить работу с реестром!");
            number = sc.nextInt();
            if (number == 1) {
                AddAnimal(reestr);
            } else if (number == 2) {
                int i = 1;
                for (Object animal : reestr) {
                    System.out.printf("%d) ", i++);
                    System.out.println(animal.toString());
                }
            } else if (number == 0) {
                System.out.println("Работа с реестром завершена! До свидания!");
                break;
            } else {
                System.out.println("ОШИБКА! Некoрректный ввод!");
            }
        }

    }
}
