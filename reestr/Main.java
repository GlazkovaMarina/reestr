package reestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static Animal WhoIs(int number) throws IOException {
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

    public static void AddAnimal(ArrayList<Animal> reestr) throws IOException {
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

    public static void PrintReestr(ArrayList<Animal> reestr) throws IOException {
        int i = 1;
        System.out.println("\nРеестр:");
        for (Animal animal : reestr) {
            System.out.printf("%d) ", i++);
            System.out.println(animal.toString());
        }
    }

    public static void BirthdayList(ArrayList<Animal> reestr) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String birthday = null;
        boolean flag = true;
        do {
            System.out.println("Введите дату рождения животного в формате dd-MM-yyyy (Н-р 01-12-2020): ");
            birthday = bufferedReader.readLine();
            if (Validation.isDateValid(birthday)) {
                flag = false;
            } else {
                System.out.println("Некорректный формат даты рождения или введена несуществующая дата!");
            }
        } while (flag);

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date birthdate = null;
        try {
            birthdate = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("\nCписок животных по дате рождения:");
        int i = 1;
        for (Animal animal : reestr) {
            if (animal.getBirthday().equals(birthdate.toString())) {
                System.out.printf("%d) ", i++);
                System.out.println(animal.toString());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Animal> animalReestr = new ArrayList<Animal>();
        int number = -1;
        try (Scanner sc = new Scanner(System.in); Counter count = new Counter()) {
            while (number != 1 || number != 2 || number != 0) {
                System.out.println(
                        "\nОСНОВНОЕ МЕНЮ\nЭто реестр животных!\nВыберите действие:\n1 - завести новое животное;\n2 - вывести список животных в реестре;\n3 - вывести команды, выбранного животного;\n4 - добавить команду, выбранному животному;\n5 - вывести список животных по дате рождения;\n6 - вывести общее количество созданных животных любого типа;\n0 - завершить работу с реестром!");
                System.out.printf("Ваш выбор: ");
                number = sc.nextInt();
                switch (number) {
                    case 0:
                        System.out.println("Работа с реестром завершена! До свидания!");
                        break;
                    case 1:
                        AddAnimal(animalReestr);
                        count.add();
                        break;
                    case 2:
                        PrintReestr(animalReestr);
                        break;
                    case 3:
                        PrintReestr(animalReestr);
                        System.out.println("Выберите животное, указав его порядковый номер в списке: ");
                        number = sc.nextInt();
                        int i = 1;
                        for (Animal animal : animalReestr) {
                            if (number == i++) {
                                System.out.println(animal.getCommands());
                            }
                        }
                        number = 2;
                        break;
                    case 4:
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                        PrintReestr(animalReestr);
                        System.out.println("Выберите животное, указав его порядковый номер в списке: ");
                        number = sc.nextInt();
                        int k = 1;
                        for (Animal animal : animalReestr) {
                            if (number == k++) {
                                System.out.println("Введите новую команду:");
                                animal.newCommand(bufferedReader.readLine());
                            }
                        }
                        number = 4;
                        break;
                    case 5:
                        BirthdayList(animalReestr);
                        break;
                    case 6:
                        System.out.println("Количество животных в реестре: " + Counter.getCount());
                        break;
                    default:
                        System.out.println("ОШИБКА! Некoрректный ввод!");
                        break;
                }
                if (number == 0) {
                    sc.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
