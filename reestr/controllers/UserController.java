package reestr.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import reestr.model.Animal;
import reestr.model.Repository;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void addAnimal(Animal animal) throws Exception {
        repository.createAnimal(animal);
    }

    public List<Animal> readAnimalList() {
        return repository.getAllAnimals();
    }

    public ArrayList<String> listCommands(String userId) throws Exception {
        return repository.listCommands(userId);
    }

    public void addCommand(String userId, String newCommand) {
        repository.addCommand(userId, newCommand);
    }

    public List<Animal> birthdayList(Date birthday) throws Exception {
        return repository.birthdayList(birthday);
    }

    public List<Animal> AnimalList() {
        return repository.getAllAnimals();
    }

}
