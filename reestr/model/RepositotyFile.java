package reestr.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.css.Counter;

public class RepositotyFile implements Repository {
    private UserMapper mapper;
    private FileOperation fileOperation;

    public RepositotyFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
        this.mapper = new UserMapper2();
    }

    @Override
    public String createAnimal(Animal animal) {
        List<Animal> animals = getAllAnimals();
        int max = 0;
        for (Animal item : animals) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        animal.setId(id);
        animals.add(animal);
        saveAnimals(animals);
        return id;
    }

    private void saveAnimals(List<Animal> animals) {
        List<String> lines = new ArrayList<>();
        for (Animal item : animals) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public List<Animal> getAllAnimals() {
        List<String> lines = fileOperation.readAllLines();
        List<Animal> animals = new ArrayList<>();
        for (String line : lines) {
            animals.add(mapper.map(line));
        }
        return animals;
    }

    @Override
    public ArrayList<String> listCommands(String animalId) throws Exception {
        List<Animal> animals = getAllAnimals();

        for (Animal animal : animals) {
            if (animal.getId().equals(animalId)) {
                return animal.getCommands();
            }
        }
        throw new Exception("Animal does not found");
    }

    @Override
    public void addCommand(String animalId, String newCommand) {
        List<Animal> animals = getAllAnimals();
        for (Animal animal : animals) {
            if (animal.getId().equals(animalId)) {
                animal.newCommand(newCommand);
                break;
            }
        }
        saveAnimals(animals);
    }

    @Override
    public List<Animal> birthdayList(Date birthdate) throws Exception {
        List<Animal> animals = getAllAnimals();
        List<Animal> animals_bd = new ArrayList<Animal>();
        for (Animal animal : animals) {
            if (animal.getBirthday().toString().equals(birthdate.toString())) {
                animals_bd.add(animal);
            }
        }
        if (animals_bd.isEmpty())
            throw new Exception("Animals with such birthday do not found");
        else
            return animals_bd;
    }

}
