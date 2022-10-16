package maluevartem.dao_layer_hibernate_jparepositories.service;

import maluevartem.dao_layer_hibernate_jparepositories.model.Persons;
import maluevartem.dao_layer_hibernate_jparepositories.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Persons> getPersonsByCity(String city) {
        if (isEmpty(city)) {
            return null;
        }
        return repository.getPersonsByCity(city);
    }

    public List<Persons> getPersonsByAge(int age) {
        if (isEmptyNumber(age)) {
            return null;
        }
        return repository.getPersonsByAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surname) {
        if (isEmpty(name) || isEmpty(surname)) {
            return null;
        }
        return repository.getPersonsByNameAndSurname(name, surname);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmptyNumber(int number) {
        return number < 0 || number > 120;
    }
}
