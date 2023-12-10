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
                    "\nВведите цифру животного, которое хотели бы добавить (0 - Собака, 1 - Кошка, 2 - Хомяк, 3 - Лошадь, 4 - Верблюд, 5 -Осел): ");
            number = sc.nextInt();
            if (number < 0 || number > 5) {
                System.out.println("ОШИБКА! Некoрректный ввод!");
            } else {
                reestr.add(WhoIs(number));
            }
        }
    }

    public static void PrintReestr(ArrayList<Object> reestr) throws IOException {
        int i = 1;
        System.out.println("\nРеестр:");
        for (Object animal : reestr) {
            System.out.printf("%d) ", i++);
            System.out.println(animal.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList reestr = new ArrayList<Object>();
        Scanner sc = new Scanner(System.in);
        int number = -1;
        while (number != 1 || number != 2 || number != 0) {
            System.out.println(
                    "\nОСНОВНОЕ МЕНЮ\nЭто реестр животных!\nВыберите действие:\n1 - завести новое животное;\n2 - вывести список животных в реестре;\n3 - вывести команды, выбранного животного;\n0 - завершить работу с реестром!");
            number = sc.nextInt();
            switch (number) {
                case 0:
                    System.out.println("Работа с реестром завершена! До свидания!");
                    break;
                case 1:
                    AddAnimal(reestr);
                    break;
                case 2:
                    PrintReestr(reestr);
                    break;
                case 3:
                    
                    break;
                default:
                    System.out.println("ОШИБКА! Некoрректный ввод!");
                    break;
            }
        }

    }
}
