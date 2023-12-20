package reestr.views;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import reestr.Counter;
import reestr.Validation;
import reestr.controllers.UserController;
import reestr.model.Animal;
import reestr.model.Camel;
import reestr.model.Cat;
import reestr.model.Dog;
import reestr.model.Donkey;
import reestr.model.Hamster;
import reestr.model.Horse;

public class ViewUser {
    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        try (Counter count = new Counter()) {
            Commands com = Commands.NONE;
            while (true) {
                while (true) {
                    String command = prompt(
                            "\nОСНОВНОЕ МЕНЮ\nЭто реестр животных!\nВыберите действие:\nNEW- завести новое животное;\nLIST - вывести список животных в реестре;\nCOMMANDS - вывести команды, выбранного животного;\nADD_COMMAND - добавить команду, выбранному животному;\nLIST_BD - вывести список животных по дате рождения;\nCOUNT - вывести общее количество вновь созданных животных любого типа;\nEXIT - завершить работу с реестром!\n")
                            .toUpperCase();
                    try {
                        com = Commands.valueOf(command);
                        break;
                    } catch (Exception e) {
                        System.out.println("Неопознанная команда!");
                    }
                }

                if (com == Commands.EXIT) {
                    System.out.println("Работа с реестром завершена! До свидания!");
                    return;
                }
                String id = null;
                switch (com) {
                    case NEW:
                        userController.addAnimal(setAnimal());
                        count.add();
                        break;
                    case LIST:
                        System.out.println(userController.AnimalList());
                        break;
                    case COMMANDS:
                        id = prompt("Введите id животного: ");
                        System.out.println(userController.listCommands(id));
                        break;
                    case ADD_COMMAND:
                        id = prompt("Введите id животного: ");
                        String newCommand = prompt("Введите новую команду: ");
                        userController.addCommand(id, newCommand);
                        break;
                    case LIST_BD:
                        System.out.println(userController.birthdayList(setDate()));
                        break;
                    case COUNT:
                        System.out.println("Количество новых животных в реестре: " + Counter.getCount());
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private static Double dPrompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        boolean flag = true;
        Double doub = 0.0;
        do {
            if (sc.hasNextDouble()) {
                doub = sc.nextDouble();
                flag = false;
            } else {
                System.out.println(
                        "Некорректный ввод! Введите число! Если оно дробное, то разделитель - запятая!");
                sc.nextLine();
            }
        } while (flag);
        return doub;
    }

    private static Integer iPrompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        boolean flag = true;
        Integer integ = 0;
        do {
            if (sc.hasNextInt()) {
                integ = sc.nextInt();
                flag = false;
            } else {
                System.out.println(
                        "Некорректный ввод! Введите целое число!");
                sc.nextLine();
            }
        } while (flag);
        return integ;
    }

    private static Animal setAnimal() {

        TypeAnimals typeAnimal = TypeAnimals.NONE;
        String type = null;
        while (true) {
            type = prompt(
                    "\nВведите тип животного, которое хотели бы добавить (DOG, CAT, HAMSTER, HORSE, CAMEL, DONKEY): ")
                    .toUpperCase();
            try {
                typeAnimal = TypeAnimals.valueOf(type);
                break;
            } catch (Exception e) {
                System.out.println("Неопознанное животное!");
            }
        }

        try {
            // ANIMAL
            Date birthday = null;
            ArrayList<String> commands = null;

            String tempBirthday = null;
            String tempCommands = null;

            // name
            String name = prompt("Введите имя животного: ");

            // birthday
            do {
                tempBirthday = prompt("Введите дату рождения животного в формате dd-MM-yyyy (Н-р 01-12-2020): ");
                if (Validation.isDateValid(tempBirthday)) {
                    break;
                } else {
                    System.out.println("Некорректный формат даты рождения или введена несуществующая дата!");
                }
            } while (true);
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                birthday = format.parse(tempBirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // commands

            do {
                tempCommands = prompt(
                        "Введите команды, которые умеет выполнять животное через запятую и пробел (Н-р Сидеть, Лежать, Гавкать): ");
                if (Validation.isCommands(tempCommands)) {
                    String[] str = tempCommands.split("[,\\s]+");
                    commands = new ArrayList<>();
                    for (String command : str) {
                        commands.add(command);
                    }
                    break;
                } else {
                    System.out.println("Некорректный ввод!");
                }
            } while (true);

            String ownersFirstName = null;
            String ownersLastName = null;
            Double bearingForce = 0.0;

            if (typeAnimal == TypeAnimals.DOG || typeAnimal == TypeAnimals.CAT || typeAnimal == TypeAnimals.HAMSTER) {
                // Pet
                ownersFirstName = prompt("Введите фамилию хозяина: ");
                ownersLastName = prompt("Введите имя хозяина: ");
            } else {
                // PackAnimal
                bearingForce = dPrompt("Введите грузоподъемность (разделитель - запятая): ");
            }

            switch (typeAnimal) {
                case DOG:
                    String stock = prompt("Введите название породы: ");
                    return (new Dog(type, name, birthday, commands, ownersLastName, ownersFirstName, stock));
                case CAT:
                    String color = prompt("Введите окрас: ");
                    return (new Cat(type, name, birthday, commands, ownersLastName, ownersFirstName, color));
                case HAMSTER:
                    String genus = prompt("Введите название породы: ");
                    return (new Hamster(type, name, birthday, commands, ownersLastName, ownersFirstName, genus));
                case HORSE:
                    String kind = prompt("Введите род: ");
                    return (new Horse(type, name, birthday, commands, bearingForce, kind));
                case CAMEL:
                    Integer numberOfHumps = iPrompt("Введите количество горбов: ");
                    return (new Camel(type, name, birthday, commands, bearingForce, numberOfHumps));
                case DONKEY:
                    String stock_donkey = prompt("Введите род: ");
                    return (new Donkey(type, name, birthday, commands, bearingForce, stock_donkey));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Date setDate() {
        String birthday = null;
        do {
            System.out.println();
            birthday = prompt("Введите дату рождения животного в формате dd-MM-yyyy (Н-р 01-12-2020): ");
            if (Validation.isDateValid(birthday)) {
                break;
            } else {
                System.out.println("Некорректный формат даты рождения или введена несуществующая дата!");
            }
        } while (true);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date birthdate = null;
        try {
            birthdate = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthdate;
    }

}
