package reestr.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Repository {

    public List<Animal> getAllAnimals();

    public String createAnimal(Animal animal);

    public ArrayList<String> listCommands(String userId) throws Exception;

    public void addCommand(String userId, String newCommand);

    public List<Animal> birthdayList(Date birthdate) throws Exception;

}